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

  /**
   * Save account
   * @param client 
   * @returns 
   */
  public saveAccount(client: any): Observable<any> {
      return this.http.post(`${this.apiurl}/saveAccount`, client);
  }
    
  /**
   * Get all accounts
   * @returns 
   */
  public getAllAccounts(): Observable<any> {
    return this.http.get(`${this.apiurl}/findAll`);
  }

  /**
   * Find accounts by client id
   * @param clientId 
   * @returns 
   */
  public findByClientClientId(clientId: number): Observable<any> {
    return this.http.get(`${this.apiurl}/findByClientClientId/${clientId}`);
  }
}
