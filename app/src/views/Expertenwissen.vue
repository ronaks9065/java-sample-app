<template>
  <div class="expertenwissen-page">
    <div class="expertenwissen-page__top">
      <h3 class="expertenwissen-page__header" data-name>
        {{
          this.$store.state.language === "Deutsch"
            ? "Expertenwissen"
            : "Expert Knowledge"
        }}
      </h3>
      <div class="expertenwissen-page__subheader">
        {{
          this.$store.state.language === "Deutsch"
            ? "Woran sind Sie interessiert? Bitte auswählen:"
            : "What are you interested in? Please select:"
        }}
      </div>
    </div>

    <div class="expertenwissen-page__content">
      <div class="expertenwissen-page__item">
        <a
          :href="
            this.$store.state.language === 'Deutsch'
              ? 'https://group-wiki.wob.vw.vwg/wikis/display/SCHUTZPBD/Grundsatzthemen+der+VW+AG'
              : 'https://group-wiki.wob.vw.vwg/wikis/display/SCHUTZPBD/Downloadbereich'
          "
          target="blank"
          class="expertenwissen-page__link"
          ref="link-1"
        >
          {{
            this.$store.state.language === "Deutsch"
              ? "Verzeichnis von Verarbeitungstätigkeiten (VVT)"
              : "policy issue records of processing activities (RPA)"
          }}</a
        >
        <img
          src="../assets/images/icons/icon-link-2x.png"
          alt="link icon"
          class="expertenwissen-page__icon"
        />
      </div>

      <div class="expertenwissen-page__item">
        <a
          :href="
            this.$store.state.language === 'Deutsch'
              ? 'https://group-wiki.wob.vw.vwg/wikis/display/SCHUTZPBD/Grundsatzthemen+der+VW+AG'
              : 'https://group-wiki.wob.vw.vwg/wikis/display/SCHUTZPBD/Downloadbereich'
          "
          target="blank"
          class="expertenwissen-page__link"
          ref="link-2"
          >{{
            this.$store.state.language === "Deutsch"
              ? "Grundsatzthemen Rechtsgrundlagen und Einwilligung"
              : "policy issues legal bases and consent"
          }}</a
        >
        <img
          src="../assets/images/icons/icon-link-2x.png"
          alt="link icon"
          class="expertenwissen-page__icon"
        />
      </div>

      <div class="expertenwissen-page__item">
        <a
          :href="
            this.$store.state.language === 'Deutsch'
              ? 'https://group-wiki.wob.vw.vwg/wikis/display/SCHUTZPBD/Grundsatzthemen+der+VW+AG'
              : 'https://group-wiki.wob.vw.vwg/wikis/display/SCHUTZPBD/Downloadbereich'
          "
          target="blank"
          class="expertenwissen-page__link"
          ref="link-3"
          >{{
            this.$store.state.language === "Deutsch"
              ? "Grundsatzthema Datenschutz-Folgenabschätzung"
              : "policy issue data protection impact assessment (DPIA)"
          }}</a
        >
        <img
          src="../assets/images/icons/icon-link-2x.png"
          alt="link icon"
          class="expertenwissen-page__icon"
        />
      </div>

      <div class="expertenwissen-page__item">
        <a
          :href="
            this.$store.state.language === 'Deutsch'
              ? 'https://group-wiki.wob.vw.vwg/wikis/display/SCHUTZPBD/Grundsatzthemen+der+VW+AG'
              : 'https://group-wiki.wob.vw.vwg/wikis/display/SCHUTZPBD/Downloadbereich'
          "
          target="blank"
          class="expertenwissen-page__link"
          ref="link-4"
          >{{
            this.$store.state.language === "Deutsch"
              ? "Löschung und Einschränkung"
              : "limitation and deletion"
          }}</a
        >
        <img
          src="../assets/images/icons/icon-link-2x.png"
          alt="link icon"
          class="expertenwissen-page__icon"
        />
      </div>

      <div class="expertenwissen-page__item">
        <a
          :href="
            this.$store.state.language === 'Deutsch'
              ? 'https://group-wiki.wob.vw.vwg/wikis/display/SCHUTZPBD/Grundsatzthemen+der+VW+AG'
              : 'https://group-wiki.wob.vw.vwg/wikis/display/SCHUTZPBD/Downloadbereich'
          "
          target="blank"
          class="expertenwissen-page__link"
          ref="link-5"
          >{{
            this.$store.state.language === "Deutsch"
              ? "Grundsatzthema Transparenz"
              : "policy issue transparency"
          }}</a
        >
        <img
          src="../assets/images/icons/icon-link-2x.png"
          alt="link icon"
          class="expertenwissen-page__icon"
        />
      </div>

      <div class="expertenwissen-page__item">
        <a
          :href="
            this.$store.state.language === 'Deutsch'
              ? 'https://group-wiki.wob.vw.vwg/wikis/display/SCHUTZPBD/Grundsatzthemen+der+VW+AG'
              : 'https://group-wiki.wob.vw.vwg/wikis/display/SCHUTZPBD/Downloadbereich'
          "
          target="blank"
          class="expertenwissen-page__link"
          ref="link-7"
          >{{
            this.$store.state.language === "Deutsch"
              ? "Grundsatzthema Datenschutzverträge"
              : "policy issue data protection agreements"
          }}</a
        >
        <img
          src="../assets/images/icons/icon-link-2x.png"
          alt="link icon"
          class="expertenwissen-page__icon"
        />
      </div>

      <div class="expertenwissen-page__item">
        <a
          :href="
            this.$store.state.language === 'Deutsch'
              ? 'https://group-wiki.wob.vw.vwg/wikis/display/SCHUTZPBD/Grundsatzthemen+der+VW+AG'
              : 'https://group-wiki.wob.vw.vwg/wikis/display/SCHUTZPBD/Downloadbereich'
          "
          target="blank"
          class="expertenwissen-page__link"
          ref="link-9"
          >{{
            this.$store.state.language === "Deutsch"
              ? "Grundsatzthema Betroffenenrechte"
              : "policy issue data subject rights"
          }}</a
        >
        <img
          src="../assets/images/icons/icon-link-2x.png"
          alt="link icon"
          class="expertenwissen-page__icon"
        />
      </div>

      <div class="expertenwissen-page__item">
        <a
          :href="
            this.$store.state.language === 'Deutsch'
              ? 'https://group-wiki.wob.vw.vwg/wikis/display/SCHUTZPBD/Grundsatzthemen+der+VW+AG'
              : 'https://group-wiki.wob.vw.vwg/wikis/display/SCHUTZPBD/Downloadbereich'
          "
          target="blank"
          class="expertenwissen-page__link"
          ref="link-10"
          >{{
            this.$store.state.language === "Deutsch"
              ? "Grundsatzthema Meldung von Datenschutzverletzungen"
              : "policy issue data breach reporting"
          }}</a
        >
        <img
          src="../assets/images/icons/icon-link-2x.png"
          alt="link icon"
          class="expertenwissen-page__icon"
        />
      </div>

      <div class="expertenwissen-page__item">
        <a
          :href="
            this.$store.state.language === 'Deutsch'
              ? 'https://volkswagen-net.de/wikis/display/Security/Startseite'
              : 'https://volkswagen-net.de/wikis/display/Security/Startseite'
          "
          target="blank"
          class="expertenwissen-page__link"
          ref="link-11"
          >{{
            this.$store.state.language === "Deutsch"
              ? "TOM / IT-Sicherheit"
              : "TOM / IT-Security"
          }}</a
        >
        <img
          src="../assets/images/icons/icon-link-2x.png"
          alt="link icon"
          class="expertenwissen-page__icon"
        />
      </div>

      <div class="expertenwissen-page__item">
        <a
          :href="
            this.$store.state.language === 'Deutsch'
              ? 'https://group-wiki.wob.vw.vwg/wikis/display/SCHUTZPBD/Kontaktpersonen+im+Datenschutz+-+Contact+persons+in+data+protection'
              : 'https://group-wiki.wob.vw.vwg/wikis/display/SCHUTZPBD/Kontaktpersonen+im+Datenschutz+-+Contact+persons+in+data+protection'
          "
          target="blank"
          class="expertenwissen-page__link"
          ref="link-12"
          >{{
            this.$store.state.language === "Deutsch"
              ? "Kontaktpersonen im Datenschutz"
              : "contact persons in data protection"
          }}</a
        >
        <img
          src="../assets/images/icons/icon-link-2x.png"
          alt="link icon"
          class="expertenwissen-page__icon"
        />
      </div>

      <div class="expertenwissen-page__item">
        <a
          :href="
            this.$store.state.language === 'Deutsch'
              ? 'https://volkswagen-net.de/wikis/dpn/endpage1'
              : 'https://volkswagen-net.de/wikis/dpn/endpage1'
          "
          target="blank"
          class="expertenwissen-page__link"
          ref="link-13"
          >{{
            this.$store.state.language === "Deutsch"
              ? "Qualifizierungen / Schulungen"
              : "Qualifications / Trainings"
          }}</a
        >
        <img
          src="../assets/images/icons/icon-link-2x.png"
          alt="link icon"
          class="expertenwissen-page__icon"
        />
      </div>
    </div>

    <!-- <div class="btnBackground"></div> -->
    <router-link
      tag="button"
      to="levels"
      class="btn--secondary expertenwissen-page__btn"
      data-name="btnBack"
    >
      {{
        this.$store.state.language === "Deutsch" ? "Zurück" : "Back"
      }}</router-link
    >
  </div>
</template>

<script>
export default {
  name: "expertenwissen"
};
</script>
