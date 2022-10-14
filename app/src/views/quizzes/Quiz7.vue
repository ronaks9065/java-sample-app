<template>
  <div>
    <!-- CROSS ROAD -->
    <Quiz
      :mapMobile="require('@/assets/images/maps/map11-desktop.jpg')"
      :mapDesktop="require('@/assets/images/maps/map11-desktop.jpg')"
      :indicatorIncorrect="require(`@/assets/images/icons/icon-x-4x.png`)"
      :indicatorPartial="require(`@/assets/images/icons/icon-x-4x.png`)"
      :indicatorCorrect="require(`@/assets/images/icons/icon-x-4x.png`)"
      quizObstacleClass="stop-sign-road-2"
      :quizObstacle="require('@/assets/images/map-items/stop-sign-road-2x.png')"
      quizTopic="7"
      nextPage="quiz8"
      prevPage="quiz6"
    ></Quiz>
  </div>
</template>

<script>
import Quiz from "../../components/Quiz";

export default {
  name: "quiz7",
  components: {
    Quiz
  }
};
</script>