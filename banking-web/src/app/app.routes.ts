import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: '',
        loadComponent: () => import('./modules/home-page/home-page.component').then(m => m.HomePageComponent)
    },
    {
        path: 'client',
        loadComponent: () => import('./modules/client/client/client.component').then(m => m.ClientComponent)
    },
    {
        path: 'account',
        loadComponent: () => import('./modules/account/account-list/account-list.component').then(m => m.AccountListComponent)
    }
];
