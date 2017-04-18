import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {TabsModule} from "ng2-bootstrap";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {AppComponent} from "./app.component";
import {AppRoutes} from "./app.routes";
import {DriverClassComponent} from "./driver-class/driver-class.component";
import {DriverClassService} from "./driver-class/driver-class.service";
import {QuizComponent} from "./quiz/quiz.component";
import {QuizService} from "./quiz/quiz.service";


@NgModule({
    declarations: [
        AppComponent,
        DriverClassComponent,
        QuizComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        NgbModule.forRoot(),
        RouterModule.forRoot(AppRoutes),
        TabsModule.forRoot()
    ],
    providers: [
        DriverClassService,
        QuizService
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
