import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovementService {

  private apiurl: string = 'http://localhost:8080/api/movement';
  
    constructor(
      private http: HttpClient,
    ) {
    }

    /**
     * Save movement
     * @param movement 
     * @returns 
     */
    public saveMovement(movement: any): Observable<any> {
      return this.http.post(`${this.apiurl}/saveMovement`, movement);
    }
    
    /**
     * Get all movements
     * @returns 
     */
    public getAllMovements(): Observable<any> {
      return this.http.get(`${this.apiurl}/findAll`);
    }

}
