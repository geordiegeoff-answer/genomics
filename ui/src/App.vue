<template>
  <v-app>
    <filter-side-bar></filter-side-bar>
    <router-view></router-view>
    <fab></fab>
    <watermark></watermark>
  </v-app>
</template>

<script>
  import FilterSideBar from "./components/FilterSideBar";
  import Fab from "./components/FAB";
  import Watermark from "./components/Watermark";
  export default {
    name: 'app',
      components: {Fab, FilterSideBar, Watermark},
      data () {
      return {
         text: ''
      }
    }
  }
</script>
