import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'userform',
  templateUrl: './userform.component.html',
  styleUrls: ['./userform.component.css']
})
export class UserformComponent implements OnInit {
user={
  name:"mallika",
  age:23

}
constructor(public userService: UserService) { }

  ngOnInit(): void {
  }
  saveUser(){
    console.log('clicked');
    const promise = this.userService.save(this.user);
    promise.subscribe(res=>{
      console.log(res);
    },(error)=>{
      console.log(error);
    });
  }
}
