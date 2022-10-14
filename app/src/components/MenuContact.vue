<template>
  <div id="menu">
    <div class="menu__top-container">
      <div class="menu__top">
        <img
          src="../assets/images/logos/vw-ag-logo-4x.png"
          alt="Volkswagen logo"
          class="menu__logo"
        />
        <img
          src="../assets/images/icons/vw-icon-close-grey-4x.png"
          alt="close"
          class="menu__icon"
          @click="commitMenuContact"
        />
      </div>
      <hr width="24%" class="hr__narrow" />
      <img
        src="../assets/images/logos/kozern-logo-4x.png"
        alt="Volkswagen logo"
        class="menu__data-logo"
      />
    </div>

    <hr style="margin: 20px auto;" width="24%" class="hr__narrow" />
    <p ref="menu__contact--info" class="menu-contact__title bold centered">
      {{
        this.$store.state.language === "Deutsch"
          ? "Ihre Ansprechpartner"
          : "Your Contact Persons"
      }}
    </p>

    <hr width="90%" class="hr__wide" />
    <p class="menu-contact__text centered">
      {{
        this.$store.state.language === "Deutsch"
          ? "Wenn Sie Fragen zum Thema Datenschutz der Volkswagen AG haben:"
          : "If you have questions on the topic of data proteciton for a brand, help is available here:"
      }}
    </p>
    <a
      class="menu-contact__email centered"
      href="mailto:datenschutz@volkswagen.de"
      >datenschutz@volkswagen.de</a
    >

    <hr width="90%" class="hr__wide" />
    <p class="menu-contact__text centered">
      {{
        this.$store.state.language === "Deutsch"
          ? "Wenn Ihnen beim Thema DSGVO Implementierung noch Informationen fehlen:"
          : "If you require information on legal topics:"
      }}
    </p>
    <a
      class="menu-contact__email centered"
      href="mailto:dsgvo-implementierung.vwag.r.wob@volkswagen.de"
      >dsgvo-implementierung.vwag.r.wob@volkswagen.de</a
    >

    <hr width="90%" class="hr__wide" />
    <p class="menu-contact__text centered">
      {{
        this.$store.state.language === "Deutsch"
          ? "Bei technischen Problemen wenden Sie sich bitte an:"
          : "If you would like to contact the help desk directly:"
      }}
    </p>
    <a class="menu-contact__email centered" href="mailto:ehdd@volkswagen.de"
      >ehdd@volkswagen.de</a
    >
  </div>
</template>

<script>
import { mapActions } from "vuex";

export default {
  name: "menu-contact",
  data: function() {
    return {};
  },
  methods: {
    ...mapActions(["commitMenuContact"])
  }
};
</script>
