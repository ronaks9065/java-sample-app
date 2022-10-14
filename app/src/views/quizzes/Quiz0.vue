<template>
  <div>
    <!-- STOP SIGN -->
    <Quiz
      :mapMobile="require('@/assets/images/maps/map1.jpg')"
      :mapDesktop="require('@/assets/images/maps/map1.jpg')"
      :indicatorIncorrect="
        require(`@/assets/images/map-items/stop-sign-4x.png`)
      "
      :indicatorPartial="require(`@/assets/images/map-items/stop-sign-4x.png`)"
      :indicatorCorrect="require(`@/assets/images/map-items/stop-sign-4x.png`)"
      quizObstacleClass="stop-sign-road"
      :quizObstacle="require('@/assets/images/map-items/stop-sign-road-2x.png')"
      quizPreObstacleClass="stop-road"
      :quizPreObstacle="require('@/assets/images/map-items/stop-road-2x.png')"
      quizTopic="0"
      nextPage="quiz1"
      prevPage="cars"
    ></Quiz>
  </div>
</template>

<script>
import Quiz from "../../components/Quiz";

export default {
  name: "quiz0",
  components: {
    Quiz
  }
};
</script>
