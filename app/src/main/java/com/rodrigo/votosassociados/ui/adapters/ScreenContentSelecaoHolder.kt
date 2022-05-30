package com.rodrigo.votosassociados.ui.adapters

import androidx.recyclerview.widget.RecyclerView
import com.rodrigo.votosassociados.data.model.Components
import kotlinx.android.synthetic.main.view_screen_content_selecao.view.*

class ScreenContentSelecaoHolder(
    private val screenContentSelecao: ScreenContentSelecao
) : RecyclerView.ViewHolder(screenContentSelecao) {

    fun bind(screen: Components) {
        val screenContent = screen as? Components ?: return

        screenContentSelecao.title.text = screenContent.texto
    }
}
