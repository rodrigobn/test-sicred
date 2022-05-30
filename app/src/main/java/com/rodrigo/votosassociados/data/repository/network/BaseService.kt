package com.rodrigo.votosassociados.data.repository.network

import com.rodrigo.votosassociados.data.model.ScreenFormularioContent
import com.rodrigo.votosassociados.data.model.StatusVote
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BaseService {

    @GET("/api/v1/Screen")
    suspend fun getScreenFormulario(
        @Query("type") type: String?
    ): ScreenFormularioContent

    @GET("/api/v1/screen2")
    suspend fun getScreenSelecao(
        @Query("type") type: String?
    ): ScreenFormularioContent

    @GET("/users/{cpf}")
    suspend fun getCpf(
        @Path("cpf") cpf: String
    ): StatusVote

    @GET("/api/v1/users")
    suspend fun getCpf2(
        @Query("cpf") cpf: String
    ): StatusVote
}