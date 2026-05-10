import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  private apiurl: string = 'http://localhost:8080/api/account';

  constructor(
    private http: HttpClient,
  ) {
  }

  public saveAccount(client: any): Observable<any> {
      return this.http.post(`${this.apiurl}/saveAccount`, client);
  }
    
  
  public getAllAccounts(): Observable<any> {
    return this.http.get(`${this.apiurl}/getAllAccount`);
  }

  public findByClientClientId(clientId: number): Observable<any> {
    return this.http.get(`${this.apiurl}/findByClientClientId/${clientId}`);
  }
}
