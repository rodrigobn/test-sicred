package com.rodrigo.votosassociados.data.model

import java.io.Serializable

data class ScreenFormularioContent(
    val id: String?,
    val titulo: String,
    val itens: List<Components>,
    val botaoOk: Components,
    val botaoCancelar: Components,
): Screen(), Serializable {
}