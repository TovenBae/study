<template>
    <div>
        <h1>SideBar</h1>
        <input type="number" step="0.0001" class="form-control" v-model="latitude">
        <input type="number" step="0.0001" class="form-control" v-model="longitude">
        <button @click="addMarker" class="btn btn-danger">Add Marker</button>
        <button @click="clearMarkers" class="btn btn-default">Clear Marker</button>
    </div>
</template>

<style scoped>

</style>

<script>
export default  {

    data() {
        return {
            latitude: EventBus.sanfrancisco[0],
            longitude: EventBus.sanfrancisco[1]
        }
    },
    methods: {
        addMarker() {
            EventBus.$emit('add-marker', {
                latitude: Number(this.latitude),
                longitude: Number(this.longitude)
            })
        },
        clearMarkers() {
            EventBus.$emit('clear-markers')
        }
    }
}
</script>

