<template>
  <div @click.native="navigate()" class="menu__item">
    <router-link
      class="menu__item--text"
      tag="a"
      :to="'quiz' + parseInt(this.topic)"
      @click.native="navigate()"
      >{{ this.option }}</router-link
    >
    <div>
      <img
        :class="
          this.quizComplete
            ? 'menu__item--check-box-true'
            : 'menu__item--check-box-false'
        "
        src="../assets/images/icons/icon-check-2x.png"
        alt="quiz complete indicator"
        ref="menu-item-checkbox"
      />
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import { EventBus } from "../event-bus";

export default {
  name: "menu-item",
  props: {
    option: String,
    topic: String,
    level: String
  },
  computed: {
    ...mapState(["progressBasic", "progressAdvanced", "progressLeader"]),
    quizComplete: function() {
      if (
        this.level === "b" &&
        this.progressBasic.includes(parseInt(this.topic))
      ) {
        return true;
      } else if (
        this.level === "a" &&
        this.progressAdvanced.includes(parseInt(this.topic))
      ) {
        return true;
      } else if (
        this.level === "f" &&
        this.progressLeader.includes(parseInt(this.topic))
      ) {
        return true;
      } else {
        return false;
      }
    }
  },
  methods: {
    navigate: function() {
      EventBus.$emit("menu-navigate");
    }
  }
};
</script>
