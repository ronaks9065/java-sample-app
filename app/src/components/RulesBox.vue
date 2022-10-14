<template>
  <div class="rule">
    <div class="rule__icon">
      <div class="rule__icon--image">
        <img :src="icon" />
      </div>
    </div>
    <div class="rule__text" v-html="text"></div>
  </div>
</template>

<script>
import { contentService } from "../services/content.service";

export default {
  name: "RulesBox",
  props: {
    id: Number,
    msg: String,
    icon: String,
    text: String
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
            contentService.fillBoxes(d, this.contents);
          });
        });
    }
  }
};
</script>
