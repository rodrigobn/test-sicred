package com.rodrigo.votosassociados.ui.dynamicScreens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.rodrigo.votosassociados.R
import com.rodrigo.votosassociados.data.model.ScreenFormularioContent
import com.rodrigo.votosassociados.data.model.ScreenType
import com.rodrigo.votosassociados.ui.adapters.ScreenContentAdapter
import kotlinx.android.synthetic.main.fragment_dynamic.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class DynamicFragment : Fragment() {


    private val viewModel: DynamicViewModel by sharedViewModel()

    companion object {

        @JvmStatic
        fun newInstance() = DynamicFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dynamic, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initObservers()
        viewModel.getScreen()

    }

    private fun initObservers() {
        viewModel.dynamicViewState.observe(this, {
            when (it){
                is DynamicViewState.ShowScreen -> showData(it.screenFormulario)
            }
        })
    }

    private fun showData(screenFormulario: ScreenFormularioContent) {
        title.text = screenFormulario.titulo
        recyclerview.apply {
            layoutManager = LinearLayoutManager(this@DynamicFragment.context, LinearLayoutManager.VERTICAL, false)

            adapter = ScreenContentAdapter(screenFormulario.itens)
        }

        if (screenFormulario.tipo == ScreenType.FORMULARIO){
            btn1.text = screenFormulario.botaoCancelar.texto
            btn2.text = screenFormulario.botaoOk.texto
            layout_buttons.visibility = VISIBLE
        }
    }

}