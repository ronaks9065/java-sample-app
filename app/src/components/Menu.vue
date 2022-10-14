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
          @click="close()"
        />
      </div>
      <hr width="24%" class="hr__narrow hr__menu" />
      <img
        src="../assets/images/logos/kozern-logo-4x.png"
        alt="Volkswagen logo"
        class="menu__data-logo"
      />
    </div>

    <div
      class="menu__option"
      @click="selectOption('basiswissen')"
      title="basiswissen"
    >
      <hr width="24%" class="hr__narrow hr__menu" />
      <div class="menu__list">
        <p class="menu__list--title">
          {{
            this.$store.state.language === "Deutsch"
              ? "BASISWISSEN"
              : "BASIC KNOWLEDGE"
          }}
        </p>
        <img
          src="../assets/images/icons/icon-plus-4x.png"
          alt
          class="menu__list--icon"
        />
      </div>

      <div v-if="this.basiswissen" @click="adjustLevelBasic()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? 'Einführung'
              : 'Introduction'
          "
          topic="0"
          level="b"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.basiswissen" @click="adjustLevelBasic()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? 'Datenschutzorganisation'
              : 'Privacy Organization'
          "
          topic="1"
          level="b"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.basiswissen" @click="adjustLevelBasic()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? 'Rechtmäßigkeit und Zweckbindung'
              : 'Legality and Earmarking'
          "
          topic="2"
          level="b"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.basiswissen" @click="adjustLevelBasic()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? 'Datensparsamkeit und Löschkonzept'
              : 'Data Economy and Deletion Concept'
          "
          topic="3"
          level="b"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.basiswissen" @click="adjustLevelBasic()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? 'Datenschutzerklärung'
              : 'Data Protection Declaration'
          "
          topic="4"
          level="b"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.basiswissen" @click="adjustLevelBasic()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? 'Betroffenenrechte'
              : 'Affected Rights'
          "
          topic="5"
          level="b"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.basiswissen" @click="adjustLevelBasic()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? 'Einwilligungserklärung'
              : 'Consent'
          "
          topic="6"
          level="b"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.basiswissen" @click="adjustLevelBasic()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? 'Technische und Organisatorische Maßnahmen (TOM)/IT-Sicherheit'
              : 'Technical and Organizational Measures (TOM)/IT Security'
          "
          topic="7"
          level="b"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.basiswissen" @click="adjustLevelBasic()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? 'Meldung bei Verstößen'
              : 'Report for Violations'
          "
          topic="8"
          level="b"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.basiswissen" @click="adjustLevelBasic()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? '(VVT) Verzeichnis der Verarbeitungstätigkeiten'
              : '(RPA) List of Processing Activities'
          "
          topic="9"
          level="b"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.basiswissen" @click="adjustLevelBasic()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? '(DSFA) Datenschutz-Folgenabschätzung'
              : '(DPIA) Privacy Assessment'
          "
          topic="10"
          level="b"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.basiswissen" @click="adjustLevelBasic()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? 'Auftragsverarbeitung'
              : 'Order Processing'
          "
          topic="11"
          level="b"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.basiswissen" @click="adjustLevelBasic()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? 'Datenübermittlung in Drittländer'
              : 'Data Transmission to Third Countries'
          "
          topic="12"
          level="b"
        />
      </div>
    </div>

    <div
      class="menu__option"
      @click="selectOption('anwenderwissen')"
      title="anwenderwissen"
    >
      <hr width="24%" class="hr__narrow hr__menu" />
      <div class="menu__list">
        <p class="menu__list--title">
          {{
            this.$store.state.language === "Deutsch"
              ? "ANWENDERWISSEN"
              : "ADVANCED KNOWLEDGE"
          }}
        </p>
        <img
          src="../assets/images/icons/icon-plus-4x.png"
          alt
          class="menu__list--icon"
        />
      </div>

      <div v-if="this.anwenderwissen" @click="adjustLevelAdvanced()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? 'Einführung'
              : 'Introduction'
          "
          topic="0"
          level="a"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.anwenderwissen" @click="adjustLevelAdvanced()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? 'Datenschutzorganisation'
              : 'Privacy Organization'
          "
          topic="1"
          level="a"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.anwenderwissen" @click="adjustLevelAdvanced()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? 'Rechtmäßigkeit und Zweckbindung'
              : 'Legality and Earmarking'
          "
          topic="2"
          level="a"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.anwenderwissen" @click="adjustLevelAdvanced()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? 'Datensparsamkeit und Löschkonzept'
              : 'Data Economy and Deletion Concept'
          "
          topic="3"
          level="a"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.anwenderwissen" @click="adjustLevelAdvanced()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? 'Datenschutzerklärung'
              : 'Privacy Policy'
          "
          topic="4"
          level="a"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.anwenderwissen" @click="adjustLevelAdvanced()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? 'Betroffenenrechte'
              : 'Affected Rights'
          "
          topic="5"
          level="a"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.anwenderwissen" @click="adjustLevelAdvanced()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? 'Einwilligungserklärung'
              : 'Consent'
          "
          topic="6"
          level="a"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.anwenderwissen" @click="adjustLevelAdvanced()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? 'Technische und Organisatorische Maßnahmen (TOM)/IT-Sicherheit'
              : 'Technical and Organizational Measures (TOM)/IT Security'
          "
          topic="7"
          level="a"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.anwenderwissen" @click="adjustLevelAdvanced()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? 'Meldung bei Verstößen'
              : 'Report for Violations'
          "
          topic="8"
          level="a"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.anwenderwissen" @click="adjustLevelAdvanced()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? '(VVT) Verzeichnis der Verarbeitungstätigkeiten'
              : '(RPA) List of Processing Activities'
          "
          topic="9"
          level="a"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.anwenderwissen" @click="adjustLevelAdvanced()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? '(DSFA) Datenschutz-Folgenabschätzung'
              : '(DPIA) Privacy Assessment'
          "
          topic="10"
          level="a"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.anwenderwissen" @click="adjustLevelAdvanced()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? 'Auftragsverarbeitung'
              : 'Order Processing'
          "
          topic="11"
          level="a"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.anwenderwissen" @click="adjustLevelAdvanced()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? 'Datenübermittlung in Drittländer'
              : 'Data Transmission to Third Countries'
          "
          topic="12"
          level="a"
        />
      </div>
    </div>

    <hr width="24%" class="hr__narrow hr__menu" />
    <div class="menu__list">
      <router-link
        to="expertenwissen"
        class="menu__list--title"
        @click.native="navExpert()"
        >{{
          this.$store.state.language === "Deutsch"
            ? "EXPERTENWISSEN"
            : "EXPERT KNOWLEDGE"
        }}</router-link
      >
    </div>

    <div
      class="menu__option"
      @click="selectOption('fuhrungskraftewissen')"
      title="fuhrungskraftewissen"
    >
      <hr width="24%" class="hr__narrow hr__menu" />
      <div class="menu__list">
        <p class="menu__list--title">
          {{
            this.$store.state.language === "Deutsch"
              ? "FÜHRUNGSKRÄFTEWISSEN"
              : "MANAGERIAL KNOWLEDGE"
          }}
        </p>
        <img
          src="../assets/images/icons/icon-plus-4x.png"
          alt
          class="menu__list--icon"
        />
      </div>

      <div v-if="this.fuhrungskraftewissen" @click="adjustLevelManager()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? 'Einführung'
              : 'Introduction'
          "
          topic="13"
          level="f"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.fuhrungskraftewissen" @click="adjustLevelManager()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? '(VVT) Verzeichnis der Verarbeitungstätigkeiten'
              : '(RPA) List of Processing Activities'
          "
          topic="14"
          level="f"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.fuhrungskraftewissen" @click="adjustLevelManager()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? '(DSFA) Datenschutz-Folgenabschätzung'
              : '(DPIA) Privacy Assessment'
          "
          topic="15"
          level="f"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.fuhrungskraftewissen" @click="adjustLevelManager()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? 'Meldung bei Verstößen'
              : 'Report for Violations'
          "
          topic="16"
          level="f"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.fuhrungskraftewissen" @click="adjustLevelManager()">
        <MenuItem
          :option="
            this.$store.state.language === 'Deutsch'
              ? 'Beauskunftung'
              : 'Information'
          "
          topic="17"
          level="f"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.fuhrungskraftewissen" @click="adjustLevelManager()">
        <MenuItem
          :option="this.$store.state.language === 'Deutsch' ? 'KRL2' : 'KRL2'"
          topic="18"
          level="f"
        />
        <hr class="menu__item--hr" />
      </div>

      <div v-if="this.fuhrungskraftewissen" @click="adjustLevelManager()">
        <MenuItem
          :option="this.$store.state.language === 'Deutsch' ? 'ORL50' : 'ORL50'"
          topic="19"
          level="f"
        />
        <hr class="menu__item--hr" />
      </div>
    </div>

    <hr
      width="24%"
      class="hr__narrow hr__menu"
      v-if="
        this.progressBasic.length > 12 ||
          this.progressAdvanced.length > 12 ||
          this.progressLeader.length > 6
      "
    />
    <div
      class="menu__list"
      v-if="
        this.progressBasic.length > 12 ||
          this.progressAdvanced.length > 12 ||
          this.progressLeader.length > 6
      "
    >
      <router-link
        to="certificate"
        class="menu__list--title"
        @click.native="close()"
        >{{
          this.$store.state.language === "Deutsch"
            ? "TEILNAHMEBESCHEINIGUNG"
            : "CERTIFICATE"
        }}</router-link
      >
    </div>

    <hr width="24%" class="hr__narrow hr__menu" />
    <div class="menu__list">
      <button
        style="border: none; background-color: rgba(0,0,0,0);"
        to="certificate"
        class="menu__list--title"
        @click="commitWalkThrough(), close()"
      >
        QUIZ DEMO
      </button>
    </div>

    <hr width="24%" class="hr__narrow hr__menu" />
    <div class="menu__list">
      <a
        class="menu__list--title"
        href="https://volkswagen-net.de/wikis/display/PUB/__DATA_PROTECTION_DECLARATION"
        target="_blank"
      >
        DATENSCHUTZERKLÄRUNG
      </a>
    </div>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
import MenuItem from "./MenuItem";
import { EventBus } from "../event-bus";

export default {
  name: "menu-component",
  components: {
    MenuItem,
  },
  computed: {
    ...mapState(["progressBasic", "progressAdvanced", "progressLeader"]),
  },
  data: function() {
    return {
      basiswissen: false,
      anwenderwissen: false,
      fuhrungskraftewissen: false,
    };
  },
  methods: {
    ...mapActions(["commitMenu", "commitLevel", "commitWalkThrough"]),
    selectOption: function(option) {
      let options = document.getElementsByClassName("menu__option");

      for (var i = 0; i < options.length; i++) {
        if (options[i].title === option) {
          options[i].firstChild.classList.add("hr--selected");
          options[i].children[1].firstChild.classList.add(
            "menu__option--selected"
          );
          options[
            i
          ].children[1].lastChild.src = require("@/assets/images/icons/icon-minus-4x.png");
        } else {
          options[i].firstChild.classList.remove("hr--selected");
          options[i].children[1].firstChild.classList.remove(
            "menu__option--selected"
          );
          options[
            i
          ].children[1].lastChild.src = require("@/assets/images/icons/icon-plus-4x.png");
        }
      }

      if (option === "basiswissen") {
        if (this.basiswissen === false) {
          this.basiswissen = true;
          this.anwenderwissen = false;
          this.fuhrungskraftewissen = false;
        } else {
          this.close2();
        }
      }

      if (option === "anwenderwissen") {
        if (this.anwenderwissen === false) {
          this.basiswissen = false;
          this.anwenderwissen = true;
          this.fuhrungskraftewissen = false;
        } else {
          this.close2();
        }
      }

      if (option === "fuhrungskraftewissen") {
        if (this.fuhrungskraftewissen === false) {
          this.basiswissen = false;
          this.anwenderwissen = false;
          this.fuhrungskraftewissen = true;
        } else {
          this.close2();
        }
      }
    },
    close: function() {
      this.commitMenu();

      this.basiswissen = false;
      this.anwenderwissen = false;
      this.fuhrungskraftewissen = false;

      let options = document.getElementsByClassName("menu__option");

      for (var i = 0; i < options.length; i++) {
        options[i].firstChild.classList.remove("hr--selected");
        options[i].children[1].firstChild.classList.remove(
          "menu__option--selected"
        );
        options[
          i
        ].children[1].lastChild.src = require("@/assets/images/icons/icon-plus-4x.png");
      }
    },
    close2: function() {
      this.basiswissen = false;
      this.anwenderwissen = false;
      this.fuhrungskraftewissen = false;

      let options = document.getElementsByClassName("menu__option");

      for (var i = 0; i < options.length; i++) {
        options[i].firstChild.classList.remove("hr--selected");
        options[i].children[1].firstChild.classList.remove(
          "menu__option--selected"
        );
        options[
          i
        ].children[1].lastChild.src = require("@/assets/images/icons/icon-plus-4x.png");
      }
    },
    adjustLevelBasic: function() {
      this.commitLevel(1);
    },
    adjustLevelAdvanced: function() {
      this.commitLevel(2);
    },
    adjustLevelManager: function() {
      this.commitLevel(4);
    },
    navExpert: function() {
      this.close();
      this.commitLevel(3);
    },
  },
  mounted() {
    EventBus.$on(
      "menu-navigate",
      function() {
        this.close();
      }.bind(this)
    );
  },
};
</script>
