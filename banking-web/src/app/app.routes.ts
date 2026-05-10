import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: '',
        loadComponent: () => import('./modules/home-page/home-page.component').then(m => m.HomePageComponent)
    },
    {
        path: 'clientes',
        loadComponent: () => import('./modules/client/client/client.component').then(m => m.ClientComponent)
    }
];
