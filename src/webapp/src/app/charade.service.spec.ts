import { TestBed, inject } from '@angular/core/testing';

import { CharadeService } from './charade.service';

describe('CharadeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CharadeService]
    });
  });

  it('should be created', inject([CharadeService], (service: CharadeService) => {
    expect(service).toBeTruthy();
  }));
});
