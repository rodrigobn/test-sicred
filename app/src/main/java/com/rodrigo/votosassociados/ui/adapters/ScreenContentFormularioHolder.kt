package com.rodrigo.votosassociados.ui.adapters

import android.view.View.VISIBLE
import androidx.recyclerview.widget.RecyclerView
import com.rodrigo.votosassociados.data.model.Components
import kotlinx.android.synthetic.main.view_screen_content_formulario.view.*

class ScreenContentFormularioHolder(
    private val screenContentFormulario: ScreenContentFormulario
) : RecyclerView.ViewHolder(screenContentFormulario) {

    fun bind(screen: Components) {
        val screenContent = screen as? Components ?: return

        when(screenContent.tipo){
            "TEXTO" -> setupSubtitle(screenContent)
            "INPUT_TEXTO" -> setupInputText(screenContent)
            "INPUT_NUMERO" -> setupInputNumber(screenContent)
            "INPUT_DATA" -> setupInputDate(screenContent)
        }
    }

    private fun setupSubtitle(screenContent: Components) {
        val description = screenContent.texto

        if (description != null) {
            screenContentFormulario.description.text = description
            screenContentFormulario.description.visibility = VISIBLE
            return
        }
    }

    private fun setupInputText(screenContent: Components?) {
        if (screenContent != null) {
            screenContentFormulario.layout_input_text.hint = screenContent.titulo
            screenContentFormulario.input_text.setText(screenContent.valor)
            screenContentFormulario.layout_input_text.visibility = VISIBLE
            return
        }

    }

    private fun setupInputNumber(screenContent: Components?) {
        if (screenContent != null) {
            screenContentFormulario.layout_input_numeric.hint = screenContent.titulo
            screenContentFormulario.input_numeric.setText(screenContent.valor)
            screenContentFormulario.layout_input_numeric.visibility = VISIBLE
            return
        }


    }

    private fun setupInputDate(screenContent: Components?) {
        if (screenContent != null) {
            screenContentFormulario.layout_input_date.hint = screenContent.titulo
            screenContentFormulario.input_date.setText(screenContent.valor)
            screenContentFormulario.layout_input_date.visibility = VISIBLE
            return
        }

    }
}
