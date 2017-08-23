import {Component} from "@angular/core";
import {CharadeInfo} from "./charadeinfo";
import {CharadeService} from "./charade.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [CharadeService]
})
export class AppComponent {
  title = 'Charades';
  selectedCharade: CharadeInfo;

  constructor(private charadeService: CharadeService) {
  }

  ngOnInit() {
    this.charadeService.getCharade().then(charade => this.selectedCharade = charade);
  }

  reloadPage() {
    window.location.reload();
  }
}
