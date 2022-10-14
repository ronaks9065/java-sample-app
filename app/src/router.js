/* eslint-disable no-console */
import Vue from "vue";
import Router from "vue-router";
import Welcome from "./components/Welcome.vue";
import Terms from "./views/Terms.vue";
import Levels from "./views/Levels.vue";
import Expertenwissen from "./views/Expertenwissen.vue";
import Rules from "./views/Rules.vue";
import Cars from "./views/Cars.vue";
import Quiz0 from "./views/quizzes/Quiz0.vue";
import Quiz1 from "./views/quizzes/Quiz1.vue";
import Quiz2 from "./views/quizzes/Quiz2.vue";
import Quiz3 from "./views/quizzes/Quiz3.vue";
import Quiz4 from "./views/quizzes/Quiz4.vue";
import Quiz5 from "./views/quizzes/Quiz5.vue";
import Quiz6 from "./views/quizzes/Quiz6.vue";
import Quiz7 from "./views/quizzes/Quiz7.vue";
import Quiz8 from "./views/quizzes/Quiz8.vue";
import Quiz9 from "./views/quizzes/Quiz9.vue";
import Quiz10 from "./views/quizzes/Quiz10.vue";
import Quiz11 from "./views/quizzes/Quiz11.vue";
import Quiz12 from "./views/quizzes/Quiz12.vue";
import Quiz13 from "./views/quizzes/Quiz13.vue";
import Quiz14 from "./views/quizzes/Quiz14.vue";
import Quiz15 from "./views/quizzes/Quiz15.vue";
import Quiz16 from "./views/quizzes/Quiz16.vue";
import Quiz17 from "./views/quizzes/Quiz17.vue";
import Quiz18 from "./views/quizzes/Quiz18.vue";
import Quiz19 from "./views/quizzes/Quiz19.vue";
import EndPage1 from "./views/EndPage1.vue";
import FinishLine from "./views/FinishLine.vue";
import Certificate from "./views/Certificate.vue";
import Feedback from "./views/Feedback.vue";
import Goodbye from "./views/Goodbye.vue";
import Reporting from "./views/Reporting.vue";
import { contentService } from "./services/content.service";
import store from "./store";

// function lazyLoad(view) {
//   return () => import(`./views/${view}.vue`);
// }

Vue.use(Router);

const router = new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    {
      name: "welcome",
      component: Welcome,
      path: "/index.html"
    },
    {
      name: "terms",
      component: Terms,
      path: "/terms"
    },
    {
      name: "rules",
      component: Rules,
      path: "/rules",
      beforeEnter: (to, from, next) => {
        if (!store.state.cookiesAccepted) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "levels",
      component: Levels,
      path: "/levels",
      beforeEnter: (to, from, next) => {
        if (!store.state.cookiesAccepted) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "expertenwissen",
      component: Expertenwissen,
      path: "/expertenwissen",
      beforeEnter: (to, from, next) => {
        if (!store.state.cookiesAccepted && store.state.selectedLevel) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "cars",
      component: Cars,
      path: "/cars",
      beforeEnter: (to, from, next) => {
        if (!store.state.cookiesAccepted && store.state.selectedLevel) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "quiz0",
      component: Quiz0,
      path: "/quiz0",
      beforeEnter: (to, from, next) => {
        if (
          !store.state.cookiesAccepted &&
          store.state.selectedLevel &&
          store.state.selectedCar
        ) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "quiz1",
      component: Quiz1,
      path: "/quiz1",
      beforeEnter: (to, from, next) => {
        if (
          !store.state.cookiesAccepted &&
          store.state.selectedLevel &&
          store.state.selectedCar
        ) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "quiz2",
      component: Quiz2,
      path: "/quiz2",
      beforeEnter: (to, from, next) => {
        if (
          !store.state.cookiesAccepted &&
          store.state.selectedLevel &&
          store.state.selectedCar
        ) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "quiz3",
      component: Quiz3,
      path: "/quiz3",
      beforeEnter: (to, from, next) => {
        if (
          !store.state.cookiesAccepted &&
          store.state.selectedLevel &&
          store.state.selectedCar
        ) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "quiz4",
      component: Quiz4,
      path: "/quiz4",
      beforeEnter: (to, from, next) => {
        if (
          !store.state.cookiesAccepted &&
          store.state.selectedLevel &&
          store.state.selectedCar
        ) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "quiz5",
      component: Quiz5,
      path: "/quiz5",
      beforeEnter: (to, from, next) => {
        if (
          !store.state.cookiesAccepted &&
          store.state.selectedLevel &&
          store.state.selectedCar
        ) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "quiz6",
      component: Quiz6,
      path: "/quiz6",
      beforeEnter: (to, from, next) => {
        if (
          !store.state.cookiesAccepted &&
          store.state.selectedLevel &&
          store.state.selectedCar
        ) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "quiz7",
      component: Quiz7,
      path: "/quiz7",
      beforeEnter: (to, from, next) => {
        if (
          !store.state.cookiesAccepted &&
          store.state.selectedLevel &&
          store.state.selectedCar
        ) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "quiz8",
      component: Quiz8,
      path: "/quiz8",
      beforeEnter: (to, from, next) => {
        if (
          !store.state.cookiesAccepted &&
          store.state.selectedLevel &&
          store.state.selectedCar
        ) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "quiz9",
      component: Quiz9,
      path: "/quiz9",
      beforeEnter: (to, from, next) => {
        if (
          !store.state.cookiesAccepted &&
          store.state.selectedLevel &&
          store.state.selectedCar
        ) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "quiz10",
      component: Quiz10,
      path: "/quiz10",
      beforeEnter: (to, from, next) => {
        if (
          !store.state.cookiesAccepted &&
          store.state.selectedLevel &&
          store.state.selectedCar
        ) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "quiz11",
      component: Quiz11,
      path: "/quiz11",
      beforeEnter: (to, from, next) => {
        if (
          !store.state.cookiesAccepted &&
          store.state.selectedLevel &&
          store.state.selectedCar
        ) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "quiz12",
      component: Quiz12,
      path: "/quiz12",
      beforeEnter: (to, from, next) => {
        if (
          !store.state.cookiesAccepted &&
          store.state.selectedLevel &&
          store.state.selectedCar
        ) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "quiz13",
      component: Quiz13,
      path: "/quiz13",
      beforeEnter: (to, from, next) => {
        if (
          !store.state.cookiesAccepted &&
          store.state.selectedLevel &&
          store.state.selectedCar
        ) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "quiz14",
      component: Quiz14,
      path: "/quiz14",
      beforeEnter: (to, from, next) => {
        if (
          !store.state.cookiesAccepted &&
          store.state.selectedLevel &&
          store.state.selectedCar
        ) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "quiz15",
      component: Quiz15,
      path: "/quiz15",
      beforeEnter: (to, from, next) => {
        if (
          !store.state.cookiesAccepted &&
          store.state.selectedLevel &&
          store.state.selectedCar
        ) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "quiz16",
      component: Quiz16,
      path: "/quiz16",
      beforeEnter: (to, from, next) => {
        if (
          !store.state.cookiesAccepted &&
          store.state.selectedLevel &&
          store.state.selectedCar
        ) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "quiz17",
      component: Quiz17,
      path: "/quiz17",
      beforeEnter: (to, from, next) => {
        if (
          !store.state.cookiesAccepted &&
          store.state.selectedLevel &&
          store.state.selectedCar
        ) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "quiz18",
      component: Quiz18,
      path: "/quiz18",
      beforeEnter: (to, from, next) => {
        if (
          !store.state.cookiesAccepted &&
          store.state.selectedLevel &&
          store.state.selectedCar
        ) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "quiz19",
      component: Quiz19,
      path: "/quiz19",
      beforeEnter: (to, from, next) => {
        if (
          !store.state.cookiesAccepted &&
          store.state.selectedLevel &&
          store.state.selectedCar
        ) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "finishline",
      component: FinishLine,
      path: "/finish",
      beforeEnter: (to, from, next) => {
        if (
          !store.state.cookiesAccepted &&
          store.state.selectedLevel &&
          store.state.selectedCar
        ) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "endpage1",
      component: EndPage1,
      path: "/endpage1",
      beforeEnter: (to, from, next) => {
        if (
          !store.state.cookiesAccepted &&
          store.state.selectedLevel &&
          store.state.selectedCar
        ) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "certificate",
      component: Certificate,
      path: "/certificate",
      beforeEnter: (to, from, next) => {
        if (
          !store.state.cookiesAccepted &&
          store.state.selectedLevel &&
          store.state.selectedCar
        ) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "feedback",
      component: Feedback,
      path: "/feedback",
      beforeEnter: (to, from, next) => {
        if (
          !store.state.cookiesAccepted &&
          store.state.selectedLevel &&
          store.state.selectedCar
        ) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "goodbye",
      component: Goodbye,
      path: "/complete",
      beforeEnter: (to, from, next) => {
        if (
          !store.state.cookiesAccepted &&
          store.state.selectedLevel &&
          store.state.selectedCar
        ) {
          next();
        } else {
          next(false);
        }
      }
    },
    {
      name: "reporting",
      component: Reporting,
      path: "/reporting",
      beforeEnter: (to, from, next) => {
        if (
          !store.state.cookiesAccepted &&
          store.state.selectedLevel &&
          store.state.selectedCar
        ) {
          next();
        } else {
          next(false);
        }
      }
    },
    { path: "*", redirect: "/index.html" }
  ]
});

router.beforeEach((to, from, next) => {
  // if user is not logged the call will redirect to login.
  contentService.getContents("l");
  next();
});

export default router;
