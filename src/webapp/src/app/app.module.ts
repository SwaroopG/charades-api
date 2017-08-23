import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpModule} from "@angular/http";
import {FormsModule} from "@angular/forms";

import { AppComponent } from './app.component';
import { CharadeInfoComponent } from './charade-info/charade-info.component';
import {CharadeService} from "./charade.service";

import { MaterialModule, MdList, MdListItem } from '@angular/material'
import {MdButtonModule, MdCheckboxModule} from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    CharadeInfoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    MaterialModule,
    BrowserAnimationsModule,
    MdButtonModule, MdCheckboxModule
  ],
  providers: [CharadeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
