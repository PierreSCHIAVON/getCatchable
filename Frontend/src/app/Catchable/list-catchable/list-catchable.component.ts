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
export class ListCatchableComponent implements OnInit {
  catchableList: Catchable[] | undefined;
  selectedType: string = 'fish'; // Type sélectionné par défaut

  constructor(private catchableService: CatchableService) {}

  ngOnInit() {
    this.loadList(this.selectedType); // Charger la liste des poissons par défaut
  }

  loadList(type: string) {
    console.log(`Loading list for type: ${type}`); // Débogage
    this.selectedType = type; // Met à jour le type sélectionné
    switch (type) {
      case 'fish':
        this.catchableService.getFishList().subscribe({
          next: (data: Catchable[]) => {
            console.log('Fish list loaded:', data); // Débogage
            this.catchableList = data;
          },
          error: (err) => console.error('Failed to load Fish List', err)
        });
        break;
      case 'bug':
        this.catchableService.getBugList().subscribe({
          next: (data: Catchable[]) => {
            console.log('Bug list loaded:', data); // Débogage
            this.catchableList = data;
          },
          error: (err) => console.error('Failed to load Bug List', err)
        });
        break;
      case 'sea':
        this.catchableService.getSeaCreatureList().subscribe({
          next: (data: Catchable[]) => {
            console.log('Sea Creature list loaded:', data); // Débogage
            this.catchableList = data;
          },
          error: (err) => console.error('Failed to load Sea Creature List', err)
        });
        break;
      case 'now':
        this.catchableService.getCatchableNow().subscribe({
          next: (data: Catchable[]) => {
            console.log('Catchable Now list loaded:', data); // Débogage
            this.catchableList = data;
          },
          error: (err) => console.error('Failed to load Catchable Now', err)
        });
        break;
      default:
        console.error('Unknown type');
    }
  }
}
