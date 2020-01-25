import Vue from 'vue'
import Router from 'vue-router'
import Breweries from './components/Breweries.vue'
import Brewery from './components/Brewery.vue'
import Beer from './components/Beer.vue'

Vue.use(Router)

const router = new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [
      {
        path: '/',
        name: 'breweries',
        component: Breweries,
      },
      {
        path: '/brewery/:id',
        name: 'brewery',
        component: Brewery,
      },
      {
        path: '/beer/:id',
        name: 'beer',
        component: Beer,
      }     
    ]
  })
  
  
  export default router;
  