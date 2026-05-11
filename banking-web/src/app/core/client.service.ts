import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private apiurl: string = 'http://localhost:8080/api/client';

  constructor(
    private http: HttpClient,
  ) {
  }

  /**
   * Save client
   * @param client 
   * @returns 
   */
  public saveClient(client: any): Observable<any> {
    return this.http.post(`${this.apiurl}/saveClient`, client);
  }
  
  /**
   * Get all clients
   * @returns 
   */
  public getAllClients(): Observable<any> {
    return this.http.get(`${this.apiurl}/getAllClient`);
  }

}
