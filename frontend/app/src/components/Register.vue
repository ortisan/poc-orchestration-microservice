<template>
  <div class="bg-primary">
    <div class="container">
      <div class="row">
        <div class="col-12">
          <div class="d-flex align-items-center min-vh-100">
            <div class="d-block bg-white shadow-lg rounded my-5">
              <div class="row">
                <div class="col-lg-7">
                  <div class="p-5">
                    <h1 class="h5 mb-1">Crie uma nova conta!</h1>
                    <p class="text-muted mb-4">
                      Não possui uma conta? Crie uma, leva menos de 1 minuto.
                    </p>

                    <form class="user" id="app" @submit="submit" novalidate>
                      <div class="form-group">
                        <input
                          type="text"
                          class="form-control"
                          :class="{ 'is-invalid': $v.name.$error }"
                          id="name"
                          v-model="name"
                          placeholder="Nome completo"
                          required
                        />
                        <div class="invalid-feedback" v-if="!$v.name.required">
                          Campo obrigatório
                        </div>
                      </div>

                      <div class="form-group row">
                        <label for="phisical_person">Física</label>
                        <input
                          type="radio"
                          id="phisical_person"
                          class="control-input"
                          :class="{ 'is-invalid': $v.type.$error }"
                          value="P"
                          v-model="type"
                          required
                        />
                        <label for="corporate_person">Jurídica</label>
                        <input
                          type="radio"
                          class="control-input"
                          :class="{ 'is-invalid': $v.type.$error }"
                          id="corporate_person"
                          value="C"
                          v-model="type"
                          required
                        />

                        <div class="invalid-feedback" v-if="!$v.type.required">
                          Campo obrigatório
                        </div>
                      </div>

                      <div class="form-group">
                        <input
                          type="text"
                          class="form-control"
                          :class="{ 'is-invalid': $v.cpf_cnpj.$error }"
                          id="cpf_cnpj"
                          v-model="cpf_cnpj"
                          placeholder="CPF/CNPJ"
                          required
                        />
                        <div
                          class="invalid-feedback"
                          v-if="!$v.cpf_cnpj.required"
                        >
                          Campo obrigatório
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="phone_ddi">Telefone</label>
                      </div>
                      <div class="form-group row">
                        <div class="col-sm-3 mb-3 mb-sm-0">
                          <input
                            type="text"
                            class="form-control"
                            :class="{ 'is-invalid': $v.phone.ddi.$error }"
                            v-model="phone.ddi"
                            id="phone_ddi"
                            placeholder="DDI"
                            required
                          />
                          <div
                            class="invalid-feedback"
                            v-if="!$v.phone.ddi.required"
                          >
                            Campo obrigatório
                          </div>
                        </div>

                        <div class="col-sm-3 mb-3 mb-sm-0">
                          <input
                            type="text"
                            class="form-control"
                            :class="{ 'is-invalid': $v.phone.ddd.$error }"
                            v-model="phone.ddd"
                            id="phone_ddd"
                            placeholder="DDD"
                            required
                          />
                          <div
                            class="invalid-feedback"
                            v-if="!$v.phone.ddd.required"
                          >
                            Campo obrigatório
                          </div>
                        </div>

                        <div class="col-sm-6 mb-3 mb-sm-0">
                          <input
                            type="text"
                            class="form-control"
                            :class="{
                              'is-invalid': $v.phone.number.$error
                            }"
                            v-model="phone.number"
                            id="phone_number"
                            placeholder="Número"
                            required
                          />
                          <div
                            class="invalid-feedback"
                            v-if="!$v.phone.number.required"
                          >
                            Campo obrigatório
                          </div>
                        </div>
                      </div>
                      <button type="submit" class="btn btn-success btn-block">
                        Criar conta
                      </button>
                    </form>
                  </div>
                  <!-- end .padding-5 -->
                </div>
                <!-- end col -->
              </div>
              <!-- end row -->
            </div>
            <!-- end .w-100 -->
          </div>
          <!-- end .d-flex -->
        </div>
        <!-- end col-->
      </div>
      <!-- end row -->
    </div>
    <!-- end container -->
  </div>
  <!-- end page -->
</template>
<script>
import { required } from 'vuelidate/lib/validators'
import { REGISTER } from '@/store/actions.type'

export default {
  name: 'RegisterComponent',
  data() {
    return {
      name: 'Marcelo Ortiz de Santana',
      cpf_cnpj: null,
      type: 'P',
      phone: {
        ddi: 55,
        ddd: 11,
        number: 1234567,
        extension_line: null
      }
    }
  },
  validations: {
    name: {
      required
    },
    cpf_cnpj: {
      required
    },
    type: {
      required
    },
    phone: {
      ddi: {
        required
      },
      ddd: {
        required
      },
      number: {
        required
      }
    }
  },

  methods: {
    submit: function (e) {
      e.preventDefault()

      this.$v.$touch()
      if (!this.$v.$invalid) {
        this.$store
          .dispatch(REGISTER, {
            name: this.name,
            type: this.type,
            cpf_cnpj: this.cpf_cnpj,
            phones: [{ ...this.phone }]
          })
          .then(() => this.$router.push({ name: 'success' }))
      }
    }
  }
}
</script>
