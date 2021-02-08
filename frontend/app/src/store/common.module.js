import { SET_VALIDATION_ERROR, SET_ERROR } from './mutations.type'

const initialState = {
  errors: [],
  errors_messages: '',
  validation_errors: []
}

const state = { ...initialState }

const getters = {}

const actions = {}

const mutations = {
  [SET_ERROR](state, error) {
    if (!error) {
      error = {
        code: 500,
        message: 'Sistema indisponível. Tente novamente mais tarde.'
      }
    }
    state.errors = []
    state.errors = [...state.errors, error]
    state.errors_messages = state.errors.map(error_ => error_.message).join(',')
  },
  [SET_VALIDATION_ERROR](state, error_message) {
    if (!error_message) {
      error_message = 'Sistema indisponível'
    }
    state.validation_errors = [...error_message]
  }
}

export default {
  state,
  actions,
  mutations,
  getters
}
