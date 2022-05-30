package com.rodrigo.votosassociados.data.repository.network

import com.rodrigo.votosassociados.data.model.ScreenFormularioContent
import com.rodrigo.votosassociados.data.model.StatusVote
import com.rodrigo.votosassociados.data.repository.network.helpers.ResultWrapper

interface BaseApi {
    suspend fun getScreenFormulario(type: String): ResultWrapper<ScreenFormularioContent>

    suspend fun getScreenSelecao(type: String): ResultWrapper<ScreenFormularioContent>

    suspend fun getCpf(cpf: String): ResultWrapper<StatusVote>

    suspend fun getCpf2(cpf: String): ResultWrapper<StatusVote>
}