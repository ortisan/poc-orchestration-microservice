console.log(process.env)

export const API_URL = process.env.VUE_APP_API_URL
  ? process.env.VUE_APP_API_URL
  : 'http://localhost:8082/'
export default { API_URL }
