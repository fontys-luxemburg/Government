import Vue from 'vue';
import Router from 'vue-router';
import Index from "./components/Index";
import CarsShow from "./components/cars/Show";
import CarsEdit from "./components/cars/Edit";
import CarsTrackers from "./components/cars/Trackers";
import CarsOwner from "./components/cars/Owner";
import VehiclesNew from './components/cars/New';
import CarsTravels from "./components/cars/Travels";
import Login from "./components/Login";
import SearchIndex from './components/search/Index';
import UserShow from "./components/user/Show";
Vue.use(Router);

export const router = new Router({
    routes: [
        {
            path: '/',
            name: 'index',
            component: Index
        },
        {
            path: '/login',
            name: 'login',
            component: Login
        },
        {
            path: '/search',
            name: 'search',
            component: SearchIndex
        },
        {
            path: '/vehicles/new',
            name: 'vehicles#new',
            component: VehiclesNew
        },
        {
            path: '/vehicles/:license_number',
            name: 'vehicles#show',
            component: CarsShow
        },
        {
            path: '/vehicles/:license_number/edit',
            name: 'vehicles#edit',
            component: CarsEdit
        },
        {
            path: '/vehicles/:license_number/trackers',
            name: 'vehicles#trackers',
            component: CarsTrackers
        },
        {
            path: '/vehicles/:license_number/owner',
            name: 'vehicles#owner',
            component: CarsOwner
        },
        {
            path: '/vehicles/:license_number/travels',
            name: 'vehicles#travels',
            component: CarsTravels
        },{
            path: '/drivers/:driver_id',
            name: 'drivers#show',
            component: UserShow
        }
    ]
});


router.beforeEach((to, from, next) => {
    const publicPages = ['/login'];
    const authRequired = !publicPages.includes(to.path);
    const loggedInUser = localStorage.getItem("user");

    if(authRequired && !loggedInUser) {
        return next('/login');
    }

    next();
});
