import {Injectable} from "@angular/core";
import {Http, Headers, Response, URLSearchParams} from "@angular/http";
import {Observable} from 'rxjs/Rx';
import "rxjs/add/operator/map";
import {QuizResult, Answer, ResultTo} from "../../typings/fcc";

@Injectable()
export class QuizService {
    private headers = new Headers({'Content-Type': 'application/json'});

    constructor(private http:Http) {
    }

    public start(name:string, email:string, company:string):Observable<QuizResult> {
        let url = `start`;

        let params = new URLSearchParams();
        params.set('name', name);
        params.set('email', email);
        params.set('company', company);

        console.log('params', params);

        return this.http.get(url, {search: params, headers: this.headers})
            .map((res:Response) => res.json() as QuizResult);
    }

    public answer(answer:Answer, currentQuestion:number):Observable<QuizResult> {
        let url = `quiz`;

        let params = new URLSearchParams();
        params.set('q', currentQuestion + '');
        params.set('a', answer.number + '');

        return this.http.get(url, {search: params, headers: this.headers})
            .map((res:Response) => res.json() as QuizResult);
    }

    public result():Observable<ResultTo[]> {
        let url = `result`;

        return this.http.get(url, {headers: this.headers})
            .map((res:Response) => res.json() as ResultTo[]);
    }
}
