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
      <p class="centered certificate__text" ref="text">
        Wie bewerten Sie das Datenschutznavi?
      </p>
      <star-rating
        class="feedback__stars"
        inactive-color="white"
        active-color="#335F7D"
        v-bind:show-rating="false"
        border-color="#335F7D"
        v-bind:border-width="4"
        v-bind:star-size="30"
        @current-rating="selectStars"
      ></star-rating>
      <hr width="24%" class="hr__narrow2" />
    </div>

    <div class="feedback__bottom">
      <p class="centered certificate__text">
        {{ this.$store.state.language === "Deutsch" ? "Kommentar" : "Comment" }}
      </p>

      <form
        class="form"
        @submit="
          e => {
            e.preventDefault();
            this.onSubmit();
          }
        "
      >
        <center>
          <textarea
            class="feedback__input"
            :value="this.comment"
            name="comment"
            cols="1"
            rows="4"
            @change="e => this.onChange(e)"
          ></textarea>
        </center>
        <center>
          <input
            class="btn--standard feedback__button"
            type="submit"
            :value="
              this.$store.state.language === 'Deutsch'
                ? 'Bewertung Abgeben'
                : 'Submit Rating'
            "
          />
        </center>
      </form>
    </div>
  </div>
</template>

<script>
import StarRating from "vue-star-rating";
import { mapActions, mapState } from "vuex";
import { postUserFeedback } from "../services/quiz.service";
import { contentService } from "../services/content.service";

export default {
  name: "certificate",
  computed: {
    ...mapState(["userRating", "language"])
  },
  data: function() {
    return {
      rating: 0,
      comment: "",
      renderPage: false
    };
  },
  components: {
    StarRating
  },
  methods: {
    ...mapActions(["commitRating"]),
    selectStars: function(rating) {
      this.rating = rating;
    },
    onSubmit: async function() {
      await postUserFeedback(this.rating, this.comment);
      this.$router.push("complete");
    },
    onChange: function(e) {
      return (this.comment = e.target.value);
    },
    fetchContent: function() {
      contentService
        .getContents("feedback", this.$store.state.language)
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
  }
};
</script>
