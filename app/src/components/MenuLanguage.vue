<template>
  <div id="menu">
    <div class="menu__top-container">
      <div class="menu__top">
        <img
          src="../assets/images/logos/vw-ag-logo-4x.png"
          alt="Volkswagen logo"
          class="menu__logo"
        />
        <img
          src="../assets/images/icons/vw-icon-close-grey-4x.png"
          alt="close"
          class="menu__icon"
          @click="commitMenuLanguage"
        />
      </div>
      <hr width="24%" class="hr__narrow" />
      <img
        src="../assets/images/logos/kozern-logo-4x.png"
        alt="Volkswagen logo"
        class="menu__data-logo"
      />
    </div>

    <div class="menu__option" @click="selectOption('english')" title="english">
      <hr width="24%" class="hr__narrow hr__narrow--language" />
      <div class="menu__list">
        <p class="menu__list--title" id="menu-option-english">ENGLISH</p>
      </div>
    </div>

    <div class="menu__option" @click="selectOption('deutsch')" title="deutsch">
      <hr width="24%" class="hr__narrow hr__narrow--language hr--selected" />
      <div class="menu__list">
        <p class="menu__list--title menu__option--selected" id="menu-option-deutsch">DEUTSCH</p>
      </div>
    </div>
  </div>
</template>

<script>
import MenuHeading from "./MenuHeading";
import { mapActions, mapState } from "vuex";
import { EventBus } from "../event-bus";

export default {
  name: "menu-language",
  data: function() {
    return {};
  },
  methods: {
    ...mapActions(["commitMenuLanguage", "commitLanguage"]),
    selectOption: function(option) {
      let options = document.getElementsByClassName("menu__option");

      let english = document.getElementById("menu-option-english");
      let deutsch = document.getElementById("menu-option-deutsch");

      let hrs = document.getElementsByClassName("hr__narrow--language");

      if (option === "english") {
        english.classList.add("menu__option--selected");
        deutsch.classList.remove("menu__option--selected");
        hrs[0].classList.add("hr--selected");
        hrs[1].classList.remove("hr--selected");
        this.commitLanguage("Englisch");
      }

      if (option === "deutsch") {
        deutsch.classList.add("menu__option--selected");
        english.classList.remove("menu__option--selected");
        hrs[0].classList.remove("hr--selected");
        hrs[1].classList.add("hr--selected");
        this.commitLanguage("Deutsch");
      }

      this.commitMenuLanguage();
    }
  },
  mounted() {
    EventBus.$on(
      "hotkey-language",
      function() {
        let options = document.getElementsByClassName("menu__option");

        let english = document.getElementById("menu-option-english");
        let deutsch = document.getElementById("menu-option-deutsch");

        let hrs = document.getElementsByClassName("hr__narrow--language");

        if (this.$store.state.language === "Deutsch") {
          english.classList.add("menu__option--selected");
          deutsch.classList.remove("menu__option--selected");
          hrs[0].classList.add("hr--selected");
          hrs[1].classList.remove("hr--selected");
          this.commitLanguage("Englisch");
        } else {
          deutsch.classList.add("menu__option--selected");
          english.classList.remove("menu__option--selected");
          hrs[0].classList.remove("hr--selected");
          hrs[1].classList.add("hr--selected");
          this.commitLanguage("Deutsch");
        }

        this.$forceUpdate();
      }.bind(this)
    );
  }
};
</script>