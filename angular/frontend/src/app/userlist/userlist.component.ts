import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-userlist',
  templateUrl: './userlist.component.html',
  styleUrls: ['./userlist.component.css']
})
export class UserlistComponent implements OnInit {
  data: any;
  
  constructor(public userService: UserService) {

  }

  ngOnInit(): void {
    this.getUserData();

  }
  getUserData() {
    console.log('Get All User Data');
    const promise = this.userService.get();
    promise.subscribe((res: any) => {
      console.log(res);
      this.data = res

    }, (error: any) => {
      console.log(error);
    });
  }


  delteUser(user: any) {
    if(confirm("Are u sure u want to delete")){
    console.log("deleteuser");
    const promise = this.userService.delete(user.id);
    promise.subscribe((res: any) => {
      console.log(res);

      this.data = res;
    }, (error: any) => {
      console.log(error);
    });
    console.log("userlist after deletion")
    
  }
}
}
