<template>
  <div id="menu">
    <div class="menu__top-container">
      <div class="menu__top">
        <img
          src="../assets/images/logos/vw-ag-logo-4x.png"
          alt="Volkswagen logo"
          class="menu__logo"
        />
        <router-link to="welcome">
          <img
            src="../assets/images/icons/vw-icon-close-grey-4x.png"
            alt="close"
            class="menu__icon"
          />
        </router-link>
      </div>
      <hr width="24%" class="hr__narrow" />
      <img
        src="../assets/images/logos/kozern-logo-4x.png"
        alt="Volkswagen logo"
        class="menu__data-logo"
      />
      <hr width="24%" class="hr__narrow2" />
    </div>

    <div>
      <p class="terms__title" ref="title">
        Nutzungshinweise
      </p>
      <p class="terms" ref="text">
        Das Datenschutz-Navi vermittelt Ihnen Datenschutzwissen auf spielerisch
        leichte Art: Das Navi führt Sie über eine virtuelle Strecke zum Ziel.
        Sie können sich eine von vier Wissenstiefen und ein Auto für die Tour
        aussuchen. Außerdem können Sie rechts oben Ihre Sprache auswählen. Das
        Wissen ist in mehrere Kapitel aufgeteilt. Am Ende der meisten Kapitel
        finden Sie ein Quiz. Die Beantwortung ist freiwillig – mit einem
        Schiebeschalter rechts oben im Bild können Sie die Fragen ausschalten.
        Wenn Sie alle Quizfragen in Ihrer Wissenstiefe richtig beantworten,
        erhalten Sie am Ziel eine Teilnahmebestätigung. Zu fast jedem Kapitel
        gibt es Fallbeispiele, die Sie anklicken können. Falls Sie mehr
        Informationen wünschen oder Fragen haben, finden Sie Hilfe und Links
        unter "Mehr Info". Zudem können Sie für eine schnelle Kontaktinformation
        die Sprechblase ganz rechts oben anklicken. Falls Sie ein Kapitel direkt
        anwählen möchten, ohne die Kapitel der Reihe nach zu durchfahren,
        klicken Sie links oben auf das Symbol mit 3 waagerechten Balken. Am Ende
        können Sie eine Bewertung für das Datenschutz-Navi abgeben.
      </p>
    </div>
  </div>
</template>

<script>
import { mapActions } from "vuex";
import { contentService } from "../services/content.service";

export default {
  name: "terms",
  data: () => ({
    renderPage: false
  }),
  methods: {
    fetchContent: function() {
      contentService
        .getContents("terms", this.$store.state.language)
        .then(data => {
          this.renderPage = true;
          contentService.replaceContents(this.$refs, data);
          data.forEach(d => {
            // if there is a ref for this content.
            contentService.fillBoxes(d, this.contents);
          });
        });
    }
  },
  mounted() {
    this.fetchContent();
  }
};
</script>
