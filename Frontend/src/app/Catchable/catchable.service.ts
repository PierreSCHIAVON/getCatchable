import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Catchable } from './catchable';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CatchableService {

  private url = 'http://localhost:8080/api'

  constructor (private http : HttpClient){}

  catchableList : Catchable[]|undefined;

  getCatchableList(): Observable<Catchable[]>{
    return this.http.get<Catchable[]>(this.url).pipe(
      map(reponse => {
        return reponse
      })
    );
  }
}
