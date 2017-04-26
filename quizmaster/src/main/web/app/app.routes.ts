import {Routes} from "@angular/router";
import {QuizComponent} from "./quiz/quiz.component";
import {QuizResultComponent} from "./quiz-result/quiz-result.component";

export const AppRoutes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: QuizComponent
  },
  {
    path: 'results',
    pathMatch: 'full',
    component: QuizResultComponent
  }
];
