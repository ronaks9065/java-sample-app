<template>
  <div>
    <!-- CROSS ROAD -->
    <Quiz
      :mapMobile="require('@/assets/images/maps/map6-desktop.jpg')"
      :mapDesktop="require('@/assets/images/maps/map6-desktop.jpg')"
      :indicatorIncorrect="require(`@/assets/images/icons/icon-x-4x.png`)"
      :indicatorPartial="require(`@/assets/images/icons/icon-x-4x.png`)"
      :indicatorCorrect="require(`@/assets/images/icons/icon-x-4x.png`)"
      quizObstacleClass="stop-sign-road-2"
      :quizObstacle="require('@/assets/images/map-items/stop-sign-road-2x.png')"
      quizTopic="6"
      nextPage="quiz7"
      prevPage="quiz5"
    ></Quiz>
  </div>
</template>

<script>
import Quiz from "../../components/Quiz";

export default {
  name: "quiz6",
  components: {
    Quiz
  }
};
</script>