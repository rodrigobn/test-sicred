package com.rodrigo.votosassociados.data.model

import java.io.Serializable

data class ScreenSelecaoContent(
    val id: String?,
    val titulo: String,
    val itens: List<Components>
): Screen(), Serializable {
}