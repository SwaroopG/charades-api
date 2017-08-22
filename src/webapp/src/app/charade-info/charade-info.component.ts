import { Component, OnInit, Input } from '@angular/core';
import { CharadeInfo } from '../CharadeInfo';

@Component({
  selector: 'app-charade-info',
  templateUrl: './charade-info.component.html',
  styleUrls: ['./charade-info.component.css']
})
export class CharadeInfoComponent implements OnInit {
  @Input() charadeInfo: CharadeInfo;

  constructor() { }

  ngOnInit() {
  }
}
