<template>
  <div>
    <!-- CROSSWALK -->
    <Quiz
      :mapMobile="require('@/assets/images/maps/map10-desktop.jpg')"
      :mapDesktop="require('@/assets/images/maps/map10-desktop.jpg')"
      :indicatorIncorrect="require(`@/assets/images/map-items/stop-sign-4x.png`)"
      :indicatorPartial="require(`@/assets/images/map-items/stop-sign-4x.png`)"
      :indicatorCorrect="require(`@/assets/images/map-items/stop-sign-4x.png`)"
      quizObstacleClass="stop-sign-road-2"
      :quizObstacle="require('@/assets/images/map-items/stop-sign-road-2x.png')"
      quizPreObstacleClass="crosswalk"
      :quizPreObstacle="require('@/assets/images/map-items/crosswalk.png')"
      quizTopic="16"
      nextPage="quiz17"
      prevPage="quiz15"
    ></Quiz>
  </div>
</template>

<script>
import Quiz from "../../components/Quiz";
import radialIndicator from "radial-indicator";
import { contentService } from "../../services/content.service";

export default {
  name: "quiz16",
  components: {
    Quiz
  }
};
</script>