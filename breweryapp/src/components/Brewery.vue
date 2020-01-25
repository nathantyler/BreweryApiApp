<template>
  <div class="list">
    <h1>Beer List</h1>
    <p v-if="beers && beers.length">Here's the list of beers:</p>
    <p v-if="!beers">(No beers found)</p>
    <ul v-if="beers && beers.length">
      <li v-for="beer of beers" v-bind:key="beer.id">
        <p>
          <strong>
            <a v-bind:href="'/beer/'+ beer.id">{{beer.name}}</a>
          </strong>
        </p>
        <p>{{beer.style.description}}</p>
        <br/>
      </li>
    </ul>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Brewery",
  data() {
    return {
      beers: [],
      errors: [],
      key: "5865f650b89955e6f423714b51a83354",
      apiUrl: "https://api.brewerydb.com/v2/locations/brewery"
    };
  },

  created() {
    axios
      .get("http://localhost:8083/beers/" + this.$route.params.id)
      .then(response => {
        this.beers = response.data.data;
      })
      .catch(e => {
        this.errors.push(e);
      });
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>