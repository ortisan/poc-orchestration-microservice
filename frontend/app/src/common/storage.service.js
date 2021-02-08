const USER_DATA = 'user_data'

export const getUser = () => {
  let jsonData = window.localStorage.getItem(USER_DATA)
  if (jsonData) {
    try {
      return JSON.parse(jsonData)
    } catch (exc) {
      return {}
    }
  }
  return {}
}

export const saveUser = (user) => {
  window.localStorage.setItem(USER_DATA, JSON.stringify(user))
}

export const destroy = () => {
  window.localStorage.removeItem(USER_DATA)
}

export default {
  getUser,
  saveUser,
  destroy
}
