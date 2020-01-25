<template>
  <div class="list">
    <h1>Brewery List</h1>
    <p>Here's the list:</p>
    <ul v-if="brewList && brewList.length">
      <li v-for="brewery of brewList" v-bind:key="brewery.id">
        <p>
          <strong>
            <a v-bind:href="'/brewery/'+ brewery.id">{{brewery.name}}</a>
          </strong>
        </p>
        <p v-if="brewery.description">{{brewery.description}}</p>
        <br v-if="brewery.description" />
      </li>
    </ul>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Breweries",
  data() {
    return {
      brewList: [],
      errors: [],
      key: "5865f650b89955e6f423714b51a83354",
      apiUrl: "https://api.brewerydb.com/v2/locations/"
    };
  },
  created() {
    axios
      .get("http://localhost:8083/list")
      .then(response => {
        console.log("here");
        this.brewList = response.data.data;
        console.log(this.brewList);
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