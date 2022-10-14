<template>
  <div>
    <!-- STOP SIGN -->
    <Quiz
      :mapMobile="require('@/assets/images/maps/map2.jpg')"
      :mapDesktop="require('@/assets/images/maps/map2.jpg')"
      :indicatorIncorrect="
        require(`@/assets/images/map-items/stop-sign-4x.png`)
      "
      :indicatorPartial="require(`@/assets/images/map-items/stop-sign-4x.png`)"
      :indicatorCorrect="require(`@/assets/images/map-items/stop-sign-4x.png`)"
      quizObstacleClass="stop-sign-road"
      :quizObstacle="require('@/assets/images/map-items/stop-sign-road-2x.png')"
      quizPreObstacleClass="stop-road"
      :quizPreObstacle="require('@/assets/images/map-items/stop-road-2x.png')"
      quizTopic="2"
      nextPage="quiz3"
      prevPage="quiz1"
    ></Quiz>
  </div>
</template>

<script>
import Quiz from "../../components/Quiz";
import radialIndicator from "radial-indicator";
import { contentService } from "../../services/content.service";

export default {
  name: "quiz2",
  components: {
    Quiz
  }
};
</script>
