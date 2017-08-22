import { Component, OnInit, Input } from '@angular/core';
import { charadeinfo } from '../charadeinfo';

@Component({
  selector: 'app-charadeinfo',
  templateUrl: './charadeinfo.component.html',
  styleUrls: ['./charadeinfo.component.css']
})
export class CharadeinfoComponent implements OnInit {
  @Input() charadeinfo: charadeinfo;

  constructor() { }

  ngOnInit() {
  }
}
