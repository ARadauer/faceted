import {Component, OnInit} from "@angular/core";
import {QuizService} from "./quiz.service";
import {QuizResult} from "../../typings/fcc";

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.scss']
})
export class QuizComponent implements OnInit {

  onLoadErrorMsg: string;

  quizResult: QuizResult;


  constructor(private quizService: QuizService) {

  }

  ngOnInit() {

    console.log('ng init von driver class');
    this.start();
  }


  start() {
    this.quizService.start('Andreas', 'mail@radauer.com').subscribe(
        quizResult => this.quizResult = quizResult,
        error => this.onLoadErrorMsg = <any>error);
  }

}