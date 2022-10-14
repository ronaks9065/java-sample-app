<template>
  <div class="welcome-page" v-if="renderPage">
    <video autoplay muted loop playsinline id="welcome-bg">
      <source src="../assets/images/welcome-bg.mp4" type="video/mp4" />
    </video>

    <div id="welcome-box">
      <div id="datenschutz-logo" class="welcome-part" ref="logo">
        <img src="../assets/images/logos/kozern-logo-2x.png" alt="logo" />
        <!-- <img src="../assets/images/maps/map-intro-desktop.jpg" alt="" /> -->
      </div>

      <h3 ref="title" class="colorbluedark welcome-title">
        Willkommen beim Datenschutz-Navi
      </h3>
      <div class="welcome-text bluegrey" ref="text">
        Sie wollen, dass Ihre Daten gut geschützt sind – genau wie die meisten
        Menschen. Und die neuen EU-Gesetze (Stichwort: DSGVO) verpflichten uns
        alle dazu, mit Personen-Daten sorgfältig umzugehen. Was das bedeutet,
        steht in diesem Datenschutz-Navi: mit Navi-Spiel, Quiz und einer
        leckeren Belohnung am Ende.
      </div>
      <router-link
        tag="button"
        :disabled="cookiesAccepted"
        class="btn--standard welcome-part welcome-button"
        data-name="button_text"
        :to="{ name: 'rules' }"
        >{{
          this.$store.state.language === "Deutsch" ? "Weiter" : "Continue"
        }}</router-link
      >
    </div>

    <div v-show="cookiesAccepted" class="myModal">
      <div class="myModal__text spanparent">
        <span ref="modal-text">
          Notification regarding
        </span>
        <span
          ><router-link to="terms">{{
            this.$store.state.language === "Deutsch"
              ? "Nutzungshinweise."
              : "Terms of Use."
          }}</router-link></span
        >
      </div>
      <button class="myModal__button btn--standard" @click="commitCookies">
        {{
          this.$store.state.language === "Deutsch" ? "Akzeptieren" : "Accept"
        }}
      </button>
    </div>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
import { contentService } from "../services/content.service";

export default {
  data: () => ({
    renderPage: true
  }),
  computed: {
    ...mapState(["cookiesAccepted", "language"])
  },
  name: "welcome",
  mounted() {
    // SET QUIZ TOPIC
    this.commitSelectQuiz("nonQuiz");

    this.fetchContent();
    document.getElementById("nav").style.position = "relative";
    document.getElementById("nav").style.top = "0px";
  },
  created() {
    this.$store.subscribe((mutation, state) => {
      if (mutation.type === "mutateLanguage") {
        this.fetchContent();
      }
    });
  },
  methods: {
    ...mapActions(["commitCookies", "commitSelectQuiz"]),
    fetchContent: function() {
      contentService
        .getContents("welcome", this.$store.state.language)
        .then(data => {
          this.renderPage = true;
          contentService.replaceContents(this.$refs, data);
          data.forEach(d => {
            // if there is a ref for this content.
            contentService.fillBoxes(d, this.contents);
          });
        });
    },
    nextPage: function() {
      this.$router.push({ path: "rules" });
    }
  }
};
</script>

<style scoped lang="scss">
a {
  color: #335f7d !important;
}

a:hover {
  color: #8dbfcf !important;
}
</style>
