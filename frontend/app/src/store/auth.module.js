import ApiService from '@/common/api.service'
import StorageService from '@/common/storage.service'
// import router from '../router'

import { REGISTER } from './actions.type'
import { SET_ERROR } from './mutations.type'

const initialState = {
  errors: [],
  user: { ...StorageService.getUser() }
}

const state = { ...initialState }

const getters = {
  user: (state) => state.user
}

const actions = {
  [REGISTER]({ commit }, payload) {
    return new Promise((resolve, reject) => {
      let payload_orquestrator = {
        person_data: { ...payload },
        fields: [
          {
            field_name: 'name',
            value: payload.name,
            level: 400,
            validated: true,
            created_date: '2021-01-02T18:25:43.511Z'
          }
        ]
      }

      ApiService.post('orchestrator/tenant/1234/person/', payload_orquestrator)
        .then(({ data }) => {
          resolve(data)
        })
        .catch((error) => {
          console.log(error)
          // console.log(response)
          // let error = null
          // if (response && response.data) {
          //   error = response.data
          // }
          commit(SET_ERROR, error)
          reject(error)
        })
    })
  }
}

const mutations = {}

export default {
  state,
  actions,
  mutations,
  getters
}
