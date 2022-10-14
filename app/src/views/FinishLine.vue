<template>
  <div class="nav-overlay">
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
    <div class="finish-page">
      <div class="forefront">
        <center>
          <h3 class="finish__title" ref="title">Super gemacht!</h3>
          <p ref="text" class="finish__text bluegrey">
            Sie haben sich Ihre Belohnung verdient. Viel Erfolg bei der
            täglichen Arbeit und bei der Anwendung des Erlernten.
          </p>
        </center>
      </div>

      <div class="finish-car-container">
        <img
          ref="finish-car"
          class="finish__car"
          :src="selectedCar.image"
          :alt="selectedCar.carName"
        />
        <img
          ref="finish-careffect"
          class="finish__careffect"
          :src="selectedCar.effect"
          :alt="selectedCar.carName"
        />
      </div>

      <div class="finish-line-img-container">
        <img
          id="finish-line-img"
          src="../assets/images/map-items/Finish-line-desktop@2x.png"
          alt="finish line"
        />
      </div>
      <router-link
        tag="button"
        to="endpage1"
        class="btn--standard finish__button"
        >{{
          this.$store.state.language === "Deutsch" ? "Weiter" : "Continue"
        }}</router-link
      >
    </div>

    <div>
      <Confetti></Confetti>
    </div>
  </div>
</template>

<script>
import Confetti from "../components/Confetti";
import { mapActions, mapState } from "vuex";
import { contentService } from "../services/content.service";

export default {
  name: "finishline",
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
  components: {
    Confetti
  },
  methods: {
    ...mapActions(["commitSelectQuiz", "commitTransitionAnimation"]),
    fetchContent: function() {
      contentService
        .getContents("finish", this.$store.state.language)
        .then(data => {
          contentService.replaceContents(this.$refs, data);
          // data.forEach(d => {
          //   // if there is a ref for this content.
          //   contentService.fillBoxes(d, this.contents);
          // });
          this.renderPage = true;
        });
    }
  },
  mounted() {
    this.fetchContent();
    // this.commitTransitionAnimation("fade");
    this.commitSelectQuiz("finish");

    this.$refs["finish-car"].style.animation =
      "driveFinish 1s 1 ease-out forwards";
    this.$refs["finish-careffect"].style.animation =
      "driveFinishEffect 1s 1 ease-out forwards";
  }
};
</script>
