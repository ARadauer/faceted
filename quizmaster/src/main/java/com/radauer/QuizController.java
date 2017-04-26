package com.radauer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Andreas on 17.04.2017.
 */
@RestController
public class QuizController {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private ResultService resultService;

    private Questions questions = new Questions();

    @RequestMapping("/quiz")
    public QuizResult answer(@RequestParam(value = "q", required = false) Integer question,
                             @RequestParam(value = "a", required = false) Integer answer) {

        QuizSession quizSession = getQuizSession();
        if (quizSession == null) {
            return createMessageResult("Start the Quiz", false);
        }

        if (question == null) {
            return createResult(quizSession, "Answer to which Question?");
        }
        if (answer == null) {
            return createMessageResult("No answer found!", true);
        }

        if (question != quizSession.getCurrentQuestion()) {
            return createResult(quizSession, "Wrong question!");
        }

        boolean correct = evaluateAnswer(answer, quizSession);
        return createResult(quizSession, correct ? "Correct!" : "Wrong!");
    }

    @RequestMapping("/start")
    public QuizResult start(@RequestParam(value = "name") String name, @RequestParam(value = "email") String email,
                            @RequestParam(value = "company") String company) {

        if (resultService.containsEmail(email)) {
            return createMessageResult("You have already played", false);
        }

        QuizSession qs = new QuizSession();
        qs.setEmail(email);
        qs.setUser(name);
        qs.setCompany(company);
        qs.setQuizStart(System.currentTimeMillis());
        qs.setPoints(0);

        httpSession.setAttribute("quizSession", qs);

        return createResult(qs, "Here we go!");
    }

    @RequestMapping("/result")
    public List<ResultTo> result() {

        return resultService.getResults();
    }

    private boolean evaluateAnswer(int answer, QuizSession quizSession) {
        Question question = questions.getQuestion(quizSession.getCurrentQuestion());
        quizSession.setCurrentQuestion(quizSession.getCurrentQuestion() + 1);
        if (question.getCorrectAnswer() == answer) {
            quizSession.setPoints(quizSession.getPoints() + 1);
            return true;
        }
        return false;
    }

    private QuizResult createResult(QuizSession session, String message) {
        QuizResult result = new QuizResult();
        result.setMessage(message);
        result.setFinished(false);
        result.setStarted(true);

        result.setUser(session.getUser());

        result.setPoints(session.getPoints());
        result.setTimeInSeconds((int) ((System.currentTimeMillis() - session.getQuizStart()) / 1000));
        result.setCurrentQuestion(session.getCurrentQuestion());
        result.setNumberOfQuestions(questions.size());
        if (session.getCurrentQuestion() >= questions.size()) {
            finish(result, session);

        } else {
            fillQuestion(result, session);
        }

        return result;
    }

    private void finish(QuizResult result, QuizSession session) {
        result.setMessage(result.getMessage() + " Quiz has finished!");
        result.setFinished(true);

        resultService.addResult(
                new Result(result.getUser(), session.getEmail(), session.getCompany(), result.getPoints(), result.getTimeInSeconds()));

        httpSession.invalidate();
    }

    private void fillQuestion(QuizResult result, QuizSession session) {

        Question question = questions.getQuestion(session.getCurrentQuestion());
        result.setQuestion(question.getQuestion());
        result.setAnswers(question.generateAnswersForResult());
    }


    private QuizResult createMessageResult(String message, boolean started) {
        QuizResult result = new QuizResult();
        result.setMessage(message);
        result.setStarted(started);
        return result;
    }

    private QuizSession getQuizSession() {
        return (QuizSession) httpSession.getAttribute("quizSession");
    }
}
