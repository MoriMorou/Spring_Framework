import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class HttpService{

    constructor(private http: HttpClient){ }

    getData(){
       //  return this.http.get('http://jsonplaceholder.typicode.com/posts/1');
        return this.http.get('http://localhost:8189/restapp/api/students/1');
    }
}
