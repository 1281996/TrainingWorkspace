import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';



import { HttpClientModule } from '@angular/common/http';
import { UserformComponent } from './userform/userform.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './home/home.component';
import { UserlistComponent } from './userlist/userlist.component';
@NgModule({
  declarations: [
    AppComponent,
    UserformComponent,
    HomeComponent,
    UserlistComponent
  ],
  imports: [
    BrowserModule,FormsModule,HttpClientModule, AppRoutingModule,ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
