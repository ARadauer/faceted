import {Component, OnInit} from "@angular/core";
import {Response} from "@angular/http";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  private currentTime$: Observable<Date>;
  private currentTime: Date = new Date();

  constructor() {
  }

  ngOnInit() {
    /*this.userService.getDatetime().subscribe((date) => {
        this.currentTime = new Date(date);
      },
      (error: Response) => {
        console.error(error);
      }
    );*/

    this.currentTime$ = Observable.timer(0, 1000).map(() => new Date(this.currentTime.setMilliseconds(this.currentTime.getMilliseconds() + 1000)));
  }
}
