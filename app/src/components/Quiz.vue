<template>
  <div>
    <div>
      <img
        class="load-wheel"
        src="../assets/images/load-wheel.svg"
        alt="loading..."
        v-show="!this.contentLoaded || !this.quizLoaded"
      />
    </div>
    <div
      id="quizComponentContainer"
      v-show="this.contentLoaded && this.quizLoaded"
    >
      <div style="max-width: 1224px; position: relative;">
        <!-- TRANSITION MAP MOBILE -->
        <img
          id="transition-map"
          src="../assets/images/maps/map-transition.jpg"
          alt="map"
          ref="transition-map"
        />
        <img
          id="transition-map1"
          src="../assets/images/maps/map-transition.jpg"
          alt="map"
          ref="transition-map1"
        />
        <!-- TRANSITION MAP DESKTOP -->
        <img
          id="transition-map2"
          src="../assets/images/maps/map-transition.jpg"
          alt="map"
          ref="transition-map2"
          class="zoom"
        />
        <img
          id="transition-map3"
          src="../assets/images/maps/map-transition.jpg"
          alt="map"
          ref="transition-map3"
          class="zoom"
        />
        <!-- MAP FOR MOBILE -->
        <img id="quiz__map" :src="mapMobile" alt="map" ref="map-mobile" />

        <!-- MAP FOR DESKTOP -->
        <img
          id="quiz__map2"
          :src="mapDesktop"
          alt="map"
          ref="map-desktop"
          class="zoom"
        />
      </div>

      <div class="quiz-page">
        <div class="quiz__top">
          <!-- QUIZ TOGGLE SWITCH -->
          <div class="quiz__toggle" ref="quiztoggleswitch">
            <label class="switch">
              <input
                type="checkbox"
                checked
                id="quizSwitch"
                ref="quizSwitch"
                @click="
                  showQuiz(quizToggle, commitToggleQuiz),
                    setButtonClass(selectedLevel),
                    setToggleText()
                "
              />
              <span class="slider round"></span>
              <span class="switch-text" ref="toggle-text">Quiz</span>
            </label>
          </div>

          <!-- TRAFFIC LIGHT -->
          <div :id="this.quizObstacleClass" ref="quiz-obstacle" class>
            <img :src="this.quizObstacle" alt />
          </div>
          <!-- <div id="secondary-obstacle-container"> -->
          <div
            :id="this.quizObstacleSecondaryClass"
            ref="quiz-obstacle-secondary"
            class
          >
            <img :src="quizObstacleSecondary" alt />
          </div>
          <!-- </div> -->
          <div :id="this.quizPreObstacleClass" ref="quiz-pre-obstacle" class>
            <img :src="quizPreObstacle" alt />
          </div>

          <div
            id="quiz-light-indicator"
            class="quiz-light-indicator"
            ref="quizlightindicator"
          >
            <p
              class="quiz-light-indicator__text"
              ref="quiz-light-indicator__text"
            >
              {{ this.indicatorText }}
            </p>
            <img
              class="quiz-light-indicator__light"
              :src="trafficLightImage"
              alt
            />
          </div>

          <!-- CAR -->
          <div class="quiz__car-container">
            <div class="quiz__car-container--car" id="car" ref="car">
              <img :src="selectedCar.image" :alt="selectedCar.carName" />
            </div>
            <div
              class="quiz__car-container--effect"
              id="car--effect"
              ref="careffect"
            >
              <img :src="selectedCar.effect" alt="effect" />
            </div>
          </div>

          <!-- HEADING CONTAINER -->
          <div class="quiz__heading">
            <div id="indicatorContainerParent" class="quiz__heading--progress">
              <!-- RADIAL INDICATOR -->
              <div ref="radial-ref" id="indicatorContainer"></div>
              <div id="radialLevelIndicator">
                {{ this.computedProgress }}/{{
                  this.selectedLevel === 4 ? 6 : 12
                }}
              </div>
            </div>
            <div class="quiz__heading--title" ref="heading-title-mobile">
              Title
            </div>

            <div class="quiz__heading--more" data-toggle="dropdown">
              <img src="../assets/images/icons/anchormen.png" alt="nav icon" />
            </div>
            <img
              src="../assets/images/misc/glance-effect.png"
              id="glance1"
              alt="glance effect"
            />

            <!-- IN QUIZ NAV MOBILE -->
            <transition name="dropDown">
              <div class="dropdown-menu">
                <a class="dropdown-item" href="#erklarung-anchor">
                  {{ this.language === "Deutsch" ? "Erklärung" : "Statement" }}
                  <span class="dot">•</span>
                </a>
                <a class="dropdown-item" href="#beispiel-anchor">
                  {{ this.language === "Deutsch" ? "Beispiel" : "Example" }}
                  <span class="dot">•</span>
                </a>
                <a class="dropdown-item" href="#mehr-anchor">
                  {{ this.language === "Deutsch" ? "Mehr Infos" : "More Info" }}
                  <span class="dot">•</span>
                </a>
                <a class="dropdown-item" href="#quiz-anchor">
                  Quiz
                  <span class="dot">•</span>
                </a>
              </div>
            </transition>
          </div>
        </div>

        <div id="quiz__content" class="quiz__content" ref="quiz-content-ref">
          <div class="quiz__heading2">
            <div class="quiz__heading2--progress">
              <div
                ref="radial-desktop-ref"
                id="indicatorContainerDesktop"
              ></div>
              <div id="radialLevelIndicator2">
                {{ this.computedProgress }}/{{
                  this.selectedLevel === 4 ? 6 : 12
                }}
              </div>
            </div>
            <div class="quiz__heading2--title" ref="heading-title">Title</div>
            <img
              src="../assets/images/misc/glance-effect.png"
              id="glance2"
              alt="glance effect"
            />
          </div>

          <!-- QUIZ INFORMATION -->
          <div class="quiz__textscontainer">
            <div class="dropdown-desktop">
              <a
                class="dropdown-desktop-item dropdown-desktop-active"
                href="#erklarung-anchor"
                @click="() => this.scrollMapMobile()"
              >
                {{ this.language === "Deutsch" ? "Erklärung" : "Statement" }}
                <span class="dot">•</span>
              </a>
              <a
                class="dropdown-desktop-item"
                href="#beispiel-anchor"
                @click="() => this.scrollMapMobile()"
              >
                {{ this.language === "Deutsch" ? "Beispiel" : "Example" }}
                <span class="dot">•</span>
              </a>
              <a
                class="dropdown-desktop-item"
                href="#mehr-anchor"
                @click="() => this.scrollMapMobile()"
              >
                {{ this.language === "Deutsch" ? "Mehr Infos" : "More Info" }}
                <span class="dot">•</span>
              </a>
              <a
                class="dropdown-desktop-item"
                href="#quiz-anchor"
                @click="() => this.scrollMapMobile()"
              >
                Quiz
                <span class="dot">•</span>
              </a>
            </div>
            <div class="quiz__texts">
              <div class="u-bandaid"></div>
              <div id="quizscroll" ref="quizscroll">
                <!-- STATEMENT -->
                <a href="" class="anchorNav" id="erklarung-anchor"></a>
                <h3 id="erklarung" ref="statement-title" class="colorbluedark">
                  Statement Heading
                </h3>
                <p class="bluegrey listparent margintop" ref="statement-text">
                  Statement Text
                </p>
                <p
                  class="bluegrey listparent"
                  ref="statement-text-advanced"
                ></p>
                <hr />

                <!-- EXAMPLE -->
                <a href="" class="anchorNav" id="beispiel-anchor"></a>
                <h3
                  id="beispiel"
                  ref="example-title"
                  class="colorbluedark paddingbottom"
                  v-if="this.examples > 0"
                >
                  {{
                    this.$store.state.language === "Deutsch"
                      ? "Beispiel"
                      : "Example"
                  }}
                </h3>

                <span ref="example-img-1" class="example-media">
                  <img src="" alt="" />
                </span>

                <p
                  ref="example-img-1-description"
                  class="example-image-description bluegrey"
                  v-if="this.examples > 0"
                >
                  Example image 1 description
                </p>

                <span ref="example-img-2" v-if="this.examples > 1">
                  <img src="" alt="" />
                </span>

                <p
                  ref="example-img-2-description"
                  class="example-image-description bluegrey"
                  v-if="this.examples > 1"
                >
                  Example image 2 description
                </p>

                <span ref="example-img-3" v-if="this.examples > 2">
                  <img src="" alt="" />
                </span>

                <p
                  ref="example-img-3-description"
                  class="example-image-description bluegrey"
                  v-if="this.examples > 2"
                >
                  Example image 3 description
                </p>
                <hr />

                <!-- MORE INFO -->
                <a href="" class="anchorNav" id="mehr-anchor"></a>
                <h3
                  id="mehr"
                  ref="info-title"
                  class="colorbluedark paddingbottom"
                >
                  {{
                    this.$store.state.language === "Deutsch"
                      ? "Mehr Infos"
                      : "More Information"
                  }}
                </h3>
                <p class="bluegrey listparent" ref="info-text">
                  Informational text and links
                </p>
                <hr />
              </div>

              <!-- INTERACTIVE QUIZ QUESTIONS -->
              <a href="" class="anchorNav" id="quiz-anchor"></a>
              <div id="quiz" :class="this.quizToggle ? '' : 'quiz__disabled'">
                <h3
                  id="quiz__title"
                  :class="
                    this.quizToggle
                      ? 'colorbluedark paddingbottom'
                      : 'paddingbottom'
                  "
                  ref="quiz-title"
                >
                  Quiz
                </h3>

                <QuizQuestion
                  :quiz="contents[0]"
                  v-on:selectAnswer="contents[0].correct = $event"
                  v-on:selectedAnswers="storeAnswers"
                  class="quiz0-q1"
                  id="quizBasicDom"
                ></QuizQuestion>

                <QuizQuestion
                  v-if="this.contents.length > 1 && this.selectedLevel !== 1"
                  :quiz="contents[1]"
                  v-on:selectAnswer="contents[1].correct = $event"
                  v-on:selectedAnswers="storeAnswers"
                  class="quiz--inactive"
                  id="quizAdvancedDom"
                ></QuizQuestion>
              </div>

              <div class="quiz-page__buttons">
                <router-link
                  tag="button"
                  :to="prevPage"
                  class="btn--secondary quiz-page__button"
                  data-name="btnBack"
                  >{{
                    this.$store.state.language === "Deutsch" ? "Zurück" : "Back"
                  }}</router-link
                >

                <button
                  v-if="quizToggle"
                  :class="this.setButtonClass(quizToggle)"
                  @click="
                    checkBasicQuiz(
                      selectedLevel,
                      commitProgressBasic,
                      progressBasic
                    )
                  "
                >
                  {{ this.buttonText }}
                </button>

                <button
                  id="repeat-btn"
                  class="btn--standard quiz-page__button quiz-page__button--incorrect"
                  @click="this.resetQuiz"
                  style="display: none"
                >
                  {{
                    this.$store.state.language === "Deutsch"
                      ? "Wiederholen"
                      : "Repeat"
                  }}
                </button>

                <button
                  @click="nextLevelNoQuiz()"
                  v-if="!quizToggle"
                  id="nextQuizButton1"
                  class="btn--standard quiz-page__button"
                  data-name="btnNext"
                >
                  {{
                    this.$store.state.language === "Deutsch"
                      ? "Weiter"
                      : "Continue"
                  }}
                </button>

                <button
                  v-if="quizToggle"
                  id="btn-check-advanced"
                  :class="this.setButtonClass(quizToggle)"
                  @click="
                    checkAdvancedQuiz(
                      selectedLevel,
                      commitProgressAdvanced,
                      progressAdvanced,
                      commitProgressLeader,
                      progressLeader
                    )
                  "
                  style="display: none"
                >
                  {{ this.buttonText }}
                </button>

                <button
                  @click="nextLevel()"
                  v-if="quizToggle"
                  id="nextQuizButton2"
                  class="btn--standard quiz-page__button"
                  data-name="btnNext"
                  style="display: none"
                >
                  {{
                    this.$store.state.language === "Deutsch"
                      ? "Weiter"
                      : "Continue"
                  }}
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import QuizQuestion from "../components/QuizQuestion";
import radialIndicator from "radial-indicator";
import { mapMutations, mapActions, mapState } from "vuex";
import { contentService } from "../services/content.service";
import { EventBus } from "../event-bus";
import {
  postUserDataStart,
  postUserDataFinish
} from "../services/quiz.service";
import { getUserData } from "../services/access.service";

export default {
  name: "quiz",
  computed: {
    ...mapState([
      "selectedLevel",
      "selectedCar",
      "selectedTransition",
      "quizToggle",
      "progressBasic",
      "progressAdvanced",
      "progressLeader",
      "currentQuiz",
      "language",
      "showWalkThrough"
    ]),
    levelIcon: function() {
      if (this.selectedLevel === 1) {
        return require(`@/assets/images/icons/vw-icon-tire-4x.png`);
      } else if (this.selectedLevel === 2) {
        return require(`@/assets/images/icons/icon-transmission-4x.png`);
      } else if (this.selectedLevel === 4) {
        return require(`@/assets/images/icons/vw-icon-steering-wheel-4x.png`);
      }

      return null;
    },
    computedObstacle: function() {
      if (this.quizObstacleClass === "train") {
        if (window.innerWidth > 768) {
          return require("@/assets/images/map-items/train-track-2x-desktop-3.png");
        } else if (window.innerWidth > 1224) {
          return require("@/assets/images/map-items/train-track-2x-desktop-3.png");
        }
      } else {
        return require("@/assets/images/map-items/train-track-2x.png");
      }

      return null;
    },
    computedProgress: function() {
      if (
        this.selectedLevel === 1 ||
        (this.selectedLevel === 2 && this.currentQuiz !== undefined)
      ) {
        return this.currentQuiz.replace(/\D/g, "");
      }

      if (this.selectedLevel === 4) {
        switch (this.currentQuiz) {
          case "quiz13":
            return 0;
          case "quiz14":
            return 1;
          case "quiz15":
            return 2;
          case "quiz16":
            return 3;
          case "quiz17":
            return 4;
          case "quiz18":
            return 5;
          case "quiz19":
            return 6;
          default:
            return null;
        }
      }

      return null;
    }
  },
  components: {
    QuizQuestion
  },
  props: {
    mapMobile: String,
    mapDesktop: String,
    indicatorIncorrect: String,
    indicatorPartial: String,
    indicatorCorrect: String,
    quizObstacle: String,
    quizPreObstacle: String,
    quizObstacleSecondary: String,
    quizObstacleSecondaryClass: String,
    quizObstacleClass: String,
    quizPreObstacleClass: String,
    quizTopic: String,
    nextPage: String,
    prevPage: String
  },
  data: function() {
    return {
      browserIe: !!window.MSInputMethodContext && !!document.documentMode,
      radialObj: {},
      radialObjDesktop: {},
      contents: [
        {
          language: "Deutsch",
          name: "quiz",
          type: "QUIZ",
          level: "basiswissen",
          content: "",
          active: true,
          correct: false,
          baseUrl: "http://localhost:1990/confluence",
          answers: [
            {
              answerText: "",
              correct: ""
            },
            {
              answerText: "",
              correct: ""
            },
            {
              answerText: "",
              correct: ""
            }
          ]
        },
        {
          language: "Deutsch",
          name: "quiz",
          type: "QUIZ",
          level: "anwenderwissen",
          content: "",
          active: true,
          correct: false,
          baseUrl: "http://localhost:1990/confluence",
          answers: [
            {
              answerText: "",
              correct: ""
            },
            {
              answerText: "",
              correct: ""
            }
          ]
        }
      ],
      radius: (5 * window.innerWidth) / 100,
      quizToggleFade: true,
      buttonText:
        this.$store.state.language === "Deutsch" ? "Weiter" : "Continue",
      indicatorText: "Quiz",
      trafficLightImage: this.indicatorIncorrect,
      selectedAnswers: [],
      selectedAnswers2: [],
      animationComplete: false,
      contentLoaded: false,
      quizLoaded: false,
      mobileShift: 0,
      apiData: null,
      examples: 3
    };
  },
  methods: {
    ...mapMutations(["storeQuizProgressB"]),
    ...mapActions([
      "commitQuizProgressB",
      "commitTransitionAnimation",
      "commitToggleQuiz",
      "commitProgressBasic",
      "commitProgressAdvanced",
      "commitProgressLeader",
      "commitSelectQuiz",
      "commitWalkThrough"
    ]),
    setToggleText: function() {
      if (!this.quizToggle) {
        this.$refs["toggle-text"].classList.add("switch-text-off");
      }

      if (this.quizToggle) {
        this.$refs["toggle-text"].classList.remove("switch-text-off");
      }
    },
    checkBasicQuiz: function(selectedLevel, commitProgressBasic) {
      let domAnswers = document.querySelectorAll(".highlight");
      let continueButton = document.getElementsByClassName(
        "quiz-page__button"
      )[1];
      let repeatButton = document.getElementById("repeat-btn");
      let advancedButton = document.getElementById("btn-check-advanced");
      let nextQuizButton2 = document.getElementById("nextQuizButton2");

      // CHANGE ANSWER CLASS DISPLAY
      for (var i = 0; i < domAnswers.length; i++) {
        for (var j = 0; j < this.selectedAnswers.length; j++) {
          if (
            domAnswers[i].innerText === this.selectedAnswers[j].answerText &&
            this.selectedAnswers[j].correct
          ) {
            domAnswers[i].classList.add("quiz-interaction__answer--correct");
          } else if (
            domAnswers[i].innerText === this.selectedAnswers[j].answerText &&
            !this.selectedAnswers[j].correct
          ) {
            domAnswers[i].classList.add("quiz-interaction__answer--incorrect");
          }
        }
      }

      for (var i = 0; i < domAnswers.length; i++) {
        domAnswers[i].classList.remove("highlight");
      }

      if (
        selectedLevel === 1 ||
        this.currentQuiz === "quiz0" ||
        this.currentQuiz === "quiz1" ||
        this.currentQuiz === "quiz2" ||
        this.currentQuiz === "quiz13" ||
        this.currentQuiz === "quiz17" ||
        this.currentQuiz === "quiz18" ||
        this.currentQuiz === "quiz19"
      ) {
        // CHANGE TRAFFIC LIGHT INDICATOR
        if (this.contents[0].correct) {
          this.trafficLightImage = this.indicatorCorrect;
          this.indicatorText =
            this.language === "Deutsch"
              ? "Richtig! Weiter geht´s…"
              : "Correct! Let's continue…";

          continueButton.classList.remove("quiz-page__button--incorrect");
          continueButton.style.display = "none";
          nextQuizButton2.style.display = "block";
          nextQuizButton2.classList.add("quiz-page__button--correct");

          // DISABLE CLICK EVENTS FOR Q1
          let q1 = document.getElementById("quizBasicDom").children;
          for (var i = 0; i < q1.length; i++) {
            q1[i].classList.add("quiz-interaction--no-events");
          }

          // SAVE PROGRESS TO STATE
          if (this.quizToggle) {
            if (
              !this.progressBasic.includes(this.quizTopic) &&
              (this.selectedLevel === 1 || this.selectedLevel === 2)
            ) {
              commitProgressBasic(parseInt(this.quizTopic));
            }

            if (
              !this.progressLeader.includes(this.quizTopic) &&
              this.selectedLevel === 4
            ) {
              this.commitProgressLeader(parseInt(this.quizTopic));
            }
          }

          if (
            this.currentQuiz === "quiz0" ||
            this.currentQuiz === "quiz1" ||
            this.currentQuiz === "quiz2"
          ) {
            if (
              !this.progressAdvanced.includes(this.quizTopic) &&
              this.quizToggle
            ) {
              this.commitProgressAdvanced(parseInt(this.quizTopic));
            }
          }

          // MOVE OBSTACLE
          if (
            this.quizObstacleClass === "ducks" ||
            this.quizObstacleClass === "train"
          ) {
            this.moveObstacle();
          }
        } else {
          this.trafficLightImage = this.indicatorIncorrect;
          this.indicatorText =
            this.language === "Deutsch"
              ? "Leider falsch. Gleich nochmal probieren!"
              : "False. Try again!";

          continueButton.classList.remove("quiz-page__button--correct");
          continueButton.classList.add("quiz-page__button--incorrect");

          continueButton.style.display = "none";
          repeatButton.style.display = "block";
        }
      }

      if (
        selectedLevel === 2 &&
        this.currentQuiz !== "quiz0" &&
        this.currentQuiz !== "quiz1" &&
        this.currentQuiz !== "quiz2"
      ) {
        if (this.contents[0].correct) {
          this.trafficLightImage = this.indicatorPartial;
          this.indicatorText =
            this.language === "Deutsch"
              ? "Richtig! Weiter geht´s …"
              : "Correct! Let's continue …";

          continueButton.classList.remove("quiz-page__button--incorrect");
          advancedButton.classList.add("quiz-page__button--partial-correct");
          this.indicatorText =
            this.language === "Deutsch"
              ? "Gut gemacht - weiter so!"
              : "Well done - one to go!";

          for (var i = 0; i < domAnswers.length; i++) {
            domAnswers[i].classList.add("quiz-page__button--one-correct");
          }

          // DISABLE CLICK EVENTS FOR Q1
          let q1 = document.getElementById("quizBasicDom").children;
          for (var i = 0; i < q1.length; i++) {
            q1[i].classList.add("quiz-interaction--no-events");
          }

          document
            .getElementsByClassName("quiz--inactive")[0]
            .classList.remove("quiz--inactive");

          // SAVE PROGRESS TO STATE
          if (!this.progressBasic.includes(this.quizTopic) && this.quizToggle) {
            commitProgressBasic(parseInt(this.quizTopic));
          }

          continueButton.style.display = "none";
          advancedButton.style.display = "block";
        } else {
          this.trafficLightImage = this.indicatorIncorrect;
          this.indicatorText =
            this.language === "Deutsch"
              ? "Leider falsch. Gleich nochmal probieren!"
              : "False. Try again!";

          continueButton.classList.remove("quiz-page__button--correct");
          continueButton.classList.add("quiz-page__button--incorrect");

          continueButton.style.display = "none";
          repeatButton.style.display = "block";
        }
      }

      if (
        selectedLevel === 4 &&
        this.currentQuiz !== "quiz13" &&
        this.currentQuiz !== "quiz17" &&
        this.currentQuiz !== "quiz18" &&
        this.currentQuiz !== "quiz19"
      ) {
        if (this.contents[0].correct) {
          this.trafficLightImage = this.indicatorPartial;
          this.indicatorText =
            this.language === "Deutsch"
              ? "Gut gemacht - weiter so!"
              : "Well done - one to go!";

          continueButton.classList.remove("quiz-page__button--incorrect");
          advancedButton.classList.add("quiz-page__button--partial-correct");

          for (var i = 0; i < domAnswers.length; i++) {
            domAnswers[i].classList.add("quiz-page__button--one-correct");
          }

          // DISABLE CLICK EVENTS FOR Q1
          let q1 = document.getElementById("quizBasicDom").children;
          for (var i = 0; i < q1.length; i++) {
            q1[i].classList.add("quiz-interaction--no-events");
          }

          document
            .getElementsByClassName("quiz--inactive")[0]
            .classList.remove("quiz--inactive");

          // SAVE PROGRESS TO STATE
          if (
            !this.progressLeader.includes(this.quizTopic) &&
            this.quizToggle
          ) {
            this.commitProgressLeader(parseInt(this.quizTopic));
          }

          continueButton.style.display = "none";
          advancedButton.style.display = "block";
        } else {
          this.trafficLightImage = this.indicatorIncorrect;
          this.indicatorText =
            this.language === "Deutsch"
              ? "Leider falsch. Gleich nochmal probieren!"
              : "False. Try again!";

          continueButton.classList.remove("quiz-page__button--correct");
          continueButton.classList.add("quiz-page__button--incorrect");

          continueButton.style.display = "none";
          repeatButton.style.display = "block";
        }
      }
    },
    checkAdvancedQuiz: function(
      selectedLevel,
      commitProgressAdvanced,
      progressAdvanced
    ) {
      let domAnswers = document.querySelectorAll(".highlight");
      let advancedButton = document.getElementById("btn-check-advanced");
      let repeatButton = document.getElementById("repeat-btn");
      let nextQuizButton2 = document.getElementById("nextQuizButton2");

      // CHANGE ANSWER CLASS DISPLAY
      for (var i = 0; i < domAnswers.length; i++) {
        for (var j = 0; j < this.selectedAnswers.length; j++) {
          if (
            domAnswers[i].innerText === this.selectedAnswers[j].answerText &&
            this.selectedAnswers[j].correct
          ) {
            domAnswers[i].classList.add("quiz-interaction__answer--correct");
          } else if (
            domAnswers[i].innerText === this.selectedAnswers[j].answerText &&
            !this.selectedAnswers[j].correct
          ) {
            domAnswers[i].classList.add("quiz-interaction__answer--incorrect");
          }
        }
      }

      for (var i = 0; i < domAnswers.length; i++) {
        domAnswers[i].classList.remove("highlight");
      }

      // CHANGE TRAFFIC LIGHT INDICATOR
      if (this.contents[1].correct) {
        this.trafficLightImage = this.indicatorCorrect;
        this.indicatorText =
          this.language === "Deutsch"
            ? "Richtig! Weiter geht´s …"
            : "Correct! Let's continue...";

        advancedButton.style.display = "none";
        nextQuizButton2.style.display = "block";
        nextQuizButton2.classList.add("quiz-page__button--correct");

        // DISABLE CLICK EVENTS FOR Q2
        let q2 = document.getElementById("quizAdvancedDom").children;
        for (var i = 0; i < q2.length; i++) {
          q2[i].classList.add("quiz-interaction--no-events");
        }

        // SAVE PROGRESS TO STATE
        if (
          !this.progressAdvanced.includes(this.quizTopic) &&
          this.quizToggle &&
          this.selectedLevel !== 4
        ) {
          commitProgressAdvanced(parseInt(this.quizTopic));
        }

        if (
          !this.progressLeader.includes(this.quizTopic) &&
          this.quizToggle &&
          this.selectedLevel === 4
        ) {
          this.commitProgressLeader(parseInt(this.quizTopic));
        }

        // MOVE OBSTACLE
        if (
          this.quizObstacleClass === "ducks" ||
          this.quizObstacleClass === "train"
        ) {
          this.moveObstacle();
        }
      } else {
        this.trafficLightImage = this.indicatorIncorrect;
        this.indicatorText =
          this.language === "Deutsch"
            ? "Leider falsch. Gleich nochmal probieren!"
            : "False. Try again!";

        advancedButton.classList.remove("quiz-page__button--correct");
        advancedButton.classList.add("quiz-page__button--incorrect");

        advancedButton.style.display = "none";
        repeatButton.style.display = "block";
      }
    },
    resetQuiz: function() {
      let continueButton = document.getElementsByClassName(
        "quiz-page__button"
      )[1];
      let repeatButton = document.getElementById("repeat-btn");

      EventBus.$emit("quizReset");

      this.indicatorText = "Quiz";

      continueButton.classList.remove("quiz-page__button--correct");
      continueButton.classList.remove("quiz-page__button--incorrect");

      continueButton.style.display = "block";
      repeatButton.style.display = "none";

      if (document.getElementById("quizAdvancedDom")) {
        document
          .getElementById("quizAdvancedDom")
          .classList.add("quiz--inactive");
      }
    },
    setButtonClass: function() {
      if (this.quizToggleFade && this.selectedAnswers.length === 0) {
        return "btn--disabled quiz-page__button";
      } else {
        return "btn--standard quiz-page__button";
      }
    },
    storeAnswers: function(e) {
      this.selectedAnswers = e;
    },
    moveObstacle: function() {
      let obstacle = document.getElementById(this.quizObstacleClass);

      if (this.quizObstacleClass === "ducks") {
        let obstacle2 = document.getElementById("duck-baby");

        obstacle.style.animation = "move-ducks 2s ease-in-out 1 forwards";
        if (this.browserIe) {
          obstacle2.style.animation =
            "move-ducks-ie 2s ease-in-out 0.2s 1 forwards";
        } else {
          obstacle2.style.animation =
            "move-ducks 2s ease-in-out 0.2s 1 forwards";
        }

        this.animationComplete = true;
      }

      if (this.quizObstacleClass === "train") {
        let train = document.getElementById("train-train");

        if (window.innerWidth < 768) {
          train.style.animation = "move-train 4s 1 linear forwards";
        } else {
          train.style.animation = "move-train 2s 1 linear forwards";
        }

        let gate = document.getElementById("train-barrier");

        gate.firstChild.src = require("@/assets/images/map-items/train-barrier.gif");

        // REMOVE SCROLL FUNCTION
        document
          .getElementById("quiz__content")
          .removeEventListener("wheel", this.scrollMap);
      }
    },
    scrollMap: function() {
      // VALUES USING 2 GENERALLY DENOTE DESKTOP VERSION
      const quizContent = document.getElementById("quiz__content");

      let quizScroll = document.getElementById("quizscroll");

      let winheight = quizContent.clientHeight;
      let winwidth = window.innerWidth;
      let scrollheight = quizContent.scrollHeight;
      let scrollTop = quizContent.scrollTop;

      let trackLength = scrollheight - winheight;
      let scrolled = (scrollTop / trackLength) * 101;
      let pctScrolled = `${scrolled}%`;
      let bgScroll = `${scrolled - 100}%`;

      let pixelScrolled = (scrollTop / trackLength) * 672;
      let pixelScrolled2 = (scrollTop / trackLength) * 1400;

      let bgPixelScroll = `${1.6 * pixelScrolled - 1394.8}px`;
      let bgPixelScroll2 = `${pixelScrolled2 - 1400}px`;

      let carEffect = document.getElementById("car--effect");
      let carEffectScrollStart = scrolled / 10;
      let carEffectScrollEnd = -(scrolled / 10) + 10.05;

      let quizLightIndicator = document.getElementById("quiz-light-indicator");
      let quizLightIndicatorEnd = -(scrolled / 10) + 10.05;

      if (this.quizPreObstacleClass === "crosswalk") {
        var crossWalk = document.getElementById("crosswalk");
      }
      if (this.quizObstacleClass === "traffic-light") {
        var trafficLight = document.getElementById("traffic-light");
      }

      if (this.quizPreObstacleClass === "stop-road") {
        var crossWalk = document.getElementById("stop-road");
      }
      if (this.quizObstacleClass === "stop-sign-road") {
        var trafficLight = document.getElementById("stop-sign-road");
      }
      if (this.quizObstacleClass === "stop-sign-road-2") {
        var trafficLight = document.getElementById("stop-sign-road-2");
      }

      if (this.quizObstacleClass === "ducks") {
        var trafficLight = document.getElementById("ducks");
      }

      if (this.quizPreObstacleClass === "train-barrier") {
        var crossWalk = document.getElementById("train-barrier");
      }

      if (this.quizObstacleClass === "train") {
        var trafficLight = document.getElementById("train");
        var train = document.getElementById("train-train");
      }

      // NAV BAR
      if (
        winwidth < 768 &&
        document.getElementById("quiz__content").scrollTop < 68
      ) {
        document.getElementById("nav").style.top = `-${scrollTop}px`;
        document.getElementById(
          "quizComponentContainer"
        ).style.top = `-${scrollTop}px`;
      } else if (
        winwidth < 768 &&
        document.getElementById("quiz__content").scrollTop >= 68
      ) {
        document.getElementById("nav").style.top = "-68px";
        document.getElementById("quizComponentContainer").style.top = "-68px";
      }

      // SCROLL INDICATOR
      this.radialObj.animate(scrolled);
      this.radialObjDesktop.animate(scrolled);

      // SCROLL MAP
      let map = document.getElementById("quiz__map");
      let map2 = document.getElementById("quiz__map2");

      map.style.top = bgPixelScroll;
      map2.style.top = bgPixelScroll2;

      // TURN CAR LIGHTS ON & OFF AT 10% and 90% OF SCROLL
      if (scrolled < 90) {
        carEffect.style.opacity = carEffectScrollStart;
      } else {
        carEffect.style.opacity = carEffectScrollEnd;
      }

      // REVEAL QUIZ LIGHT INDICATOR
      if (scrolled < 80) {
        quizLightIndicator.style.opacity = 0;
      } else {
        quizLightIndicator.style.opacity = -(80 - scrolled) / 20;
      }

      // REVEAL CROSS WALK - PRE OBSTACLE
      if (
        this.quizPreObstacleClass !== "train-barrier" &&
        this.quizPreObstacleClass &&
        !this.browserIe
      ) {
        if (winwidth < 768) {
          if (pixelScrolled < 384) {
            crossWalk.style.top = "-185px";
          } else {
            crossWalk.style.top = `${1.5 * pixelScrolled - 955}px`;
          }
        } else if (winwidth < 1024) {
          if (pixelScrolled2 < 800) {
            crossWalk.style.top = "-1570px";
          } else {
            crossWalk.style.top = `${-1570 + (pixelScrolled2 - 800)}px`;
          }
        } else {
          if (pixelScrolled2 < 800) {
            crossWalk.style.top = "-1570px";
          } else {
            crossWalk.style.top = `${-1570 + (pixelScrolled2 - 800)}px`;
          }
        }
      }

      if (
        this.quizPreObstacleClass !== "train-barrier" &&
        this.quizPreObstacleClass !== "stop-road" &&
        this.quizPreObstacleClass &&
        this.browserIe
      ) {
        if (pixelScrolled2 < 800) {
          crossWalk.style.top = "-1570px";
        } else {
          crossWalk.style.top = `${-1570 + (pixelScrolled2 - 587)}px`;
        }
      }

      if (this.quizPreObstacleClass === "stop-road" && this.browserIe) {
        if (pixelScrolled2 < 800) {
          crossWalk.style.top = "-1570px";
        } else {
          crossWalk.style.top = `${-1570 + (pixelScrolled2 - 687)}px`;
        }
      }

      if (this.quizPreObstacleClass === "train-barrier" && !this.browserIe) {
        if (winwidth < 768) {
          if (pixelScrolled < 384) {
            crossWalk.style.top = "-200px";
          } else {
            crossWalk.style.top = `${1.5 * pixelScrolled - 955}px`;
          }
        } else if (winwidth < 1024) {
          if (pixelScrolled2 < 800) {
            crossWalk.style.top = "-1550px";
          } else {
            crossWalk.style.top = `${-1550 + (pixelScrolled2 - 800)}px`;
          }
        } else {
          if (pixelScrolled2 < 800) {
            crossWalk.style.top = "-1550px";
          } else {
            crossWalk.style.top = `${-1550 + (pixelScrolled2 - 800)}px`;
          }
        }
      }

      if (this.quizPreObstacleClass === "train-barrier" && this.browserIe) {
        if (pixelScrolled2 < 800) {
          crossWalk.style.top = "-1550px";
        } else {
          crossWalk.style.top = `${-1550 + (pixelScrolled2 - 687)}px`;
        }
      }

      // REVEAL TRAFFIC LIGHT - OBSTACLE
      if (
        (this.quizObstacleClass === "traffic-light" && !this.browserIe) ||
        (this.quizObstacleClass === "stop-sign-road" && !this.browserIe)
      ) {
        if (winwidth < 768) {
          if (pixelScrolled < 384) {
            trafficLight.style.top = "-227px";
          } else {
            trafficLight.style.top = `${1.5 * pixelScrolled - 975}px`;
          }
        } else if (winwidth < 1024) {
          if (pixelScrolled2 < 800) {
            trafficLight.style.top = "-835px";
          } else {
            trafficLight.style.top = `${-835 + (pixelScrolled2 - 800)}px`;
          }
        } else {
          if (pixelScrolled2 < 800) {
            trafficLight.style.top = "-835px";
          } else {
            trafficLight.style.top = `${-835 + (pixelScrolled2 - 800)}px`;
          }
        }
      }

      if (
        (this.quizObstacleClass === "traffic-light" && this.browserIe) ||
        (this.quizObstacleClass === "stop-sign-road" && this.browserIe)
      ) {
        if (pixelScrolled2 < 800) {
          trafficLight.style.top = "-835px";
        } else {
          trafficLight.style.top = `${-835 + (pixelScrolled2 - 470)}px`;
        }
      }

      if (this.quizObstacleClass === "stop-sign-road-2" && !this.browserIe) {
        if (winwidth < 768) {
          if (pixelScrolled < 384) {
            trafficLight.style.top = "-227px";
          } else {
            trafficLight.style.top = `${1.5 * pixelScrolled - 930}px`;
          }
        } else if (winwidth < 1024) {
          if (pixelScrolled2 < 800) {
            trafficLight.style.top = "-710px";
          } else {
            trafficLight.style.top = `${-710 + (pixelScrolled2 - 820)}px`;
          }
        } else {
          if (pixelScrolled2 < 800) {
            trafficLight.style.top = "-710px";
          } else {
            trafficLight.style.top = `${-710 + (pixelScrolled2 - 820)}px`;
          }
        }
      }

      if (this.quizObstacleClass === "stop-sign-road-2" && this.browserIe) {
        if (pixelScrolled2 < 800) {
          trafficLight.style.top = "-710px";
        } else {
          trafficLight.style.top = `${-710 + (pixelScrolled2 - 500)}px`;
        }
      }

      if (this.quizObstacleClass === "ducks" && !this.browserIe) {
        let duckbaby = document.getElementById("duck-baby");

        if (winwidth < 768) {
          if (pixelScrolled < 384) {
            trafficLight.style.top = "-180px";
            duckbaby.style.top = "-180px";
          } else {
            trafficLight.style.top = `${1.5 * pixelScrolled - 950}px`;
            duckbaby.style.top = `${1.5 * pixelScrolled - 950}px`;
          }
        } else if (winwidth < 1024) {
          if (pixelScrolled2 < 800) {
            trafficLight.style.top = "-945px";
            duckbaby.style.top = "-226px";
          } else {
            trafficLight.style.top = `${-945 + (pixelScrolled2 - 800)}px`;
            duckbaby.style.top = `${-226 + (pixelScrolled2 - 800)}px`;
          }
        } else {
          if (pixelScrolled2 < 800) {
            trafficLight.style.top = "-945px";
            duckbaby.style.top = "-946px";
          } else {
            trafficLight.style.top = `${-745 + (pixelScrolled2 - 800)}px`;
            duckbaby.style.top = `${-1154 + (pixelScrolled2 - 788)}px`;
          }
        }
      }

      if (this.quizObstacleClass === "ducks" && this.browserIe) {
        let duckbaby = document.getElementById("duck-baby");

        if (pixelScrolled2 < 800) {
          trafficLight.style.top = "-945px";
          duckbaby.style.top = "-946px";
        } else {
          trafficLight.style.top = `${-745 + (pixelScrolled2 - 587)}px`;
          duckbaby.style.top = `${-1154 + (pixelScrolled2 - 575)}px`;
        }
      }

      if (this.quizObstacleClass === "train" && !this.browserIe) {
        if (winwidth < 768) {
          if (pixelScrolled < 384) {
            trafficLight.style.top = "-220px";
          } else {
            trafficLight.style.top = `${1.5 * pixelScrolled - 985}px`;
          }
        } else if (winwidth < 1024) {
          if (pixelScrolled2 < 800) {
            trafficLight.style.top = "-270px";
          } else {
            trafficLight.style.top = `${-270 + (pixelScrolled2 - 810)}px`;
          }
        } else {
          if (pixelScrolled2 < 800) {
            trafficLight.style.top = "-270px";
          } else {
            trafficLight.style.top = `${-270 + (pixelScrolled2 - 810)}px`;
          }
        }
      }

      if (this.quizObstacleClass === "train" && this.browserIe) {
        if (pixelScrolled2 < 800) {
          trafficLight.style.top = "-270px";
        } else {
          trafficLight.style.top = `${-270 + (pixelScrolled2 - 710)}px`;
        }
      }

      // DROPDOWN DESKTOP ACTIVE SECTION
      let dropDesk = document.getElementsByClassName("dropdown-desktop-item");
      let dropDeskMobile = document.getElementsByClassName("dropdown-item");
      let dropDeskArray = Array.from(dropDesk);
      let sections = [
        this.$refs["statement-title"],
        this.$refs["example-title"],
        this.$refs["info-title"],
        this.$refs["quiz-title"]
      ];

      for (var i = 0; i < sections.length; i++) {
        if (
          sections[i] !== null &&
          sections[i] !== undefined &&
          sections[i].getBoundingClientRect().bottom < winheight &&
          sections[i].getBoundingClientRect().top >
            sections[i].getBoundingClientRect().height - winheight
        ) {
          dropDesk[i].classList.add("dropdown-desktop-active");
          dropDeskMobile[i].classList.add("dropdown-desktop-active");
        } else {
          dropDesk[i].classList.remove("dropdown-desktop-active");
          dropDeskMobile[i].classList.remove("dropdown-desktop-active");
        }
      }
    },
    showQuiz: function(quizToggle, commitToggleQuiz) {
      commitToggleQuiz();
      this.quizToggleFade = !this.quizToggleFade;

      let quizQuiz = document.getElementById("quiz");
      let quizTitle = document.getElementById("quiz__title");
      let quizAnswers = document.getElementsByClassName(
        "quiz-interaction__answer"
      );

      if (this.quizToggleFade) {
        quizQuiz.classList.remove("quiz__disabled");
        quizTitle.classList.remove("quiz__disabled");

        for (var i = 0; i < quizAnswers.length; i++) {
          quizAnswers[i].classList.remove("quiz__disabled");
        }
      } else {
        quizQuiz.classList.add("quiz__disabled");
        quizTitle.classList.add("quiz__disabled");

        for (var i = 0; i < quizAnswers.length; i++) {
          quizAnswers[i].classList.add("quiz__disabled");
        }
      }

      this.resetQuiz();
    },
    nextLevelNoQuiz: function() {
      // MOVE OBSTACLE
      if (this.quizObstacleClass === "train") {
        this.moveObstacle();
        setTimeout(() => this.nextLevel(), 3000);
      } else if (this.quizObstacleClass === "ducks") {
        this.moveObstacle();
        setTimeout(() => this.nextLevel(), 1500);
      } else {
        this.nextLevel();
      }
    },
    nextLevel: function() {
      // RESEND USER DATA TO BACKEND
      this.sendUserDataFinish();

      // MOVE CAR
      if (this.currentQuiz === "quiz12" && !this.browserIe) {
        if (window.innerWidth < 768) {
          this.$refs["car"].style.animation =
            "move-car-mobile 1.2s ease-in forwards";
          this.$refs["careffect"].style.animation =
            "move-careffect-mobile 1.2s ease-in forwards";
        } else {
          this.$refs["car"].style.animation = "move-car 1.2s ease-in forwards";
          this.$refs["careffect"].style.animation =
            "move-careffect 1.2s ease-in forwards";
        }
      } else {
        this.$refs["careffect"].style.animation =
          "fadein 0.3s ease-in forwards";
      }

      // TRANSITION OUT
      if (window.innerWidth < 768) {
        this.$refs["map-mobile"].style.animation =
          "map-exit-mobile 1.3s ease-in forwards";

        if (this.quizPreObstacleClass === "train-barrier") {
          this.$refs["quiz-obstacle"].style.animation =
            "obstacle-exit-train 1.3s ease-in forwards";
        }

        if (
          !this.animationComplete &&
          this.quizPreObstacleClass !== "train-barrier"
        ) {
          this.$refs["quiz-obstacle"].style.animation =
            "obstacle-exit 1.3s ease-in forwards";
          this.$refs["quiz-obstacle-secondary"].style.animation =
            "obstacle-exit 1.3s ease-in forwards";
        }

        this.$refs["quiz-pre-obstacle"].style.animation =
          "obstacle-exit 1.3s ease-in forwards";
        this.$refs["transition-map"].style.animation =
          "transition-map-exit 1.3s ease-in";
        this.$refs["transition-map2"].style.animation =
          "transition-map-exit 1.3s ease-in";
      }

      if (window.innerWidth > 768) {
        this.$refs["map-desktop"].style.animation =
          "map-exit 1.1s ease-in forwards";

        if (this.browserIe && this.quizPreObstacleClass === "train-barrier") {
          if (!this.animationComplete) {
            this.$refs["quiz-obstacle"].style.animation =
              "obstacle-exit-train-track-ie 0.9s ease-in forwards";
          }

          this.$refs["quiz-pre-obstacle"].style.animation =
            "obstacle-exit-train-barrier-ie 0.9s ease-in forwards";
        } else if (
          this.browserIe &&
          (this.currentQuiz === "quiz4" ||
            this.currentQuiz === "quiz8" ||
            this.currentQuiz === "quiz9")
        ) {
          this.$refs["quiz-obstacle"].style.animation =
            "obstacle-exit2 0.9s ease-in forwards";

          this.$refs["quiz-pre-obstacle"].style.animation =
            "obstacle-exit-crosswalk-ie 0.9s ease-in forwards";
        } else {
          if (!this.animationComplete) {
            this.$refs["quiz-obstacle"].style.animation =
              "obstacle-exit2 0.9s ease-in forwards";
            this.$refs["quiz-obstacle-secondary"].style.animation =
              "obstacle-exit2 0.9s ease-in forwards";
          }

          this.$refs["quiz-pre-obstacle"].style.animation =
            "obstacle-exit2 0.9s ease-in forwards";
        }

        this.$refs["transition-map"].style.animation =
          "transition-map-exit 1.1s ease-in";
        this.$refs["transition-map1"].style.animation =
          "transition-map-exit 1.1s ease-in";
        this.$refs["transition-map2"].style.animation =
          "transition-map-exit 1.1s ease-in";
        this.$refs["transition-map3"].style.animation =
          "transition-map-exit 1.1s ease-in";
      }

      setTimeout(() => this.$router.push(this.nextPage), 1000);
    },
    fetchQuiz: function() {
      contentService
        .getContents(this.$store.state.currentQuiz, this.$store.state.language)
        .then(data => {
          if (data !== null && data !== undefined) {
            let quizzes = data.filter(d => d.type === "QUIZ");
            if (quizzes.length !== 0) {
              this.contents = quizzes;
            }
          } else {
            return;
          }
        })
        .then((this.quizLoaded = true));
    },
    fetchContent: function() {
      contentService
        .getContents(this.$store.state.currentQuiz, this.$store.state.language)
        .then(data => {
          this.apiData = data;
          if (data !== null && data !== undefined) {
            let dataNames = this.apiData.map(macro => macro.name);

            if (
              dataNames.includes("example-img-1-description") &&
              dataNames.includes("example-img-2-description") &&
              dataNames.includes("example-img-3-description")
            ) {
              this.examples = 3;
            } else if (
              dataNames.includes("example-img-1-description") &&
              dataNames.includes("example-img-2-description")
            ) {
              this.examples = 2;
            } else if (dataNames.includes("example-img-1-description")) {
              this.examples = 1;
            } else {
              this.examples = 0;
            }
          } else {
            return;
          }

          if (this.selectedLevel === 1) {
            contentService.replaceContents(
              this.$refs,
              data.filter(d => d.level === "Basic")
            );
          } else if (this.selectedLevel === 2) {
            contentService.replaceContents(
              this.$refs,
              data.filter(d => d.level === "Basic" || d.level === "User")
            );
          } else if (this.selectedLevel === 3) {
            contentService.replaceContents(
              this.$refs,
              data.filter(d => d.level === "Basic")
            );
          } else if (this.selectedLevel === 4) {
            contentService.replaceContents(
              this.$refs,
              data.filter(d => d.level === "Leader")
            );
          }
        })
        .then((this.contentLoaded = true));
    },
    scrollMapMobile: function() {
      setTimeout(() => clearInterval(decelerator), 3000);

      var decelerator = setInterval(this.scrollMap, 10);
    },
    sendUserDataStart: async function() {
      await getUserData();
      await postUserDataStart(
        this.selectedLevel,
        this.currentQuiz,
        this.progressBasic,
        this.progressAdvanced
      );
    },
    sendUserDataFinish: async function() {
      await postUserDataFinish(
        this.selectedLevel,
        this.currentQuiz,
        this.progressBasic,
        this.progressAdvanced
      );
    },
    test: function() {
      console.log("test passed");
    }
  },
  created() {
    this.$store.subscribe((mutation, state) => {
      if (
        mutation.type === "mutateLanguage" ||
        mutation.type === "selectLevel"
      ) {
        this.fetchContent();
        this.fetchQuiz();
      }
    });
  },
  mounted() {
    // SEND USER DATA TO BACKEND
    this.sendUserDataStart();

    // SHOW WALK THROUGH
    if (
      this.progressBasic.length === 0 &&
      this.progressAdvanced.length === 0 &&
      this.currentQuiz === undefined
    ) {
      this.commitWalkThrough();
    }

    // SET QUIZ TOPIC
    this.commitSelectQuiz("quiz" + this.quizTopic);

    // SET QUIZ TOGGLE
    if (this.$store.state.quizToggle) {
      this.quizToggleFade = true;
      this.$refs["quizSwitch"].checked = true;
      this.$refs["toggle-text"].classList.remove("switch-text-off");
    } else {
      this.quizToggleFade = false;
      this.$refs["quizSwitch"]
        ? (this.$refs["quizSwitch"].checked = false)
        : "";
      this.$refs["toggle-text"].classList.add("switch-text-off");
    }

    // DEFINE RADIAL INDICATOR FOR MOBILE
    this.radialObj = radialIndicator(this.$refs["radial-ref"], {
      radius: this.radius,
      barColor: "#C6DFE7",
      barBgColor: "#204157",
      barWidth: 2,
      initValue: 0,
      displayNumber: false,
      frameTime: 1,
      frameNum: this.browserIe ? 50 : 500
    });

    // DEFINE RADIAL INDICATOR FOR DESKTOP
    this.radialObjDesktop = radialIndicator(this.$refs["radial-desktop-ref"], {
      radius: 32,
      barColor: "#C6DFE7",
      barBgColor: "#204157",
      barWidth: 2,
      initValue: 0,
      displayNumber: false,
      frameTime: 1,
      frameNum: this.browserIe ? 50 : 500
    });

    // ACCESS API
    this.fetchContent();
    this.fetchQuiz();

    // LISTEN FOR EVENT BUS
    EventBus.$on(
      "menu-navigate",
      function() {
        this.fetchContent();
        this.fetchQuiz();
        this.$forceUpdate();
      }.bind(this)
    );

    // FIX NAV BAR
    document.getElementById("nav").style.position = "fixed";
    document.getElementById("nav").style.top = 0;

    // TRANSITION IN
    this.$refs["careffect"].style.animation = "fadeout 1.5s ease-in";

    this.$refs["transition-map"].style.animation =
      "transition-map-enter 1.5s ease-out";
    this.$refs["transition-map1"].style.animation =
      "transition-map-enter 1.5s ease-out";
    this.$refs["transition-map2"].style.animation =
      "transition-map-enter2 1.5s ease-out";
    this.$refs["transition-map3"].style.animation =
      "transition-map-enter2 1.5s ease-out";
    this.$refs["map-mobile"].style.animation = "map-enter2 1.5s ease-out";
    this.$refs["map-desktop"].style.animation = "map-enter 1.5s ease-out";

    // ADD SCROLL
    let quizContentRef = this.$refs["quiz-content-ref"];

    quizContentRef.addEventListener("wheel", this.scrollMap);
    quizContentRef.addEventListener("touchmove", this.scrollMap);
    quizContentRef.addEventListener("touchend", this.scrollMapMobile);
    this.$refs["map-desktop"].addEventListener("scroll", function(e) {
      e.preventDefault();
    });

    // ADJUSTMENTS FOR IE
    if (
      this.browserIe &&
      (this.currentQuiz === "quiz4" ||
        this.currentQuiz === "quiz8" ||
        this.currentQuiz === "quiz9" ||
        this.currentQuiz === "quiz11")
    ) {
      document.getElementById("crosswalk").classList.add("crosswalk-ie");
      document.getElementById("stop-sign-road-2").classList.add("stop-sign-ie");
    }
  },
  beforeDestroy() {
    // UNFIX NAV BAR
    document.getElementById("nav").style.position = "static";
  }
};
</script>
