<template>
  <div id="menu">
    <div>
      <div class="menu__top-container">
        <div class="menu__top">
          <img
            src="../assets/images/logos/vw-ag-logo-4x.png"
            alt="Volkswagen logo"
            class="menu__logo"
          />
          <router-link to="welcome">
            <img
              src="../assets/images/icons/vw-icon-close-grey-4x.png"
              alt="close"
              class="menu__icon"
            />
          </router-link>
        </div>
        <hr width="24%" style="display: block; margin: 0 auto 12px auto;" />
      </div>
    </div>
    <div style="max-width: 800px; display: block; margin: auto;">
      <div class="end-text" ref="top-text">
        Sie haben erfolgreich am Quiz teilgenommen. Jetzt haben Sie die
        Möglichkeit Ihr Wissen zum Datenschutz noch zu erweitern.
      </div>
      <div class="blue-box-parent-container">
        <div class="blue-box">
          <div class="blue-box__container">
            <img
              class="blue-box__icon"
              src="../assets/images/icons/icon-transmission-4x.png"
              alt
            />
            <p class="blue-box__title" ref="box-1-title">Anwenderschulung</p>
          </div>
          <div ref="box-1-text" class="blue-box__text">
            Seitens des Konzern Datenschutz wird es eine Anwenderschulung (Dauer
            1 Tag) geben. Schwerpunkte der Anwenderschulung sind u. a.:
          </div>
        </div>

        <div class="blue-box">
          <div class="blue-box__container">
            <img
              class="blue-box__icon2"
              src="../assets/images/icons/vw-icon-undercarriage-4x.png"
              alt
            />
            <p class="blue-box__title" ref="box-2-title">Expertschulung</p>
          </div>
          <div ref="box-2-text" class="blue-box__text">
            Seitens des Konzern Rechtswesen wird es eine Expertenschulung (Dauer
            4 Tage + ggf. um einen 1 Tag fachspezifischer Inhalt erweiterbar)
            geben. Schwerpunkte der Expertenschulung sind u. a.:
          </div>
        </div>
      </div>
      <a href="https://group-learn.vwgroup.com" target="blank">
        <button class="buchen-btn">
          {{
            this.$store.state.language === "Deutsch"
              ? "Hier Buchen"
              : "Book Here"
          }}
          <span style="margin-left: 10px; margin-bottom: 5px;">
            <img
              src="../assets/images/icons/icon-link-2x.png"
              alt="link icon"
              class="expertenwissen-page__icon"
            />
          </span>
        </button>
      </a>

      <div>
        <hr class="end-hr" />
        <div class="end-container">
          <router-link tag="button" to="finish" class="btn__end--2">{{
            this.$store.state.language === "Deutsch" ? "Zurück" : "Back"
          }}</router-link>
          <router-link tag="button" to="certificate" class="btn__end--1">{{
            this.$store.state.language === "Deutsch" ? "Weiter" : "Continue"
          }}</router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
import { contentService } from "../services/content.service";

export default {
  name: "endpage1",
  data: () => ({
    renderPage: false
  }),
  methods: {
    ...mapActions(["commitTransitionAnimation"]),
    fetchContent: function() {
      contentService
        .getContents("endpage1", this.$store.state.language)
        .then(data => {
          this.renderPage = true;
          contentService.replaceContents(this.$refs, data);
          data.forEach(d => {
            // if there is a ref for this content.
            contentService.fillBoxes(d, this.contents);
          });
        });
    }
  },
  computed: {
    ...mapState(["language"])
  },
  mounted() {
    this.fetchContent();
  }
};
</script>
