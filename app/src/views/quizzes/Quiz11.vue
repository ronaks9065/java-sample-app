<template>
  <div>
    <!-- TRAFFIC LIGHT -->
    <Quiz
      :mapMobile="require('@/assets/images/maps/map7-desktop.jpg')"
      :mapDesktop="require('@/assets/images/maps/map7-desktop.jpg')"
      :indicatorIncorrect="require(`@/assets/images/map-items/traffic-light-red-4x.png`)"
      :indicatorPartial="require(`@/assets/images/map-items/traffic-light-yellow-4x.png`)"
      :indicatorCorrect="require(`@/assets/images/map-items/traffic-light-green-4x.png`)"
      quizObstacleClass="traffic-light"
      :quizObstacle="require('@/assets/images/map-items/traffic-light@4x.png')"
      quizPreObstacleClass="crosswalk"
      :quizPreObstacle="require('@/assets/images/map-items/crosswalk.png')"
      quizTopic="11"
      nextPage="quiz12"
      prevPage="quiz10"
    ></Quiz>
  </div>
</template>

<script>
import Quiz from "../../components/Quiz";
import radialIndicator from "radial-indicator";
import { contentService } from "../../services/content.service";

export default {
  name: "quiz11",
  components: {
    Quiz
  }
};
</script>