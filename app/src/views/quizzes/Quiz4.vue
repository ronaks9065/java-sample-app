<template>
  <div>
    <!-- CROSSWALK -->
    <Quiz
      :mapMobile="require('@/assets/images/maps/map5-desktop.jpg')"
      :mapDesktop="require('@/assets/images/maps/map5-desktop.jpg')"
      :indicatorIncorrect="require(`@/assets/images/icons/icon-crosswalk-4x.png`)"
      :indicatorPartial="require(`@/assets/images/icons/icon-crosswalk-4x.png`)"
      :indicatorCorrect="require(`@/assets/images/icons/icon-crosswalk-4x.png`)"
      quizObstacleClass="stop-sign-road-2"
      :quizObstacle="require('@/assets/images/map-items/stop-sign-road-2x.png')"
      quizPreObstacleClass="crosswalk"
      :quizPreObstacle="require('@/assets/images/map-items/crosswalk.png')"
      quizTopic="4"
      nextPage="quiz5"
      prevPage="quiz3"
    ></Quiz>
  </div>
</template>

<script>
import Quiz from "../../components/Quiz";
import radialIndicator from "radial-indicator";
import { contentService } from "../../services/content.service";

export default {
  name: "quiz4",
  components: {
    Quiz
  }
};
</script>