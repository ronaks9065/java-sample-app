export const Commons = {
  ApiBase,
  Header
};

/**
 * Generates the base Url for the api calls.
 * @return {string} Api base url
 */
function ApiBase() {
  let host = process.env.VUE_APP_API_HOST;
  let port = process.env.VUE_APP_API_PORT;
  let useSSL = JSON.parse(process.env.VUE_APP_API_USE_SSL);
  let apiBasePath = process.env.VUE_APP_API_BASE_PATH;
  let http = useSSL ? "https" : "http";
  if (process.env.NODE_ENV.indexOf("develo") !== -1) {
    return `${http}://${host}:${port}${apiBasePath}`;
  } else {
    return `${apiBasePath}`;
  }
}

function Header() {
  let host = process.env.VUE_APP_API_HOST;
  let port = process.env.VUE_APP_API_PORT;
  let useSSL = JSON.parse(process.env.VUE_APP_API_USE_SSL);
  let apiBasePath = process.env.VUE_APP_API_BASE_PATH;
  let http = useSSL ? "https" : "http";
  return {
    "Content-Type": "application/json",
    "Access-Control-Allow-Origin": `${http}://${host}:${port}${apiBasePath}`,
    "X-Atlassian-Token": "no-check"
  };
}
