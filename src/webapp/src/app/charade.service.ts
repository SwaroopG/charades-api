import {Injectable} from "@angular/core";
import {CharadeInfo} from "./charadeinfo";
import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';


@Injectable()
export class CharadeService {
  private charadeUrl = '/api';

  constructor(private http: Http) {
  }

  getCharade(): Promise<CharadeInfo> {
    return this.http.get(this.charadeUrl)
      .toPromise()
      .then(response => response.json() as CharadeInfo)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}
