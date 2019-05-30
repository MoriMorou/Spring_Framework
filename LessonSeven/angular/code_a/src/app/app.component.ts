import {Component, OnInit} from '@angular/core';
import {User} from "./user";
import {HttpService} from "./http.service";

@Component({
    selector: 'my-app',
    template: `
        <div class="form-group">
            <button class="btn btn-default" (click)="submit()">Отправить</button>
        </div>
        <div *ngIf="done">
            <div>Получено от сервера:</div>
            <div>Имя: {{receivedUser.id}}</div>
            <div>Возраст: {{receivedUser.name}}</div>
        </div>`,
    providers: [HttpService]
})
export class AppComponent {
    receivedUser: User; // полученный пользователь
    done: boolean = false;
    constructor(private httpService: HttpService){}
    submit(){
        this.httpService.getData()
            .subscribe(
                (data: User) => {this.receivedUser=data; this.done=true;},
                error => console.log(error)
            );
    }
}

