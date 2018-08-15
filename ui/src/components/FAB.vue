<template>
    <v-fab-transition>
        <v-btn dark bottom left fixed fab @click="onToggle" class="filterButton">
            <v-icon v-if="showFilters">close</v-icon>
            <v-icon v-else>add</v-icon>
        </v-btn>
    </v-fab-transition>
</template>

<script>
    import mutators from '../store/mutators'
    export default {
        name: 'fab',
        computed: {
            showFilters() {
                return this.$store.state.showFilters
            }
        },
        methods: {
            onToggle() {
                this.$store.commit(mutators.SET_SHOW_FILTERS, !this.showFilters)
            }
        }
    }
</script>