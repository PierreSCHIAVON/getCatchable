import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Catchable } from './catchable';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CatchableService {

  private url = 'http://localhost:8080'

  constructor (private http : HttpClient){}

  catchableList : Catchable[]|undefined;

  getCatchableList(): Observable<Catchable[]>{
    return this.http.get<Catchable[]>(`${this.url}/allcatchableitems`).pipe(
      map(reponse => {
        return reponse
      })
    );
  }

  getFishList(): Observable <Catchable[]>{
    return this.http.get<Catchable[]>(`${this.url}/fishes`).pipe(
      map(reponse => {
        return reponse
      })
    );
  }

  getBugList(): Observable <Catchable[]>{
    return this.http.get<Catchable[]>(`${this.url}/bugs`).pipe(
      map(reponse => {
        return reponse
      })
    );
  }

  getSeaCreatureList(): Observable <Catchable[]>{
    return this.http.get<Catchable[]>(`${this.url}/seacreatures`).pipe(
      map(reponse => {
        return reponse
      })
    );
  }

  getCatchableNow(): Observable <Catchable[]>{
    return this.http.get<Catchable[]>(`${this.url}/catchablenow`).pipe(
      map(reponse => {
        return reponse
      })
    );
  }

}
