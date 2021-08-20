<template>
    <div>
        <h1>ListView</h1>
        <p>Marker count: {{markers.length}}</p>
        <table class="table">
            <thead>
                <tr>
                    <th>index</th>
                    <th>Latitude</th>
                    <th>Longitude</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="marker in markers" :key="marker.index">
                    <td>{{marker.index}}</td>
                    <td>{{marker.latitude}}</td>
                    <td>{{marker.longitude}}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<style scoped>
    #map {
        margin: 0 auto;
        background: gray;
    }

    .h-250 {
        height: 250px;
    }
</style>

<script>
export default  {
    created() {
        EventBus.$on('clear-markers', () => {
            this.$markers = []
            this.index = 0;
        })
        EventBus.$on('add-marker', (marker) => {
            marker['index'] = this.index
            this.index++
            this.markers.push(marker)
        })
    },
    data() {
        return {
            index: 0,
            markers: []
        }
    }
}
</script>

