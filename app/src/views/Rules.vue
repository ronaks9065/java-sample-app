<template>
  <div class="page23">
    <center style="background-color: #f3f5f6">
      <div class="page23__content">
        <h3 class="page23__header colorbluedark" ref="title">Spielregeln</h3>
        <div class="rules">
          <RulesBox
            v-for="content in contents"
            :key="content.id"
            :id="content.id"
            :icon="content.icon"
            :text="content.text"
          ></RulesBox>
        </div>
      </div>

      <PageButtons
        btnsclass="page23__buttons"
        btn1class="btn--secondary page23__button"
        btn2class="btn--standard page23__button"
        next="levels"
        back="welcome"
        disableContinue
      ></PageButtons>
    </center>
  </div>
</template>

<script>
import RulesBox from "../components/RulesBox.vue";
import PageButtons from "../components/PageButtons";
import { contentService } from "../services/content.service";

export default {
  name: "rules",
  data: () => ({
    contents: [
      {
        id: 1,
        icon: require(`@/assets/images/icons/vw-icon-speed-white-4x.png`),
        text: "a"
      },
      {
        id: 2,
        icon: require(`@/assets/images/icons/vw-icon-car-white-4x.png`),
        text: "b"
      },
      {
        id: 3,
        icon: require(`@/assets/images/icons/vw-icon-badge-white-4x.png`),
        text: "c"
      },
      {
        id: 4,
        icon: require(`@/assets/images/icons/icon-toggle-white-4x.png`),
        text: "d"
      }
    ]
  }),
  components: {
    RulesBox,
    PageButtons
  },
  mounted: function() {
    this.fetchContent();
  },
  created() {
    this.$store.subscribe((mutation, state) => {
      if (mutation.type === "mutateLanguage") {
        this.fetchContent();
      }
    });
  },
  methods: {
    fetchContent: function() {
      contentService
        .getContents("rules", this.$store.state.language)
        .then(data => {
          contentService.replaceContents(this.$refs, data);
          data.forEach(d => {
            // if there is a ref for this content.
            // ISSUE is refs are showing up as undefined in the replace Content function
            contentService.fillBoxes(d, this.contents);
          });
        });
    }
  }
};
</script>
