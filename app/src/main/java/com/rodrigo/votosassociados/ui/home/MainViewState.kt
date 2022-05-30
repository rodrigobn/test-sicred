package com.rodrigo.votosassociados.ui.home

import com.rodrigo.votosassociados.data.model.StatusVote

sealed class MainViewState {
    class Loading(val isActive: Boolean) : MainViewState()
    class Error(val resId: Int) : MainViewState()
    class Success(val statusVote: StatusVote) : MainViewState()
}