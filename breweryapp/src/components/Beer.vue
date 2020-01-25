<template>
  <div class="list">
    <h1>{{beerInfo.name}}</h1>
    <img
      v-if="beerInfo.labels"
      :src="beerInfo.labels.medium"
      :alt="beerInfo.name"
      :title="beerInfo.name"
    />
    <h4 v-if="beerInfo.abv">ABV: {{beerInfo.abv}}%</h4>
    <h4 v-if="beerInfo.ibu">IBU: {{beerInfo.ibu}}</h4>
    <h4>Organic: {{beerInfo.isOrganic}}</h4>
    <p v-if="beerInfo.description">{{beerInfo.description}}</p>
    <br />
    <h4 v-if="beerInfo.style.description">Style: {{beerInfo.style.name}}</h4>
    <p v-if="beerInfo.style.description">{{beerInfo.style.description}}</p>
    <br />
    <h4 v-if="ingredients">Ingredients:</h4>
    <table v-if="ingredients" style="width:100%">
      <tr>
        <th>Ingredient type</th>
        <th>Ingredient name</th>
      </tr>
      <tr v-for="ingredient of ingredients" :key="ingredient.id">
        <td>{{ingredient.categoryDisplay}}</td>
        <td>{{ingredient.name}}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Beer",
  data() {
    return {
      beerInfo: {},
      ingredients: [],
      errors: [],
      key: "5865f650b89955e6f423714b51a83354",
      apiUrl: "https://api.brewerydb.com/v2/locations/brewery"
    };
  },

  created() {
    axios
      .get("http://localhost:8083/beer/" + this.$route.params.id)
      .then(response => {
        this.beerInfo = response.data.data;
      })
      .catch(e => {
        this.errors.push(e);
      });

    axios
      .get("http://localhost:8083/ingredients/" + this.$route.params.id)
      .then(response => {
        this.ingredients = response.data.data;
      })
      .catch(e => {
        this.errors.push(e);
      });
  }
};
</script>


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