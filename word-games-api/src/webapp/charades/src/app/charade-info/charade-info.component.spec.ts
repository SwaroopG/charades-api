import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CharadeInfoComponent } from './charade-info.component';

describe('CharadeInfoComponent', () => {
  let component: CharadeInfoComponent;
  let fixture: ComponentFixture<CharadeInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CharadeInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CharadeInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
