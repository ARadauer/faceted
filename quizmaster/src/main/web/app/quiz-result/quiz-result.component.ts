import {Component, OnInit} from "@angular/core";
import {QuizService} from "../quiz/quiz.service";
import {QuizResult, Answer, ResultTo} from "../../typings/fcc";

@Component({
    selector: 'app-quiz-result',
    templateUrl: './quiz-result.component.html',
    styleUrls: ['./quiz-result.component.scss']
})
export class QuizResultComponent implements OnInit {


    results:ResultTo[];

    constructor(private quizService:QuizService) {

    }

    ngOnInit() {
        this.quizService.result().subscribe(
            results => {
                this.results = results;
                console.log('results', this.results);
            });
    }


}