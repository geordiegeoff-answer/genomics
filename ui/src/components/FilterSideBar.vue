<template>
    <v-navigation-drawer app temporary dark @change="showFilters = false" v-model="showFilters" >
        <v-list>
            <v-list-tile>
                <v-list-tile-title class="title">
                    FILTERS
                </v-list-tile-title>
            </v-list-tile>
        </v-list>
        <v-autocomplete class="filter" v-model="selectedTrust" :items="trusts" :search-input.sync="search"
                        color="white" label="SELECT TRUST" placeholder="START TYPING TO SEARCH" clearable hide-selected hide-no-data return-object/>
        <v-select class="filter" v-model="selectedTestGroup" :items="testGroups" color="white" hide-selected label="SELECT TEST GROUP" clearable/>
        <v-select class="filter" v-model="selectedLab" :items="labs" clearable color="white" hide-selected label="SELECT LAB"/>
        <v-btn fixed bottom right :disabled="!selectedLab && !selectedTrust && !selectedTestGroup" @click="getRoutes">
            SEARCH
        </v-btn>
        <v-dialog v-model="isLoading" persistent width="300">
            <v-card  dark>
                <v-card-text>
                    PLEASE STAND BY
                    <v-progress-linear indeterminate dark class="mb-0"/>
                </v-card-text>
            </v-card>
        </v-dialog>
    </v-navigation-drawer>
</template>
<script>
    import {getTrusts} from '../services/dataService'
    import {getData} from '../services/dataService';
    import {filter} from '../services/searchService'
    import mutators from '../store/mutators';
    import * as Toastr from 'toastr';
    export default {
        name: "filterSideBar",
        data() {
            return {
                search: null,
                selectedTrust: "",
                trusts:[],
                selectedTestGroup: "",
                selectedLab: "",
                isDisabled: true,
                isLoading: false
            }
        },
        computed: {
            showFilters() {
                return this.$store.state.showFilters
            },
            testGroups() {
                return this.$store.state.data.testNameList;
            },
            labs() {
                return this.$store.state.data.labOdsCodeList;
            },
            mapp() {
                return this.$store.state.gMap;
            },
            routes() {
                return this.$store.state.routes;
            }
        },
        methods: {
            async getTrustRoutes() {
                this.$store.commit(mutators.SET_ROUTES, await getTrusts(this.trustName));
            },
            async getRoutes() {
                this.$store.commit(mutators.SET_SHOW_FILTERS, false);
                this.isLoading = true;
                let hasTestGroup = typeof this.selectedTestGroup !== 'undefined' && this.selectedTestGroup.length > 0;
                let hasTrust = typeof this.selectedTrust !== 'undefined' && this.selectedTrust.length > 0;
                let hasLab = typeof this.selectedLab !== 'undefined' && this.selectedLab.length > 0;

                let testType = hasTestGroup ? `"testType":"${this.selectedTestGroup}"` : "";
                let testTrustJoin = hasTestGroup && hasTrust ? "," : "";
                let trustName = hasTrust ? `"trustName":"${this.selectedTrust}"` : "";
                let testLabJoin = !hasTrust && hasTestGroup && hasLab ? "," : "";
                let trustLabJoin = hasTrust && hasLab ? "," : "";
                let labCode = hasLab ? `"labOds":"${this.selectedLab}"` : "";
                this.$store.commit(mutators.SET_ROUTES, await filter(
                    `{${testType}${testTrustJoin}${trustName}${testLabJoin}${trustLabJoin}${labCode}}`));
                console.log(this.routes);
                this.update();
                this.isLoading = false;
            },
            update() {
                let bounds = new google.maps.LatLngBounds();
                let routes = this.routes;
                let polyLines = this.$store.state.lines;
                let labs = [];

                while(polyLines[0]) {
                    polyLines.pop().setMap(null);
                }

                polyLines = [];
                // bounds.extend(new google.maps.LatLng(53.4822,-2.890583));

                while(routes[0]) {
                    let route = routes.pop();
                    let trustLocation = new google.maps.LatLng(route.trustLatitude, route.trustLongitude);
                    let labLocation = new google.maps.LatLng(route.labLatitude, route.labLongitude);
                    bounds.extend(trustLocation);
                    bounds.extend(labLocation);

                    let line = new google.maps.Polyline({
                        path: [trustLocation, labLocation],
                        strokeColor: "#FF0000",
                        strokeOpacity: 1.0,
                        strokeWeight: 0.2,
                        map: this.mapp
                    });

                    polyLines.push(line);
                }

                this.$store.commit(mutators.SET_LINES, polyLines);

                if (!Array.isArray(polyLines) || !polyLines.length) {
                    Toastr.options.timeOut=3000000;
                    Toastr.warning('NO ROUTES TO DISPLAY...');
                } else {
                    this.mapp.setCenter(bounds.getCenter());
                    this.mapp.fitBounds(bounds);
                }
            }
        },
        async created() {
            this.$store.commit(mutators.SET_DATA, await getData());
        },
        watch: {
            async search(val) {
                this.trusts = await getTrusts(val);
            }
        }
    }
</script>