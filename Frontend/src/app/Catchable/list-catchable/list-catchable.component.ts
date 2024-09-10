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

  getFishList(){
    this.catchableService.getFishList().subscribe({
      next: (fish : Catchable[]) => {
        this.catchableList = fish;
      }, 
        error: (err)=> {
          console.error('Faille to load Fish List', err)
        }
     })
  }

  getBugList(){
    this.catchableService.getBugList().subscribe({
      next: (bug : Catchable[]) => {
        this.catchableList = bug;
      }, 
        error: (err)=> {
          console.error('Faille to load Bug List', err)
        }
     })
  }

  getSeaCreatureList(){
    this.catchableService.getSeaCreatureList().subscribe({
      next: ( sea_creature : Catchable[]) => {
        this.catchableList = sea_creature;
      }, 
        error: (err)=> {
          console.error('Faille to load Sea Creature List', err)
        }
     })
  }

  getCatchableNow(){
    this.catchableService.getCatchableNow().subscribe({
      next: ( catchable_now : Catchable[]) => {
        this.catchableList = catchable_now;
      }, 
        error: (err)=> {
          console.error('Faille to load Catchable Now', err)
        }
     })
  }

}
