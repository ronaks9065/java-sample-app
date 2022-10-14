<template>
  <div v-show="quiz.active">
    <div class="quiz-interaction__question" ref="answer-basic">{{ quiz.content }}</div>
    <AnswerBox
      v-for="answer in quiz.answers"
      :key="answer.answerText"
      :answer="answer"
      v-on:selectAnswer="selectAnswer"
    >{{ answer.answerText }}</AnswerBox>
  </div>
</template>

<script>
import AnswerBox from "../components/AnswerBox";
import { EventBus } from '../event-bus';

export default {
  name: "QuizQuestion",
  components: {
    AnswerBox
  },
  props: {
    quiz: Object
  },
  data: () => {
    return {
      s: false,
      selectedAnswers: []
    };
  },
  computed: {
    rightAnswers: function() {
      return this.quiz.answers.filter(a => a.correct);
    }
  },
  mounted() {
    EventBus.$on("quizReset", function() {
      this.selectedAnswers = [];
    }.bind(this));
  },
  methods: {
    // setButtonClass: function() {
    //   if (this.quizToggleFade && this.selectedAnswers.length === 0) {
    //     return "btn--disabled quiz-page__button";
    //   } else {
    //     return "btn--standard quiz-page__button";
    //   }
    // },
    selectAnswer: function(answer) {
      if (this.selectedAnswers.indexOf(answer) === -1) {
        // if the answer is not already selected
        this.selectedAnswers.push(answer);
      } else {
        // unselect select answer.
        this.selectedAnswers = this.selectedAnswers.filter(a => a !== answer);
      }
      let allAnswersCorrect = this.checkAnswers();
      this.$emit("selectedAnswers", this.selectedAnswers);
      this.$emit("selectAnswer", allAnswersCorrect);
    },
    checkAnswers: function() {
      if (this.selectedAnswers.length !== this.rightAnswers.length) {
        return false;
      } else {
        for (var i = 0; i < this.selectedAnswers.length; i++) {
          if (this.selectedAnswers[i].correct === false) {
            return false;
          }
        }

        return true;
      }
    }
  }
};
</script>
