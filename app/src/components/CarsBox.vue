<template>
  <div class="car-carousel__car quizintro" :id="`car${number}`">
    <img :src="image" :alt="carName" />
    <img class="car-ready" :src="imageready" :alt="carName" />
    <p class="car-carousel__car--description" v-html="carName"></p>
  </div>
</template>

<script>
export default {
  name: "CarsBox",
  props: {
    id: Number,
    number: Number,
    image: String,
    imageready: String,
    carName: String
  }
};
</script>
