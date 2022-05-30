package com.rodrigo.votosassociados.ui.adapters

import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.rodrigo.votosassociados.data.model.Components
import com.rodrigo.votosassociados.data.model.ScreenType

class ScreenContentAdapter(
    private var items: List<Components>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when(viewType) {
        ScreenType.FORMULARIO.ordinal -> ScreenContentFormularioHolder(ScreenContentFormulario(parent.context))
        ScreenType.SELECAO.ordinal -> ScreenContentSelecaoHolder(ScreenContentSelecao(parent.context))
        else -> object: RecyclerView.ViewHolder(ConstraintLayout(parent.context)) { }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val screen = items.getOrNull(position) ?: return

        when (getItemViewType(position)) {
            ScreenType.FORMULARIO.ordinal -> (holder as? ScreenContentFormularioHolder)?.bind(screen)
            ScreenType.SELECAO.ordinal -> (holder as? ScreenContentSelecaoHolder)?.bind(screen)
            else -> {}

        }

    }
}