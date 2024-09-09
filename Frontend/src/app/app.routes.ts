import { Routes } from '@angular/router';

export const routes: Routes = [

    {  path: '', 
        loadComponent: () => import('./Catchable/list-catchable/list-catchable.component') 
        .then(m => m.ListCatchableComponent)
     }

];
