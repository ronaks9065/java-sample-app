/* eslint-disable prettier/prettier */
import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

// NOTE: cookiesAccepted true means cookies still need to be accepted, false means they have been accepted

export default new Vuex.Store({
  state: {
    cookiesAccepted: true,
    showMenu: false,
    showMenuLanguage: false,
    language: "Deutsch",
    showMenuContact: false,
    selectedLevel: 1,
    selectedCar: {
      id: 1,
      image: require(`@/assets/images/cars/ID-CROZZ-Drive.png`),
      imageready: require(`@/assets/images/cars/ID-CROZZ-Ready.png`),
      effect: require(`@/assets/images/cars/ID-CROZZ-Effect.png`),
      carName: "ID-CROZZ",
      animationName: "car-enter-1"
    },
    selectedTransition: "fade",
    quizToggle: true,
    currentQuiz: undefined,
    progressBasic: [],
    progressAdvanced: [],
    progressLeader: [],
    userRating: 0,
    showWalkThrough: false
  },
  mutations: {
    initialiseStore(state) {
      // Check if the ID exists
      if (localStorage.getItem("store")) {
        // Replace the state object with the stored item
        this.replaceState(
          Object.assign(state, JSON.parse(localStorage.getItem("store")))
        );
      }
    },
    mutateLanguage(state, payload) {
      state.language = payload;
    },
    reloadProgress(state, payload) {
      state.progressBasic = payload.progressedBasic;
      state.progressAdvanced = payload.progressedAdvanced;
      state.progressLeader = payload.progressedLeader;
    },
    mutateProgressBasic(state, payload) {
      if (!state.progressBasic.includes(payload)) {
        state.progressBasic.push(payload);
      }
    },
    mutateProgressAdvanced(state, payload) {
      if (!state.progressAdvanced.includes(payload)) {
        state.progressAdvanced.push(payload);
      }
    },
    mutateProgressLeader(state, payload) {
      if (!state.progressLeader.includes(payload)) {
        state.progressLeader.push(payload);
      }
    },
    acceptCookies(state) {
      state.cookiesAccepted = false;
    },
    toggleMenu(state) {
      state.showMenu = !state.showMenu;
    },
    toggleMenuLanguage(state) {
      state.showMenuLanguage = !state.showMenuLanguage;
    },
    toggleMenuContact(state) {
      state.showMenuContact = !state.showMenuContact;
    },
    setRating(state, payload) {
      state.userRating = payload;
    },
    toggleQuiz(state) {
      state.quizToggle = !state.quizToggle;
    },
    selectQuiz(state, payload) {
      state.currentQuiz = payload;
    },
    selectLevel(state, payload) {
      state.selectedLevel = payload;
    },
    selectCar(state, payload) {
      state.selectedCar = payload;
    },
    selectTransition(state, payload) {
      state.selectedTransition = payload;
    },
    toggleWalkThrough(state) {
      state.showWalkThrough = !state.showWalkThrough;
    }
  },
  actions: {
    commitLanguage(context, payload) {
      context.commit("mutateLanguage", payload);
    },
    commitProgressReload(context, payload) {
      context.commit("reloadProgress", payload);
    },
    commitProgressBasic(context, payload) {
      context.commit("mutateProgressBasic", payload);
    },
    commitProgressAdvanced(context, payload) {
      context.commit("mutateProgressAdvanced", payload);
    },
    commitProgressLeader(context, payload) {
      context.commit("mutateProgressLeader", payload);
    },
    commitCookies(context) {
      context.commit("acceptCookies");
    },
    commitMenu(context) {
      context.commit("toggleMenu");
    },
    commitMenuLanguage(context) {
      context.commit("toggleMenuLanguage");
    },
    commitMenuContact(context) {
      context.commit("toggleMenuContact");
    },
    commitRating(context) {
      context.commit("setRating");
    },
    commitToggleQuiz(context) {
      context.commit("toggleQuiz");
    },
    commitSelectQuiz(context, payload) {
      context.commit("selectQuiz", payload);
    },
    commitLevel(context, payload) {
      context.commit("selectLevel", payload);
    },
    commitCar(context, payload) {
      context.commit("selectCar", payload);
    },
    commitTransitionAnimation(context, payload) {
      context.commit("selectTransition", payload);
    },
    commitWalkThrough(context) {
      context.commit("toggleWalkThrough");
    }
  },
  getters: {
    getMenu: state => {
      return state.showMenu;
    },
    getSelectedLevel: state => {
      return state.selectedLevel;
    },
    getSelectedCar: state => {
      return state.selectedCar;
    },
    getSelectedTransition: state => {
      return state.selectedTransition;
    },
    getCurrentQuiz: state => {
      return state.currentQuiz;
    },
    getProgressBasic: state => {
      return state.ProgressBasic;
    },
    getProgressAdvanced: state => {
      return state.ProgressAdvanced;
    }
  }
});
