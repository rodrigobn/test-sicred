package com.rodrigo.votosassociados.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

open class Screen: Serializable {

    @SerializedName("tipo")
    open var tipo: ScreenType = ScreenType.FORMULARIO
}