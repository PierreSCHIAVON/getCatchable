import { Component, OnInit } from '@angular/core';
import { Catchable } from '../catchable';
import { CatchableService } from '../catchable.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-list-catchable',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './list-catchable.component.html',
})
export class ListCatchableComponent implements OnInit{

  catchableList : Catchable[]|undefined;

  constructor (private catchableService : CatchableService ){}
  
  ngOnInit(){
   this.catchableService.getCatchableList().subscribe({
    next: (data : Catchable[]) => {
      this.catchableList = data;
    }, 
      error: (err)=> {
        console.error('Faille to load Catchable List', err)
      }
   })
  }

}
