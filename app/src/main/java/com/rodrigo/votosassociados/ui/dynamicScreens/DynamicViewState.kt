package com.rodrigo.votosassociados.ui.dynamicScreens

import com.rodrigo.votosassociados.data.model.ScreenFormularioContent

sealed class DynamicViewState {
    class ShowScreen(val screenFormulario: ScreenFormularioContent) : DynamicViewState()
    class Error(val resId: Int) : DynamicViewState()
}