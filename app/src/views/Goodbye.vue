<template>
  <div id="menu">
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
      <hr width="24%" class="hr__narrow" />
      <img
        src="../assets/images/logos/kozern-logo-4x.png"
        alt="Volkswagen logo"
        class="menu__data-logo"
      />
      <hr width="24%" class="hr__narrow2" />
    </div>

    <div>
      <p class="goodbye goodbye__title" ref="text-1">
        Vielen Dank und auf Wiedersehen!
      </p>
      <p class="goodbye goodbye__text" ref="text-2">
        Viel Erfolg bei der täglichen Arbeit und bei der Anwendung des
        Erlernten.
      </p>
    </div>

    <div class="goodbye__container">
      <a href="https://volkswagen-net.de" class="btn__end--2 goodbye__button">
        <div style="width: 100%; margin-top: 5px; text-align: center;">
          {{
            this.$store.state.language === "Deutsch"
              ? "Jetzt Verlassen"
              : "Exit"
          }}
        </div>
      </a>
      <router-link
        tag="button"
        to="welcome"
        class="btn__end--1 goodbye__button"
        >{{
          this.$store.state.language === "Deutsch"
            ? "Weitermachen"
            : "Return to Start"
        }}</router-link
      >
    </div>
  </div>
</template>

<script>
import { mapActions } from "vuex";
import { contentService } from "../services/content.service";

export default {
  name: "goodbye",
  data: () => ({
    renderPage: false
  }),
  methods: {
    ...mapActions(["commitSelectQuiz"]),
    fetchContent: function() {
      contentService
        .getContents("goodbye", this.$store.state.language)
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
  mounted() {
    this.fetchContent();
    this.commitSelectQuiz("end1");
  }
};
</script>
