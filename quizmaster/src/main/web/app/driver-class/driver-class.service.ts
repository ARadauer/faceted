import {Injectable} from "@angular/core";
import {Http, Headers, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/map";
import {DriverClassTO, DriverClassType} from "../../typings/fcc";

@Injectable()
export class DriverClassService {

    private driverClassUrl = `api/driver-class`;
    private headers = new Headers({'Content-Type': 'application/json'});

    constructor(private http:Http) {
    }

    public add(driverClass:DriverClassTO):Observable<DriverClassTO> {
        let url = `${this.driverClassUrl}/add`;

        return this.http.put(url, JSON.stringify(driverClass), {headers: this.headers})
            .map((res:Response) => res.json() as DriverClassTO);
    }

    public update(driverClass:DriverClassTO) {
        let url = `${this.driverClassUrl}/update`;

        return this.http.post(url, JSON.stringify(driverClass), {headers: this.headers})
            .map((res:Response) => res.json() as DriverClassTO);
    }

    public delete(driverClass:DriverClassTO):Observable<Response> {

        if (driverClass != null) {
            let url = `${this.driverClassUrl}/delete/${driverClass.id}`;
            console.log('delete url',url, driverClass);
            return this.http.delete(url);
        }
        return Observable.empty<Response>();
    }

    public getAllForType(driverClassType:DriverClassType):Observable<DriverClassTO[]> {
        let url = `${this.driverClassUrl}/type/${driverClassType}`;
        return this.http.get(url).map((res:Response) => res.json());
    }

    public getAll():Observable<DriverClassTO[]> {
        let url = `${this.driverClassUrl}/all`;
        return this.http.get(url).map((res:Response) => res.json());
    };
}
