import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CharadeinfoComponent } from './charadeinfo/charadeinfo.component';

@NgModule({
  declarations: [
    AppComponent,
    CharadeinfoComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
