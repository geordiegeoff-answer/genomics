import Vue from 'vue'
import Vuex from 'vuex'
import mutators from './mutators'

Vue.use(Vuex);

export default new Vuex.Store({
   state: {
       routes: [],
       showFilters: false,
       gMap: null,
       lines: []
   },
   mutations: {
       [mutators.SET_DATA](state, data) {
           state.data = data;
       },
       [mutators.SET_ROUTES](state, routes) {
           state.routes = routes;
       },
       [mutators.SET_SHOW_FILTERS](state, showFilters) {
           state.showFilters = showFilters;
       },
       [mutators.SET_MAP](state, gMap) {
           state.gMap = gMap;
       },
       [mutators.SET_LINES](state, lines) {
           state.lines = lines;
       },
       [mutators.SET_LABS](state, labs) {
           state.labs = labs;
       }
   }

});