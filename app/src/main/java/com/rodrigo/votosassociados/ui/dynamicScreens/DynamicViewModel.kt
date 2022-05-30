package com.rodrigo.votosassociados.ui.dynamicScreens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hadilq.liveevent.LiveEvent
import com.rodrigo.votosassociados.data.repository.Repository
import com.rodrigo.votosassociados.data.repository.network.helpers.ResultWrapper
import com.rodrigo.votosassociados.utils.handlerHttpError
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DynamicViewModel(private val repository: Repository): ViewModel() {

    var dynamicViewState = LiveEvent<DynamicViewState>()

    private var requestJob: Job = Job()

    fun getScreen() {
        requestJob.cancel()
        requestJob = viewModelScope.launch {
            when (val response = repository.getScreenFormulario("FORMULARIO")){
                is ResultWrapper.Success -> {
                    dynamicViewState.value = DynamicViewState.ShowScreen(response.value)
                }
                is ResultWrapper.Error -> DynamicViewState.Error(handlerHttpError(response.code))
            }

        }
    }
}