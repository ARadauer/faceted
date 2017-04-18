import {Routes} from "@angular/router";
import {DriverClassComponent} from "./driver-class/driver-class.component";
import {QuizComponent} from "./quiz/quiz.component";

export const AppRoutes: Routes = [
  {
    path: '',
    redirectTo: 'index',
    pathMatch: 'full'
  },
  {
    path: 'index',
    pathMatch: 'full',
    component: QuizComponent
  }/*,
  {
    path: 'page/driver-class',
    component: DriverClassComponent
  }*/
];
