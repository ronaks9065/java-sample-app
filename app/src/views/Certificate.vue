<template>
  <div id="menu">
    <div>
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
    </div>

    <div class="certificate-page-container">
      <div class="center-printable">
        <div id="printableArea">
          <div class="printable__logo">
            <img src="../assets/images/certificate/logo.png" alt />
          </div>
          <hr class="printable__hr" />
          <img
            class="printable__bg"
            src="../assets/images/certificate/bg-2x.jpg"
            alt
          />
          <div class="printable__body">
            <div class="printable__title" ref="title">
              {{
                this.$store.state.language === "Deutsch"
                  ? "Teilnahmebescheinigung"
                  : "Attendance Certificate"
              }}
            </div>
            <div class="printable__text">
              <p>
                {{
                  this.$store.state.language === "Deutsch"
                    ? "Die inhaberin/Der inhaber dieser Bescheinigung,"
                    : "The holder of this certificate,"
                }}
              </p>
              <br />
              <p ref="dom-name" id="domName">{{ this.userName }}</p>

              <br />
              <p ref="text">
                {{
                  this.$store.state.language === "Deutsch"
                    ? "hat das Quiz zum Thema Datenschutz drfolgreich absolviert.  Dabei wurden alle Fragen richtig beantwortet"
                    : "has successfully completed the data protection training.  All questions were answered correctly."
                }}
              </p>
              <br />
              <br />
              <div>
                {{
                  this.$store.state.language === "Deutsch"
                    ? "Wissensebene: "
                    : "Knowledge Level: "
                }}
                <p>{{ this.knowledgeLevel() }}</p>
              </div>

              <br />
              <p>{{ getDate() }}</p>
              <br />
              <br />
              <img
                class="printable__stamp"
                src="../assets/images/certificate/stamp-2x.png"
                alt
              />
            </div>
          </div>
        </div>
      </div>
      <div>
        <div
          class="certificate-btn-inner certificate__button"
          id="druckenbtn"
          style="outline: none;"
          @click="dlCertificate()"
          v-if="
            this.progressBasic.length === 13 ||
              this.progressAdvanced.length === 13 ||
              this.progressLeader.length === 7
          "
        >
          <div
            :class="
              this.$store.state.language === 'Deutsch'
                ? 'dl-btn-text-de'
                : 'dl-btn-text-en'
            "
          >
            {{
              this.$store.state.language === "Deutsch"
                ? "Herunterladen"
                : "Download"
            }}
          </div>
          <img
            class="print-icon"
            src="../assets/images/icons/icon-download-4x.png"
            alt="print icon"
          />
        </div>

        <div
          class="certificate__message"
          v-if="
            this.progressBasic.length !== 13 &&
              this.progressAdvanced.length !== 13 &&
              this.progressLeader.length !== 7
          "
        >
          <p>
            {{
              this.$store.state.language === "Deutsch"
                ? "*Bitte füllen Sie alle Quizfragen in einem Wissensstand aus, um ein Teilnahmebescheinigung zu erhalten."
                : "*Please complete all quizzes in a knowledge level to earn a certificate."
            }}
          </p>
        </div>
      </div>

      <div>
        <hr class="end-hr" />

        <div class="end-container">
          <router-link tag="button" to="endpage1" class="btn__end--2">{{
            this.$store.state.language === "Deutsch" ? "Zurück" : "Back"
          }}</router-link>

          <router-link tag="button" to="feedback" class="btn__end--1">{{
            this.$store.state.language === "Deutsch" ? "Weiter" : "Continue"
          }}</router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
import { getUserName } from "../services/access.service";
import jsPDF from "jspdf";
// window.jsPDF = require("jspdf");

export default {
  name: "certificate",
  computed: {
    ...mapState([
      "userRating",
      "progressBasic",
      "progressAdvanced",
      "progressLeader",
      "selectedLevel"
    ])
  },
  data: function() {
    return {
      renderPage: false,
      userName: ""
    };
  },
  methods: {
    ...mapActions(["commitRating"]),
    printCertificate: function() {
      window.print();
    },
    getDate: function() {
      var today = new Date();
      var dd = String(today.getDate()).padStart(2, "0");
      var mm = String(today.getMonth() + 1).padStart(2, "0"); //January is 0!
      var yyyy = today.getFullYear();

      today = dd + "." + mm + "." + yyyy;
      return today;
    },
    knowledgeLevel: function() {
      let progressB = this.$store.state.progressBasic;
      let progressA = this.$store.state.progressAdvanced;
      let progressF = this.$store.state.progressLeader;
      let lang = this.$store.state.language;

      if (lang === "Deutsch") {
        if (progressF.length > 6) {
          return "Führungskräftewissen";
        } else if (progressA.length > 12) {
          return "Anwenderwissen";
        } else {
          return "Basiswissen";
        }
      } else if (lang === "Englisch") {
        if (progressF.length > 6) {
          return "Leader Knowledge";
        } else if (progressA.length > 12) {
          return "Advanced Knowledge";
        } else if (progressB.length > 12) {
          return "Basic Knowledge";
        }
      }
    },
    knowledgeWidth: function() {
      if (this.knowledgeLevel() === "Basiswissen") {
        return 89;
      } else if (this.knowledgeLevel() === "Anwenderwissen") {
        return 84;
      } else if (this.knowledgeLevel() === "Führungskräftewissen") {
        return 77;
      } else if (this.knowledgeLevel() === "Basic Knowledge") {
        return 83;
      } else if (this.knowledgeLevel() === "Advanced Knowledge") {
        return 77;
      } else if (this.knowledgeLevel() === "Leader Knowledge") {
        return 81;
      } else {
        return 0;
      }
    },
    dlCertificate: function() {
      let doc = new jsPDF();
      let img = new Image();
      let domName = this.$refs["dom-name"].innerHTML;
      let lang = this.$store.state.language;
      let getTextWidth = function(text, font) {
        // re-use canvas object for better performance
        var canvas =
          getTextWidth.canvas ||
          (getTextWidth.canvas = document.createElement("canvas"));
        var context = canvas.getContext("2d");
        context.font = font;
        var metrics = context.measureText(text);
        return metrics.width;
      };
      let pxToMm = function(px) {
        return (25.4 / 96) * px;
      };
      let textWidth = pxToMm(getTextWidth(domName));
      let xPos = 210 / 2 - 0.5 * textWidth - 6;

      // Switch template based on language
      img.src =
        lang === "Deutsch"
          ? require("@/assets/images/certificate/cert-template-de.jpg")
          : require("@/assets/images/certificate/cert-template-en.jpg");

      doc.addImage(img, "JPEG", 0, 0, 210, 297);
      doc.text(this.userName, xPos, 147);
      doc.text(this.knowledgeLevel(), this.knowledgeWidth(), 190);
      doc.text(this.getDate(), 91, 207);
      doc.save("a4.pdf");
    }
  },
  mounted() {
    getUserName(this.selectedLevel).then(res => {
      if (res !== undefined) {
        this.userName = res.data.name;
      }
    });
  }
};
</script>
