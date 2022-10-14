<template>
  <nav
    class="navbar navbar-expand"
    id="nav"
    v-show="this.currentQuiz !== 'finish'"
  >
    <!-- Links -->
    <ul
      class="navbar-nav d-flex flex-row justify-content-between align-items-center"
      style="width: 100vw"
    >
      <li class="nav-item nav__menu" @click="commitMenu">
        <a class="nav-link nav__icon" href="#">
          <!-- IMAGE MACRO for Nav Logo -->
          <img src="../assets/images/icon-menu.svg" alt="menu icon" />
        </a>
      </li>

      <router-link to="welcome" class="nav-item nav__logo logo-img">
        <img
          src="../assets/images/logos/vw-ag-logo-4x.png"
          alt="Volkswagen logo"
        />
      </router-link>

      <div class="d-flex nav__right">
        <li class="nav-item" @click="commitMenuLanguage">
          <p class="nav-link nav__text nav__icon" href="#">
            {{ this.$store.state.language === "Deutsch" ? "DE" : "EN" }}
          </p>
        </li>

        <li class="nav-item" @click="commitMenuContact">
          <a class="nav-link" href="#">
            <img
              src="../assets/images/icon-comment.svg"
              alt="contact icon"
              class="nav__icon"
            />
          </a>
        </li>
      </div>
    </ul>
  </nav>
</template>

<script>
import { mapActions, mapGetters, mapState } from "vuex";

export default {
  name: "navigation",
  props: {
    msg: String
  },
  computed: {
    ...mapState(["currentQuiz"])
  },
  methods: {
    ...mapActions(["commitMenu", "commitMenuLanguage", "commitMenuContact"]),
    showMenu: function(showMenu) {
      if (showMenu) {
        document.getElementById("menu").style.display = "block";
      } else {
        document.getElementById("menu").style.display = "none";
      }
    }
  }
};
</script>
