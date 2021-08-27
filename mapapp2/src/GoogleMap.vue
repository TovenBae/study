<template>
    <div>
        <h1>Map is here</h1>
        <GmapMap
            :center="center"
            :zoom="7"
            map-type-id="terrain"
            style="width: 500px; height: 300px"
            >
            <gmap-info-window :options="infoOptions" :position="infoWindowPos" :opened="infoWinOpen" @closeclick="infoWinOpen=false">
                {{infoContent}}
            </gmap-info-window>
            <GmapMarker
                :key="index"
                v-for="(m, index) in markers"
                :position="m.position"
                :clickable="true"
                :draggable="true"
                @click="toggleInfoWindow(m,index)"
            />
        </GmapMap>
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
import Vue from 'vue'
export default  {
    props: {
        latitude: {
            type: Number,
            default() {
                return EventBus.sanfrancisco[0]
            }
        },
        longitude: {
            type: Number,
            default() {
                return EventBus.sanfrancisco[1]
            }
        },
        zoom: {
            type: Number,
            default() {
                return 14
            }
        }
    },
    created() {
        EventBus.$on('clear-markers', () => {
            this.clearMarkers
            this.$markers = []
        })
        EventBus.$on('add-marker', (data) => {
            let marker = this.makeMarker(data.latitude, data.longitude)
            this.$markers.push(marker)
        })
    },
    data() {
        return {
            infoContent: '',
            infoWindowPos: null,
            infoWinOpen: false,
            currentMidx: null,
            //optional: offset infowindow so it visually sits nicely on top of our marker
            infoOptions: {
                pixelOffset: {
                width: 0,
                height: -35
                }
            },
            center: {
                lat: 37.505205,
                lng: 127.049554
            },
            markers: [
                {
                    position: {
                        lat: 37.505205,
                        lng: 127.049554
                    },
                    infoText: '<img src="https://www.google.co.kr/imgres?imgurl=https%3A%2F%2Fcdn.imweb.me%2Fupload%2FS201905295cee7c0f94cee%2F12d4d58e92dd7.jpeg&imgrefurl=https%3A%2F%2Ftreepla.net%2Fmagazine%2F%3Fq%3DYToxOntzOjEyOiJrZXl3b3JkX3R5cGUiO3M6MzoiYWxsIjt9%26bmode%3Dview%26idx%3D4154746%26t%3Dboard&tbnid=aBhRlymOQw1SDM&vet=12ahUKEwiC1uzC7dDyAhVFYpQKHRioB4kQMygAegUIARDHAQ..i&docid=J104F_QUXK-28M&w=1061&h=1061&q=%EC%8B%9D%EB%AC%BC&hl=ko&ved=2ahUKEwiC1uzC7dDyAhVFYpQKHRioB4kQMygAegUIARDHAQ">'
                }, {
                    position: {
                        lat: 37.505205,
                        lng: 128.049554
                    },
                    infoText: 'Marker 2'
                }]
        }
    },
    methods: {
        makeMarker(latitude, longitude) {
            return new google.maps.Marker({
                position: new google.maps.LatLng(latitude, longitude),
                iocn: null,
                map: this.$map,
                title: null
            })
        },
        clearMarkers() {
            for(let i=0; i<this.$markers.length; i++) {
                this.$markers[i].setMap(null)
            }
        },
        toggleInfoWindow: function(marker, idx) {
            this.infoWindowPos = marker.position;
            this.infoContent = marker.infoText;

            //check if its the same marker that was selected if yes toggle
            if (this.currentMidx == idx) {
                this.infoWinOpen = !this.infoWinOpen;
            }
            //if different marker set infowindow to open and reset current marker index
            else {
                this.infoWinOpen = true;
                this.currentMidx = idx;

            }
        }

    }
}
</script>

