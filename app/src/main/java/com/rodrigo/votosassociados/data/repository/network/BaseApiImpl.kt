package com.rodrigo.votosassociados.data.repository.network

import com.rodrigo.votosassociados.data.model.ScreenFormularioContent
import com.rodrigo.votosassociados.data.model.StatusVote
import com.rodrigo.votosassociados.data.repository.network.helpers.NetworkHelper
import com.rodrigo.votosassociados.data.repository.network.helpers.ResultWrapper
import kotlinx.coroutines.CoroutineDispatcher

class BaseApiImpl(
    private val service: BaseService,
    private val networkHelper: NetworkHelper,
    private val dispatcher: CoroutineDispatcher
) : BaseApi {

    override suspend fun getScreenFormulario(type: String): ResultWrapper<ScreenFormularioContent> {
        return networkHelper.safeApiCall(dispatcher) {
            service.getScreenFormulario(type)
        }
    }

    override suspend fun getScreenSelecao(type: String): ResultWrapper<ScreenFormularioContent> {
        return networkHelper.safeApiCall(dispatcher) {
            service.getScreenSelecao(type)
        }
    }

    override suspend fun getCpf(cpf: String): ResultWrapper<StatusVote> {
        return networkHelper.safeApiCall(dispatcher) {
            service.getCpf(cpf)
        }
    }

    override suspend fun getCpf2(cpf: String): ResultWrapper<StatusVote> {
        return networkHelper.safeApiCall(dispatcher) {
            service.getCpf2(cpf)
        }
    }
}