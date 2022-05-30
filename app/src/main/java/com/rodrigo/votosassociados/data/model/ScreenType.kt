package com.rodrigo.votosassociados.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

enum class ScreenType(
    val type: String
) : Serializable {
    @SerializedName("FORMULARIO")
    FORMULARIO("FORMULARIO"),

    @SerializedName("SELECAO")
    SELECAO("SELECAO");

    companion object {
        fun getContentType(type: String?): ScreenType {
            var typeEnum = FORMULARIO

            for (typeValue in values()) {
                if (typeValue.type == type) {
                    typeEnum = typeValue
                    break
                }
            }

            return typeEnum
        }
    }
}