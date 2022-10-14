import { Commons } from "./commons.service";
import axios from "axios";

// GET request to update store info if lost
export const getUserData = async device => {
  try {
    return await axios.get(
      `${Commons.ApiBase()}/userProgress?device=${device}`,
      {
        headers: Commons.Header(),
        withCredentials: true
      }
    );
  } catch (err) {
    console.log("ERROR!: " + err);
  }
};

// GET request to retrieve user name for certificate
export const getUserName = async selectedLevel => {
  try {
    return await axios.get(
      `${Commons.ApiBase()}/certificate/${selectedLevel}`,
      {
        headers: Commons.Header(),
        withCredentials: true
      }
    );
  } catch (err) {
    console.log("ERROR!: " + err);
  }
};

// GET request to retrieve reporting info
export const getReport = async (from, to) => {
  try {
    return await axios.get(`${Commons.ApiBase()}/report/all`, {
      params: {
        from,
        to
      }
    });
  } catch (err) {
    console.log("ERROR!: " + err);
  }
};
