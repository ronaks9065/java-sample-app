<template>
  <div>
    <!-- TRAIN CROSSING -->
    <Quiz
      :mapMobile="require('@/assets/images/maps/map4-desktop.jpg')"
      :mapDesktop="require('@/assets/images/maps/map4-desktop.jpg')"
      :indicatorIncorrect="require(`@/assets/images/map-items/train-sign-4x.png`)"
      :indicatorPartial="require(`@/assets/images/map-items/train-sign-4x.png`)"
      :indicatorCorrect="require(`@/assets/images/map-items/train-sign-4x.png`)"
      quizObstacleClass="train"
      :quizObstacle="require('@/assets/images/map-items/train-track-2x.png')"
      quizObstacleSecondaryClass="train-train"
      :quizObstacleSecondary="require('@/assets/images/map-items/train-2x.png')"
      quizPreObstacleClass="train-barrier"
      :quizPreObstacle="require('@/assets/images/map-items/train-barrier-first-frame.gif')"
      quizTopic="3"
      nextPage="quiz4"
      prevPage="quiz2"
    ></Quiz>
  </div>
</template>

<script>
import Quiz from "../../components/Quiz";
import radialIndicator from "radial-indicator";
import { contentService } from "../../services/content.service";

export default {
  name: "quiz3",
  components: {
    Quiz
  }
};
</script>