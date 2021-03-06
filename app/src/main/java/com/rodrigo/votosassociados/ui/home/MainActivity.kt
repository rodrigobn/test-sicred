package com.rodrigo.votosassociados.ui.home

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.rodrigo.votosassociados.R
import com.rodrigo.votosassociados.data.model.StatusVote
import com.rodrigo.votosassociados.databinding.ActivityMainBinding
import com.rodrigo.votosassociados.ui.custom.DialogLoading
import com.rodrigo.votosassociados.ui.dynamicScreens.DynamicActivity
import com.rodrigo.votosassociados.ui.dynamicScreens.DynamicFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModel()

    private var dialogLoading: DialogLoading? = null
    private var builder: AlertDialog.Builder? = null
    private var dialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        initView()
        initObserver()
        //startDynamicFragment()

    }

    private fun initView() {
        dialogLoading = DialogLoading.newDialog(null, getString(R.string.message_processing_action))
        builder = AlertDialog.Builder(this)
    }

    private fun initObserver() {
        viewModel.mainViewState.observe(this, {
            when (it) {
                is MainViewState.Loading -> displayLoading(it.isActive)
                is MainViewState.Success -> handlerSuccess(it)
                is MainViewState.Error -> handlerError(it)
            }
        })
    }

    private fun handlerError(error: MainViewState.Error) {
        Toast.makeText(this, getString(error.resId), Toast.LENGTH_LONG).show()
    }

    private fun handlerSuccess(checkToVote: MainViewState.Success) {
        when (checkToVote.statusVote.status){
            StatusVote.ABLE_TO_VOTE -> showDialogAble()
            StatusVote.UNABLE_TO_VOTE -> showDialogUnable()
        }

    }

    private fun showDialogAble() {
        builder?.setTitle("CPF aprovado para vota????o")
        builder?.setMessage("Voc?? deseja continuar para as op????es de voto?")
        builder?.setPositiveButton("Sim"){ _, _ ->
            startDynamicFragment()
        }
        builder?.setNegativeButton("N??o"){ _, _ ->
            //TODO
        }

        dialog = builder?.create()
        dialog?.show()
    }

    private fun startDynamicFragment() {
        val intent = Intent(this, DynamicActivity::class.java)
        startActivity(intent)
    }

    private fun showDialogUnable() {
        builder?.setTitle("CPF n??o aprovado para vota????o")
        builder?.setMessage("Entre em contato com o suporte para esclarecimentos")
        builder?.setPositiveButton("OK"){ _, _ ->
            //TODO
        }

        dialog = builder?.create()
        dialog?.show()
    }

    private fun displayLoading(active: Boolean) {
        when(active){
            true -> dialogLoading?.show(supportFragmentManager)
            false -> dialogLoading?.close()
        }
    }
}