package com.rodrigo.votosassociados.data.deserializer

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken
import com.rodrigo.votosassociados.data.model.*
import java.lang.reflect.Type

class ScreenContentDeserializer: JsonDeserializer<Screen> {

    private val screenComponents: Type = object : TypeToken<List<Screen>>() {}.type

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type?,
        context: JsonDeserializationContext
    ): Screen {
        val obj = json.asJsonObject

        return when (ScreenType.getContentType(obj?.get("tipo")?.asString)) {
            ScreenType.FORMULARIO -> ScreenFormularioContent( //Gson().fromJson(obj, ScreenFormularioContent::class.java)
                context.deserialize(obj.get("id"), String::class.java),
                context.deserialize(obj.get("titulo"), String::class.java),
                context.deserialize(obj.get("itens"), screenComponents),
                context.deserialize(obj.get("botaoOk"), Components::class.java),
                context.deserialize(obj.get("botaoCancelar"), Components::class.java)
            ).apply {
                tipo = context.deserialize(obj.get("tipo"), ScreenType::class.java)
            }
            ScreenType.SELECAO -> ScreenSelecaoContent(
                context.deserialize(obj.get("id"), String::class.java),
                context.deserialize(obj.get("titulo"), String::class.java),
                context.deserialize(obj.get("itens"), screenComponents)
            ).apply {
                tipo = context.deserialize(obj.get("tipo"), ScreenType::class.java)
            }
        }
    }
}