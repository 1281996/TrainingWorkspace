import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
const URL ="http://localhost:7777/user"
@Injectable({
  providedIn: 'root'
})
export class UserService {

  save(user: any) {
    console.log("inservice")
    return this.http.post(URL,user);
  }

  constructor(public http:HttpClient) { }
}
