import {Component, Input, OnInit} from "@angular/core";
import {CharadeInfo} from "../charadeinfo";

@Component({
  selector: 'app-charade-info',
  templateUrl: './charade-info.component.html',
  styleUrls: ['./charade-info.component.css']
})
export class CharadeInfoComponent implements OnInit {
  @Input() charadeInfo: CharadeInfo;

  constructor() {
  }

  ngOnInit() {
  }
}
