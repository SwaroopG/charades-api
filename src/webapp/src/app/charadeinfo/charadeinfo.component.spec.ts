import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CharadeinfoComponent } from './charadeinfo.component';

describe('CharadeinfoComponent', () => {
  let component: CharadeinfoComponent;
  let fixture: ComponentFixture<CharadeinfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CharadeinfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CharadeinfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
