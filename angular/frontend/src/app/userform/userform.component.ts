import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import {  FormControl,FormBuilder,Validators } from '@angular/forms';
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
users:any[]=[];
constructor(public userService: UserService,private fb:FormBuilder) { }

  ngOnInit(): void {
  }
  saveUser(){
    console.log('clicked');
    const promise = this.userService.save(this.user);
    promise.subscribe((res:any)=>{
      console.log(res);
      this.users.push(res);
      console.log(this.users)
    },(error)=>{
      console.log(error);
    });
  }
  saveUserWithPathVar(){
    console.log('clicked');
    const promise = this.userService.savePathVar(this.user);
    promise.subscribe((res:any)=>{
      console.log(res);
    },(error)=>{
      console.log(error);
    });
  }

  public frmRegister = this.fb.group({
    Name: this.fb.control('',[Validators.required, Validators.minLength(4)]),
    Age: this.fb.control('',[Validators.required])
 })

 get Name(){
   return this.frmRegister.get("Name") as FormControl;
 }
 get Age(){
   return this.frmRegister.get("Age") as FormControl;
 }


}
