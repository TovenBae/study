import Vue from 'vue'
import App from './App.vue'
import GoogleMap from './GoogleMap'
import ListView from './ListView'
import Sidebar from './Sidebar'

window.EventBus = new Vue({
  data() {
    return {
      sanfrancisco: [37.505205, 127.049554]
    }
  }
})

Vue.component('GoogleMap', GoogleMap)
Vue.component('ListView', ListView)
Vue.component('Sidebar', Sidebar)

new Vue({
  el: '#app',
  render: h => h(App)
})
