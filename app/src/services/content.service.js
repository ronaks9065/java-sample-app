import { Commons } from "./commons.service";
import axios from "axios";

export const contentService = {
  getContents,
  replaceContents,
  fillBoxes
};

/**
 * Call the API to get the content for the current page
 * @param page the page to get the content for.
 * @returns {Promise<AxiosResponse<T>>}
 */
function getContents(page, language) {
  let url = `${Commons.ApiBase()}/content?page=${page}`;
  if (language !== undefined) {
    url = url + "&language=" + language;
  }
  return axios
    .get(url, {
      headers: Commons.Header(),
      withCredentials: true
    })
    .then(res => {
      return res.data;
    })
    .catch(err => {
      // Not logged in
      if (process.env.VUE_APP_STAGE !== "DEV" && err.response.status === 401) {
        window.location.replace(
          "/confluence/login.action?os_destination=/dpn/index.html"
        );
      }
    });
}

function replaceContents(refs, data) {
  // ISSUE is data is defined but refs are not
  for (let ref in refs) {
    let filter = data.filter(c => c.name === ref);
    if (filter.length > 0) {
      if (refs[ref] !== undefined) {
        refs[ref].innerHTML = filter[0].content;
      }
    }
  }
}
function fillBoxes(d, contents) {
  let id = Number(d.name.split("_")[0]);
  let name = d.name.split("_")[1];
  if (contents !== undefined)
    contents.forEach(content => {
      if (content.id === id) {
        switch (name) {
          case "heading":
          case "carName":
          case "animationName":
          case "text": {
            eval(`content.${name} = "${d.content}"`);
            break;
          }
          case "image":
          case "effect":
          case "icon": {
            let imgAsString = d.content;
            let div = document.createElement("div");
            div.innerHTML = imgAsString;
            eval(`content.${name} = div.getElementsByTagName("img")[0].src`);
            break;
          }
        }
      }
    });
}
