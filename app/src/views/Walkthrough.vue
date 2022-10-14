<template>
  <div class="walkthrough-container">
    <div class="walkthrough">
      <div class="menu__top-container">
        <div class="menu__top wtNavColor">
          <img
            src="../assets/images/logos/vw-ag-logo-4x.png"
            alt="Volkswagen logo"
            class="menu__logo"
          />
          <img
            src="../assets/images/icons/vw-icon-close-grey-4x.png"
            alt="close"
            class="menu__icon"
            @click="commitWalkThrough"
          />
        </div>
      </div>

      <!-- PAGE 1 -->
      <div class="wt__container--top" v-show="phase === 1">
        <img
          src="../assets/walkthrough/wtm1.png"
          alt="walkthrough mobile"
          class="wt__image--mobile"
          ref="wt-bg-1-mobile"
        />
        <div class="wt__left">
          <div>
            <div class="wt__title" ref="wt-title-1">
              {{
                this.language === "Deutsch" ? "Zu den Themen" : "To the Topics"
              }}
            </div>
            <div class="wt__text" ref="wt-text-1">
              {{
                this.language === "Deutsch"
                  ? "Hier sind alle Themen mit direkten Links zu finden."
                  : "Here you can find all topics with direct links."
              }}
            </div>
          </div>
          <div>
            <div id="dot__container4" class="dot__container">
              <div class="dot-end dot-current"></div>
              <div class="dot-end"></div>
              <div class="dot-end"></div>
              <div class="dot-end"></div>
            </div>
            <div id="dot__container3" class="dot__container paddingtop">
              <div class="dot-end dot-current"></div>
              <div class="dot-end"></div>
              <div class="dot-end"></div>
              <div class="dot-end"></div>
            </div>
            <div>
              <button class="btn__end--1 wt__button" @click="updatePhase(2)">
                {{ this.language === "Deutsch" ? "Weiter" : "Continue" }}
              </button>
            </div>
          </div>
        </div>
        <video
          autoplay
          muted
          playsinline
          class="wt__image--desktop"
          ref="wt-bg-1-desktop"
        >
          <source src="../assets/walkthrough/wtdt1.mp4" type="video/mp4" />
        </video>
      </div>

      <!-- PAGE 2 -->
      <div class="wt__container--top" v-show="phase === 2">
        <img
          src="../assets/walkthrough/wtm2.png"
          alt="walkthrough mobile"
          class="wt__image--mobile"
        />
        <div class="wt__left">
          <div>
            <div class="wt__title" ref="wt-title-2">
              {{
                this.language === "Deutsch"
                  ? "Ansprechpartner"
                  : "Personal Contacts"
              }}
            </div>
            <div class="wt__text" ref="wt-text-2">
              {{
                this.language === "Deutsch"
                  ? "Hier finden Sie Ansprechspartner zu Ihren Fragen."
                  : "Here you will find contact persons for all your questions."
              }}
            </div>
          </div>
          <div>
            <div id="dot__container4" class="dot__container">
              <div class="dot-end"></div>
              <div class="dot-end dot-current"></div>
              <div class="dot-end"></div>
              <div class="dot-end"></div>
            </div>
            <div id="dot__container3" class="dot__container paddingtop">
              <div class="dot-end"></div>
              <div class="dot-end dot-current"></div>
              <div class="dot-end"></div>
              <div class="dot-end"></div>
            </div>
            <div class="wt__button-container">
              <button class="btn--secondary wt__button" @click="updatePhase(1)">
                {{ this.language === "Deutsch" ? "Zurück" : "Back" }}
              </button>
              <button class="btn__end--1 wt__button" @click="updatePhase(3)">
                {{ this.language === "Deutsch" ? "Weiter" : "Continue" }}
              </button>
            </div>
          </div>
        </div>
        <video
          autoplay
          muted
          playsinline
          class="wt__image--desktop"
          ref="wt-bg-1-desktop"
        >
          <source src="../assets/walkthrough/wtdt2.mp4" type="video/mp4" />
        </video>
      </div>

      <!-- PAGE 3 -->
      <div class="wt__container--top" v-show="phase === 3">
        <img
          src="../assets/walkthrough/wtm3.png"
          alt="walkthrough mobile"
          class="wt__image--mobile"
        />
        <div class="wt__left">
          <div>
            <div class="wt__title" ref="wt-title-3">
              {{ this.language === "Deutsch" ? "Quiz an/aus" : "Quiz on/off" }}
            </div>
            <div class="wt__text" ref="wt-text-3">
              {{
                this.language === "Deutsch"
                  ? "Hier können Sie das Quiz an- oder ausschalten."
                  : "Here you can switch the quiz on or off."
              }}
            </div>
          </div>
          <div>
            <div id="dot__container4" class="dot__container">
              <div class="dot-end"></div>
              <div class="dot-end"></div>
              <div class="dot-end dot-current"></div>
              <div class="dot-end"></div>
            </div>
            <div id="dot__container3" class="dot__container paddingtop">
              <div class="dot-end"></div>
              <div class="dot-end"></div>
              <div class="dot-end dot-current"></div>
              <div class="dot-end"></div>
            </div>
            <div class="wt__button-container">
              <button class="btn--secondary wt__button" @click="updatePhase(2)">
                {{ this.language === "Deutsch" ? "Zurück" : "Back" }}
              </button>
              <button class="btn__end--1 wt__button" @click="updatePhase(4)">
                {{ this.language === "Deutsch" ? "Weiter" : "Continue" }}
              </button>
            </div>
          </div>
        </div>
        <video
          autoplay
          muted
          playsinline
          class="wt__image--desktop"
          ref="wt-bg-1-desktop"
        >
          <source src="../assets/walkthrough/wtdt3.mp4" type="video/mp4" />
        </video>
      </div>

      <!-- PAGE 4 -->
      <div class="wt__container--top" v-show="phase === 4">
        <img
          src="../assets/walkthrough/wtm4.png"
          alt="overlay"
          class="wt__image--mobile"
        />
        <div class="wt__left">
          <div>
            <div class="wt__title" ref="wt-title-4">
              {{ this.language === "Deutsch" ? "Mehr Infos" : "More Info" }}
            </div>
            <div class="wt__text" ref="wt-text-4">
              {{
                this.language === "Deutsch"
                  ? "Hier kommen Sie direkt zu Beispielen, mehr Infos/Links und zum Quiz."
                  : "Here you can directly access examples, more info/links and the quiz."
              }}
            </div>
          </div>
          <div>
            <div id="dot__container4" class="dot__container">
              <div class="dot-end"></div>
              <div class="dot-end"></div>
              <div class="dot-end"></div>
              <div class="dot-end dot-current"></div>
            </div>
            <div id="dot__container3" class="dot__container paddingtop">
              <div class="dot-end"></div>
              <div class="dot-end"></div>
              <div class="dot-end"></div>
              <div class="dot-end dot-current"></div>
            </div>
            <div class="wt__button-container">
              <button class="btn--secondary wt__button" @click="updatePhase(3)">
                {{ this.language === "Deutsch" ? "Zurück" : "Back" }}
              </button>
              <button class="btn__end--1 wt__button" @click="updatePhase(5)">
                {{ this.language === "Deutsch" ? "Weiter" : "Continue" }}
              </button>
            </div>
          </div>
        </div>
        <video
          autoplay
          muted
          playsinline
          class="wt__image--desktop"
          ref="wt-bg-1-desktop"
        >
          <source src="../assets/walkthrough/wtdt4.mp4" type="video/mp4" />
        </video>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";

export default {
  name: "walkthrough",
  data: function() {
    return {
      phase: 1
    };
  },
  computed: {
    ...mapState(["language"])
  },
  methods: {
    ...mapActions(["commitWalkThrough"]),
    updatePhase: function(phase) {
      this.phase = phase;

      if (this.phase === 5) {
        this.phase = 1;
        this.commitWalkThrough();
      }
    },
    timedPhase: function(phase, animation, animation2) {
      if (window.innerWidth > 400) {
        this.wtTransitionOut(phase, animation);
        setTimeout(() => this.updatePhase(phase), 1300);
        setTimeout(() => this.resetTransitions(phase), 1300);
        setTimeout(() => this.wtTransitionIn(phase, animation2), 1300);
      } else {
        this.updatePhase(phase);
      }
    },
    wtTransitionOut: function(phase, animation) {
      this.$refs[
        `wt-bg-${phase - 1}-desktop`
      ].style.animation = `${animation} 1.3s ease-in forwards`;
      this.$refs[
        `wt-bg-${phase - 1}-overlay`
      ].style.animation = `${animation} 1.3s ease-in forwards`;
    },
    wtTransitionIn: function(phase, animation2) {
      this.$refs[
        `wt-bg-${phase}-desktop`
      ].style.animation = `${animation2} 1.3s ease-out forwards`;
    },
    resetTransitions: function(phase) {
      this.$refs[`wt-bg-${phase - 1}-desktop`].style.animation = "";
      this.$refs[`wt-bg-${phase - 1}-overlay`].style.animation = "";
      this.$refs[`wt-bg-${phase}-desktop`].style.animation = "";
    }
  }
};
</script>
