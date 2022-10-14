import { Commons } from "./commons.service";
import axios from "axios";

// NOTE *** We cannot make POST requests in Confluence without encountering an XSRF error
const config = {
  headers: Commons.Header(),
  withCredentials: true
};

// PUT request to send user info to backend at beginning of quiz
export const postUserDataStart = async (
  selectedLevel,
  currentQuiz,
  progressBasic,
  progressAdvanced,
  progressLeader
) => {
  try {
    const body = JSON.stringify({
      progressedBasic: progressBasic,
      progressedAdvanced: progressAdvanced,
      progressedLeader: progressLeader,
      selectedLevel,
      currentQuiz
    });

    await axios.put(`${Commons.ApiBase()}/quiz/quizStarted`, body, config);
  } catch (err) {
    console.log("ERROR!: " + err);
  }
};

// PUT request to send user info to backend at ending of quiz
export const postUserDataFinish = async (
  selectedLevel,
  currentQuiz,
  progressBasic,
  progressAdvanced,
  progressLeader
) => {
  try {
    const body = JSON.stringify({
      progressedBasic: progressBasic,
      progressedAdvanced: progressAdvanced,
      progressedLeader: progressLeader,
      selectedLevel,
      currentQuiz
    });

    await axios.put(`${Commons.ApiBase()}/quiz/quizFinished`, body, config);
  } catch (err) {
    console.log("ERROR!: " + err);
  }
};

// PUT user feedback
export const postUserFeedback = async (score, comment) => {
  try {
    const body = JSON.stringify({
      score,
      comment
    });

    await axios.put(`${Commons.ApiBase()}/feedback`, body, config);
  } catch (err) {
    console.log("ERROR!: " + err);
  }
};
