import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
const URL = "http://localhost:7777/user"
@Injectable({
  providedIn: 'root'
})
export class UserService {

  save(user: any) {
    console.log("inservice")
    return this.http.post(URL, user);
  }
  savePathVar(user: any) {
    console.log("inservice")
    return this.http.post(URL + '/age/' + 34 + '/height/' + 3.4, user);
  }
get(){
  return this.http.get(URL);
}
delete(id:any){
  console.log("inservice delete")
  return this.http.delete(URL +'/'+id);
}
  constructor(public http: HttpClient) { }
}
