package com.rodrigo.votosassociados.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hadilq.liveevent.LiveEvent
import com.mlykotom.valifi.ValiFiForm
import com.mlykotom.valifi.fields.ValiFieldText
import com.mlykotom.valifi.fields.number.ValiFieldDouble
import com.rodrigo.votosassociados.R
import com.rodrigo.votosassociados.data.repository.Repository
import com.rodrigo.votosassociados.data.repository.network.helpers.ResultWrapper
import com.rodrigo.votosassociados.utils.handlerHttpError
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.regex.Pattern

class MainViewModel(private val repository: Repository): ViewModel() {

    var cpf: ValiFieldText = ValiFieldDouble()
        .addNotEmptyValidator(R.string.message_cpf_required)
        .addPatternValidator(
            R.string.message_format_invalid,
            Pattern.compile("([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})")
        )

    val mainViewState = LiveEvent<MainViewState>()
    private val formCpf = ValiFiForm(cpf)
    private var requestJob: Job = Job()

    fun sendCpf(){
        val isValidForm = validateFormCpf()

        if (!isValidForm) return

        requestJob.cancel()
        requestJob = viewModelScope.launch {
            mainViewState.value = MainViewState.Loading(true)

            when (val response = cpf.value?.let { repository.getCpf2(it) }){
                is ResultWrapper.Success -> mainViewState.value = MainViewState.Success(response.value)
                is ResultWrapper.Error -> mainViewState.value = MainViewState.Error(handlerError(response.code))
            }

            mainViewState.value = MainViewState.Loading(false)
        }
    }

    private fun validateFormCpf(): Boolean {
        formCpf.validate()
        return formCpf.isValid
    }

    private fun handlerError(code: Int? = null): Int {
        return when (code) {
            500 -> R.string.message_error_500
            else -> handlerHttpError(code)
        }
    }
}