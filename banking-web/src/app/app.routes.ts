import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: '',
        loadComponent: () => import('./modules/home-page/home-page.component').then(m => m.HomePageComponent)
    },
    {
        path: 'client',
        loadComponent: () => import('./modules/client/client-list/client-list.component').then(m => m.ClientListComponent)
    },
    {
        path: 'account',
        loadComponent: () => import('./modules/account/account-list/account-list.component').then(m => m.AccountListComponent)
    },
    {
        path: 'movement',
        loadComponent: () => import('./modules/movement/movement-list/movement-list.component').then(m => m.MovementListComponent)
    }
];
