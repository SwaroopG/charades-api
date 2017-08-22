import {Component} from "@angular/core";
import {CharadeInfo} from "./CharadeInfo";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Charades - Telugu Movie Names!';
  selectedCharade: CharadeInfo = {id: 1, title: 'Test Title', dubtitle: 'Dub Title', director: 'Swaroop', cast: 'Raj', year: 2001};
}
