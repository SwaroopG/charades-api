import { Component, OnInit, Input } from '@angular/core';
import { CharadeInfo } from '../charade-info';

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
