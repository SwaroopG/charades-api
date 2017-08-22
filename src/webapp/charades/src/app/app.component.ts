import {Component} from "@angular/core";
import {CharadeInfo} from "./charade-info";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'Charades - Telugu Movie Names';
  selectedCharade: CharadeInfo = {id: 1, title: 'Movie1', director: 'Director1', cast: 'Actor, Actress', year: 2001};
}
