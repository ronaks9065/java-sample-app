<template>
  <div>
    <div class="cars-page">
      <div class="cars-page__header">
        <h3 ref="title" class="colorbluedark">Wählen Sie Ihr Auto</h3>
      </div>

      <div class="cars-page__text">
        <p ref="text">
          Bitte schieben Sie Ihr Lieblingsauto auf den Startplatz in der Mitte
          und bestätigen Sie die Auswahl.
        </p>
      </div>

      <div class="car-carousel" id="car-carousel" ref="carousel">
        <CarsBox
          v-for="content in contents"
          :key="content.id"
          :number="content.id"
          :image="content.image"
          :imageready="content.imageready"
          :carName="content.carName"
          :animationName="content.animationName"
          :class="{ carhighlight: content == selectedCar }"
          @click.native="
            commitCar(content),
              setButtonClass(selectedCar),
              setCarClass(selectedCar)
          "
        />
      </div>
      <img src="../assets/images/misc/honeycomb.png" alt class="honeycomb" />
      <transition name="fade">
        <PageButtons
          vif="selectedCar"
          btnsclass="cars-page__buttons"
          btn1class="btn--secondary cars-page__button"
          :btn2class="this.setButtonClass(selectedCar)"
          :next="this.selectedLevel === 4 ? 'quiz13' : 'quiz0'"
          back="levels"
          @click="commitTransitionAnimation('fade')"
        ></PageButtons>
      </transition>
    </div>
  </div>
</template>

<script>
import PageButtons from "../components/PageButtons";
import CarsBox from "../components/CarsBox";
import { mapActions, mapGetters, mapState } from "vuex";
import { contentService } from "../services/content.service";

export default {
  computed: {
    ...mapState(["selectedCar", "selectedLevel"]),
    ...mapGetters(["getSelectedCar"])
  },
  methods: {
    ...mapActions(["commitCar", "commitTransitionAnimation"]),
    setButtonClass: function(selectedCar) {
      if (selectedCar) {
        return "btn--standard cars-page__button";
      } else {
        return "btn--disabled cars-page__button";
      }
    },
    setCarClass: function(selectedCar) {
      let cars = document.getElementsByClassName("car-ready");

      switch (selectedCar.id) {
        case 1:
          cars[0].style.animation = "car-select 1s forwards";
          if (cars[1].style.animation) {
            cars[1].style.animation = "car-deselect 1s forwards";
          }
          if (cars[2].style.animation) {
            cars[2].style.animation = "car-deselect 1s forwards";
          }
          break;
        case 2:
          cars[1].style.animation = "car-select 1s forwards";

          if (cars[0].style.animation) {
            cars[0].style.animation = "car-deselect 1s forwards";
          }
          if (cars[2].style.animation) {
            cars[2].style.animation = "car-deselect 1s forwards";
          }
          break;
        case 3:
          cars[2].style.animation = "car-select 1s forwards";

          if (cars[1].style.animation) {
            cars[1].style.animation = "car-deselect 1s forwards";
          }
          if (cars[0].style.animation) {
            cars[0].style.animation = "car-deselect 1s forwards";
          }
          break;
        default:
          break;
      }
    }
  },
  name: "cars",
  components: {
    PageButtons,
    CarsBox
  },
  mounted() {
    document.getElementById("nav").style.position = "relative";

    let scrollArea = document.documentElement.clientWidth / 3;
    this.$refs["carousel"].scrollLeft = scrollArea;

    contentService
      .getContents("cars", this.$store.state.language)
      .then(data => {
        contentService.replaceContents(this.$refs, data);
        data.forEach(d => {
          contentService.fillBoxes(d, this.contents);
        });
      });
  },
  data: function() {
    return {
      contents: [
        {
          id: 1,
          image: require(`@/assets/images/cars/ID-CROZZ-Drive.png`),
          imageready: require(`@/assets/images/cars/ID-CROZZ-Ready.png`),
          effect: require(`@/assets/images/cars/ID-CROZZ-Effect.png`),
          carName: "ID-CROZZ",
          animationName: "car-enter-1"
        },
        {
          id: 2,
          image: require(`@/assets/images/cars/ID-VIZZION-Drive.png`),
          imageready: require(`@/assets/images/cars/ID-VIZZION-Ready.png`),
          effect: require(`@/assets/images/cars/ID-VIZZION-Effect.png`),
          carName: "ID-VIZZION",
          animationName: "car-enter-2"
        },
        {
          id: 3,
          image: require(`@/assets/images/cars/ID-BUGGY-Drive.png`),
          imageready: require(`@/assets/images/cars/ID-BUGGY-Ready.png`),
          effect: require(`@/assets/images/cars/ID-BUGGY-Effect.png`),
          carName: "ID-BUGGY",
          text: "Schnell zum gewünschten Thema und zu Detail-Infos.",
          animationName: "car-enter-3"
        }
      ]
    };
  },
  created() {
    this.$store.subscribe((mutation, state) => {
      if (mutation.type === "mutateLanguage") {
        contentService
          .getContents("cars", this.$store.state.language)
          .then(data => {
            contentService.replaceContents(this.$refs, data);
            data.forEach(d => {
              contentService.fillBoxes(d, this.contents);
            });
          });
      }
    });
  }
};
</script>
