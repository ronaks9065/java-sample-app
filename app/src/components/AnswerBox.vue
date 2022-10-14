<template>
  <div
    :class="this.setClass()"
    @click="selectAnswer(answer)"
  >
    <p v-html="answer.answerText"></p>
  </div>
</template>

<script>
import { EventBus } from "../event-bus";

export default {
  name: "AnswerBox",
  data: function() {
    return {
      active: false
    };
  },
  mounted() {
    EventBus.$on("quizReset", function() {
      this.active = false
    }.bind(this));
  },
  methods: {
    selectAnswer: function(answer) {
      this.$emit("selectAnswer", answer);
      this.active = !this.active;
    },
    setClass: function() {
      if (this.active && this.$store.state.quizToggle) {
        return 'quiz-interaction__answer highlight'
      } else if (this.$store.state.quizToggle) {
        return 'quiz-interaction__answer'
      } else {
        return 'quiz-interaction__answer quiz__disabled'
      }
    }
  },
  props: {
    id: Number,
    answer: Object
  }
};
</script>
