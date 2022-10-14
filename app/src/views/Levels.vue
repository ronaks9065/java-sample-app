<template>
  <div class="page23" style="background-color: #f3f5f6">
    <div class="page23__content">
      <h3 class="page23__header colorbluedark" ref="title">
        Was wollen Sie wissen?
      </h3>

      <div class="levels">
        <LevelsBox
          v-for="content in contents"
          :key="content.id"
          :content="content"
          :class="{ highlight: content.id == selectedLevel }"
          @click.native="commitLevel(content.id), setButtonClass(selectedLevel)"
        ></LevelsBox>
      </div>
    </div>

    <PageButtons
      style="background-color: #f3f5f6"
      btnsclass="page23__buttons"
      btn1class="btn--secondary page23__button"
      :btn2class="this.setButtonClass(selectedLevel)"
      :next="selectedLevel === 3 ? 'expertenwissen' : 'cars'"
      back="rules"
    ></PageButtons>
  </div>
</template>

<script>
import LevelsBox from "../components/LevelsBox";
import PageButtons from "../components/PageButtons";
import { mapActions, mapGetters, mapState } from "vuex";
import { contentService } from "../services/content.service";

export default {
  methods: {
    ...mapActions(["commitLevel", "commitTransition"]),
    setButtonClass: function(selectedLevel) {
      if (selectedLevel) {
        return "btn--standard page23__button";
      } else {
        return "btn--disabled page23__button";
      }
    },
    fetchContent: function() {
      contentService
        .getContents("levels", this.$store.state.language)
        .then(data => {
          contentService.replaceContents(this.$refs, data);
          data.forEach(d => {
            contentService.fillBoxes(d, this.contents);
          });
        });
    }
  },
  name: "levels",
  components: {
    LevelsBox,
    PageButtons
  },
  computed: {
    ...mapState(["selectedLevel", "selectedTransition"]),
    ...mapGetters(["getSelectedLevel"]),
    nextPage: function() {
      if (selectedLevel === 3) {
        this.nextPage = "expertwissen";
      } else {
        this.nextPage = "cars";
      }
    }
  },
  mounted() {
    this.fetchContent();
  },
  created() {
    this.$store.subscribe((mutation, state) => {
      if (mutation.type === "mutateLanguage") {
        this.fetchContent();
      }
    });
  },
  data: function() {
    return {
      contents: [
        {
          id: 1,
          icon: require(`@/assets/images/icons/vw-icon-tire-4x.png`),
          heading: "Basiswissen",
          text: "Perfekt, wenn Sie mit Personen-Daten nichts zu tun haben."
        },
        {
          id: 2,
          icon: require(`@/assets/images/icons/icon-transmission-4x.png`),
          heading: "Anwenderwissen",
          text: "Wichtig, wenn Sie Kontakt mit Personen-Daten haben."
        },
        {
          id: 3,
          icon: require(`@/assets/images/icons/vw-icon-undercarriage-4x.png`),
          heading: "Expertenwissen",
          text: "Schnell zum gewünschten Thema und zu Detail-Infos."
        },
        {
          id: 4,
          icon: require(`@/assets/images/icons/vw-icon-steering-wheel-4x.png`),
          heading: "Führungskräftewissen",
          text: "Spezielles Wissen für leitende Funktionen."
        }
      ]
    };
  }
};
</script>
