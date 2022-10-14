<template>
  <div>
    <hr class="end-hr" />
    <div class="end-container">
      <router-link tag="button" :to="prevPage" class="btn__end--2">Zurück</router-link>
      <div class="dot__container">
        <div class="dot-end"></div>
        <div class="dot-end"></div>
        <div class="dot-end"></div>
      </div>
      <router-link tag="button" :to="nextPage" class="btn__end--1">Weiter</router-link>
    </div>
  </div>
</template>

<script>
import DotIndicator from "./DotIndicator";
import { mapState, mapActions } from "vuex";

export default {
  name: "EndBottom",
  props: {
    prevPage: String,
    nextPage: String
  },
  computed: {
    ...mapState([
      "selectedLevel",
      "selectedCar",
      "selectedTransition",
      "quizToggle",
      "progressBasic",
      "progressAdvanced",
      "currentQuiz"
    ])
  },
  methods: {
    ...mapActions([
      "commitQuizProgressB",
      "commitTransitionAnimation",
      "commitToggleQuiz",
      "commitProgressBasic",
      "commitProgressAdvanced",
      "commitCurrentQuiz"
    ])
  },
  mounted() {
    
  }
};
</script>
