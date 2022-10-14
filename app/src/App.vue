<template>
  <div id="app">
    <Menu v-show="showMenu"></Menu>
    <MenuContact v-show="showMenuContact"></MenuContact>
    <MenuLanguage v-show="showMenuLanguage"></MenuLanguage>
    <Walkthrough v-show="showWalkThrough"></Walkthrough>
    <Navigation></Navigation>
    <transition :name="selectedTransition">
      <router-view />
    </transition>
  </div>
</template>

<script>
import Navigation from "./components/Navigation";
import Menu from "./components/Menu";
import MenuLanguage from "./components/MenuLanguage";
import MenuContact from "./components/MenuContact";
import Walkthrough from "./views/Walkthrough";
import {mapActions, mapState} from "vuex";
import {getUserData} from "./services/access.service";

function getUserDevice() {
  let winwidth = window.innerWidth;

  if (winwidth > 1024) {
    return "desktop";
  } else if (winwidth > 768) {
    return "tablet";
  } else {
    return "mobile";
  }
}

export default {
  computed: {
    ...mapState([
      "selectedTransition",
      "showMenu",
      "showMenuLanguage",
      "showMenuContact",
      "showWalkThrough",
      "currentQuiz",
      "progressBasic",
      "progressAdvanced",
      "progressLeader"
    ])
  },
  methods: {
    ...mapActions([
      "commitTransitionAnimation",
      "commitSelectQuiz",
      "commitProgressReload"
    ])
  },
  name: "home",
  components: {
    Navigation,
    Menu,
    MenuLanguage,
    MenuContact,
    Walkthrough
  },
  beforeCreate() {
    this.$store.commit("initialiseStore");
  },
  mounted() {
    // Request user data from server and update progress if out of sync
    getUserData(getUserDevice()).then(res => {
      if (
        res.data.progressedBasic.length > this.progressBasic.length ||
        res.data.progressedAdvanced.length > this.progressAdvanced.length ||
        res.data.progressedLeader.length > this.progressLeader.length
      ) {
        this.commitProgressReload(res.data);
      }
    });

    // Subscribe to store updates
    this.$store.subscribe((mutation, state) => {
      // Store the state object as a JSON string
      localStorage.setItem("store", JSON.stringify(state));
    });

    // Reload current quiz on page refresh
    let reloadUrl = new URL(window.location.href);
    let reloadPage = reloadUrl.searchParams.get("page");
    if (reloadPage) {
      this.$router.push(reloadPage);
    }
  }
};
</script>

<style lang="scss">
@import "assets/sass/main.scss";
</style>
