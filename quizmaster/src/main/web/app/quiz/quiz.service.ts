import {Injectable} from "@angular/core";
import {Http, Headers, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/map";
import {QuizResult} from "../../typings/fcc";

@Injectable()
export class QuizService {
private headers = new Headers({'Content-Type': 'application/json'});

    constructor(private http:Http) {
    }

    public start(user:String, email:string):Observable<QuizResult> {
        let url = `start`;

        return this.http.get(url, {headers: this.headers})
            .map((res:Response) => res.json() as QuizResult);
    }

    public answer(answer:number):Observable<QuizResult> {
        let url = `quiz`;

        return this.http.get(url, {headers: this.headers})
            .map((res:Response) => res.json() as QuizResult);
    }
}
