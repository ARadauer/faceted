package com.radauer;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Andreas on 17.04.2017.
 */
@RestController
public class QuizController
{

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private ResultService resultService;

    private Questions questions = new Questions();

    @RequestMapping("/quiz")
    public QuizResult answer(@RequestParam(value = "q", required = false) Integer question,
        @RequestParam(value = "a", required = false) Integer answer)
    {

        QuizSession quizSession = getQuizSession();
        if (quizSession == null)
        {
            return createMessageResult("Quiz erst starten");
        }

        if (question == null)
        {
            return createResult(quizSession, "Antwort für welche Frage?");
        }
        if (answer == null)
        {
            return createMessageResult("Was ist die Antwort?");
        }

        if (question != quizSession.getCurrentQuestion())
        {
            return createResult(quizSession, "Diese Frage ist nicht dran!");
        }

        boolean correct = evaluateAnswer(answer, quizSession);
        return createResult(quizSession, correct ? "Richtig" : "Falsch");
    }

    @RequestMapping("/start")
    public QuizResult start(@RequestParam(value = "name") String name, @RequestParam(value = "email") String email)
    {

        if (resultService.containsEmail(email))
        {
            return createMessageResult("Sie haben bereits gespielt");
        }

        QuizSession qs = new QuizSession();
        qs.setEmail(email);
        qs.setUser(name);
        qs.setQuizStart(System.currentTimeMillis());
        qs.setPoints(0);

        httpSession.setAttribute("quizSession", qs);

        return createResult(qs, "Jetzt gehts los!");
    }

    @RequestMapping("/result")
    public List<ResultTo> result()
    {

        return resultService.getResults();
    }

    private boolean evaluateAnswer(int answer, QuizSession quizSession)
    {
        Question question = questions.getQuestion(quizSession.getCurrentQuestion());
        quizSession.setCurrentQuestion(quizSession.getCurrentQuestion() + 1);
        if (question.getCorrectAnswer() == answer)
        {
            quizSession.setPoints(quizSession.getPoints() + 1);
            return true;
        }
        return false;
    }

    private QuizResult createResult(QuizSession session, String message)
    {
        QuizResult result = new QuizResult();
        result.setMessage(message);
        result.setFinished(false);

        result.setUser(session.getUser());
        result.setPoints(session.getPoints());
        result.setTimeInSecounds((int) ((System.currentTimeMillis() - session.getQuizStart()) / 1000));
        result.setCurrentQuestion(session.getCurrentQuestion());

        if (session.getCurrentQuestion() >= questions.size())
        {
            finish(result, session);

        }
        else
        {
            fillQuestion(result, session);
        }

        return result;
    }

    private void finish(QuizResult result, QuizSession session)
    {
        result.setMessage(result.getMessage() + " Quiz ist beendet");
        result.setFinished(true);

        resultService.addResult(
            new Result(result.getUser(), session.getEmail(), result.getPoints(), result.getTimeInSecounds()));

        httpSession.invalidate();
    }

    private void fillQuestion(QuizResult result, QuizSession session)
    {

        Question question = questions.getQuestion(session.getCurrentQuestion());
        result.setQuestion(question.getQuestion());
        result.setAnswers(question.getAnswers());
    }

    private QuizResult createMessageResult(String message)
    {
        QuizResult result = new QuizResult();
        result.setMessage(message);
        return result;
    }

    private QuizSession getQuizSession()
    {
        return (QuizSession) httpSession.getAttribute("quizSession");
    }
}
