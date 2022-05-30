package com.rodrigo.votosassociados.data.repository

import com.rodrigo.votosassociados.data.model.ScreenFormularioContent
import com.rodrigo.votosassociados.data.model.StatusVote
import com.rodrigo.votosassociados.data.repository.network.BaseApi
import com.rodrigo.votosassociados.data.repository.network.helpers.ResultWrapper

class RepositoryImpl(
    private val baseApi: BaseApi
): Repository {

    override suspend fun getScreenFormulario(type: String): ResultWrapper<ScreenFormularioContent> {
        return baseApi.getScreenFormulario(type)
    }

    override suspend fun getScreenSelecao(type: String): ResultWrapper<ScreenFormularioContent> {
        return baseApi.getScreenSelecao(type)
    }

    override suspend fun getCpf(cpf: String): ResultWrapper<StatusVote> {
        return baseApi.getCpf(cpf)
    }

    override suspend fun getCpf2(cpf: String): ResultWrapper<StatusVote> {
        return baseApi.getCpf2(cpf)
    }
}