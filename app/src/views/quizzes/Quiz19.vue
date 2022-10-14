<template>
  <div>
    <!-- DUCKS -->
    <Quiz
      :mapMobile="require('@/assets/images/maps/map12-desktop.jpg')"
      :mapDesktop="require('@/assets/images/maps/map12-desktop.jpg')"
      :indicatorIncorrect="require(`@/assets/images/map-items/duck-sign-4x.png`)"
      :indicatorPartial="require(`@/assets/images/map-items/duck-sign-4x.png`)"
      :indicatorCorrect="require(`@/assets/images/map-items/duck-sign-4x.png`)"
      quizObstacleClass="ducks"
      :quizObstacle="require('@/assets/images/map-items/ducks-4x.png')"
      quizObstacleSecondaryClass="duck-baby"
      :quizObstacleSecondary="require('@/assets/images/map-items/duck-baby-2x.png')"
      quizPreObstacleClass="crosswalk"
      :quizPreObstacle="require('@/assets/images/map-items/crosswalk.png')"
      quizTopic="19"
      nextPage="finish"
      prevPage="quiz18"
    ></Quiz>
  </div>
</template>

<script>
import Quiz from "../../components/Quiz";
import radialIndicator from "radial-indicator";
import { contentService } from "../../services/content.service";

export default {
  name: "quiz19",
  components: {
    Quiz
  }
};
</script>