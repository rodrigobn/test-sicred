package com.rodrigo.votosassociados.ui.dynamicScreens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.rodrigo.votosassociados.R
import com.rodrigo.votosassociados.databinding.ActivityDynamicBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DynamicActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDynamicBinding
    private val viewModel: DynamicViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dynamic)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        startFragment()
    }

    private fun startFragment() {
        loadFragment(DynamicFragment.newInstance())
    }

    private fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_dynamic, fragment)
        transaction.disallowAddToBackStack()
        transaction.commit()
    }
}