<template>
  <div :class="btnsclass">
    <router-link
      tag="button"
      :to="backLink()"
      :class="btn1class"
      data-name="btnBack"
      >{{
        this.$store.state.language === "Deutsch" ? "Zurück" : "Back"
      }}</router-link
    >

    <router-link
      tag="button"
      :to="nextLink()"
      :class="btn2class"
      data-name="btnNext"
      >{{
        this.$store.state.language === "Deutsch" ? "Weiter" : "Continue"
      }}</router-link
    >
  </div>
</template>

<script>
export default {
  name: "PageButtons",
  props: {
    btnsclass: String,
    btn1class: String,
    btn2class: String,
    next: String,
    back: String
  },
  methods: {
    nextLink: function() {
      return { name: this.next };
    },
    backLink: function() {
      return { name: this.back };
    },
    nextPage: function() {
      this.$router.push({ path: `${this.next}` });
    },
    prevPage: function() {
      this.$router.push({ path: `${this.back}` });
    }
  }
};
</script>
