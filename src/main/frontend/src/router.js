import Vue from 'vue';
import Router from 'vue-router';
import Index from "./components/Index";
import CarsShow from "./components/cars/Show";
import CarsTrackers from "./components/cars/Trackers";
import CarsOwner from "./components/cars/Owner";
import CarsTravels from "./components/cars/Travels";

Vue.use(Router);

export const router = new Router({
    routes: [
        {
            path: '/',
            name: 'index',
            component: Index
        },
        {
            path: '/cars/:license_number',
            name: 'cars#show',
            component: CarsShow
        },
        {
            path: '/cars/:license_number/trackers',
            name: 'cars#trackers',
            component: CarsTrackers
        },
        {
            path: '/cars/:license_number/owner',
            name: 'cars#owner',
            component: CarsOwner
        },
        {
            path: '/cars/:license_number/travels',
            name: 'cars#travels',
            component: CarsTravels
        }
    ]
});
