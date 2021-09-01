<template>
    <div>
        <h1>Map is here</h1>
        <GmapMap
            :center="center"
            :zoom="zoom"
            map-type-id="terrain"
            style="width: 800px; height: 500px"
            >
            <gmap-info-window :options="infoOptions" :position="infoWindowPos" :opened="infoWinOpen" :content="infoContent" @closeclick="infoWinOpen=false">
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
    },
    created() {
        EventBus.$on('clear-markers', () => {
            this.clearMarkers
            this.markers = []
        })
        EventBus.$on('add-marker', (data) => {
            let marker = this.makeMarker(data.latitude, data.longitude)
            console.log(marker)
            this.markers.push(marker)
        })
    },
    data() {
        return {
            infoContent: '',
            zoom: 15,
            infoWindowPos: null,
            infoWinOpen: false,
            currentMidx: null,
            //optional: offset infowindow so it visually sits nicely on top of our marker
            infoOptions: {
                pixelOffset: {
                    width: 0,
                    height: -35
                },
                content: '<div id="content">'+
      '<div id="siteNotice">'+
      '</div>'+
      '<h1 id="firstHeading" class="firstHeading">Uluru</h1>'+
      '<div id="bodyContent">'+
        '<img src="https://blog.kakaocdn.net/dn/t35FD/btqDMkNayHT/FsVWXjmm8wsuep7awA80Lk/img.png" width="500px" height="600px">'+
      '</div>'+
      '</div>'
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
                    infoText: ''
                }, {
                    position: {
                        lat: 37.505205,
                        lng: 128.049554
                    },
                    infoText: 'Marker 2 '
                }]
        }
    },
    methods: {
        makeMarker(latitude, longitude) {
            console.log(this.markers)
            return {
                position: {
                    lat: latitude,
                    lng: longitude
                },
                infoText: ''
            }
            // return new google.maps.Marker({
            //     position: new google.maps.LatLng(latitude, longitude),
            //     iocn: null,
            //     map: this.$map,
            //     title: null
            // })
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

