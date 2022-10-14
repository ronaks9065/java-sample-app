<template>
  <div class="level">
    <div class="level__icon">
      <div class="level__icon--image"><img :src="content.icon" /></div>
    </div>
    <div class="level__right">
      <div class="level__right--title">
        <p v-html="content.heading"></p>
      </div>
      <div class="level__right--text">
        <p v-html="content.text"></p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "LevelsBox",
  props: {
    content: Object
  }
};
</script>
