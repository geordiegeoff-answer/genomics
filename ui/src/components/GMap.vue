<template>
    <v-content>
        <div id="map-test" ref="map"/>
    </v-content>
</template>
<script>
    import {getLabLocations} from '../services/searchService'
    import mutators from '../store/mutators';

    export default {
        name: "gmap",
        data() {
            return {};
        },
        methods: {

        },
        computed: {
            mapp() {
                return this.$store.state.gMap;
            },
            routes() {
                return this.$store.state.routes;
            },
            labs() {
                return this.$store.state.labs;
            }
        },
        created() {

        },
        async mounted() {
            let labs = await getLabLocations();
            let m = new google.maps.Map(this.$refs.map, {
                center: {lat: 53.4822, lng: -2.890583},
                zoom: 8,
                disableDefaultUI: true,
                zoomControl: true
            });

            let labMarkers = [];

            for (let i in labs) {
                let marker = new google.maps.Marker({
                    position: new google.maps.LatLng(labs[i].latitude,labs[i].longitude),
                    title:`${labs[i].name}, ${labs[i].postcode}`
                });

                marker.setMap(m);
                labMarkers.push(marker);
            }

            this.$store.commit(mutators.SET_LABS, labMarkers);
            this.$store.commit(mutators.SET_MAP, m);
        }
    }
</script>
