package com.rodrigo.votosassociados.ui.custom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.rodrigo.votosassociados.R

class DialogLoading: DialogFragment() {
    private var mFragmentManager: FragmentManager? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_dialog_loading, container, false)
        val message: TextView = view.findViewById(R.id.loadingMessage)

        dialog?.setTitle(arguments?.getString(TITLE))
        message.text = arguments?.getString(MESSAGE)

        dialog?.setCanceledOnTouchOutside(false)
        dialog?.setCancelable(false)
        return view
    }

    /**
     * Show Dialog
     *
     * @param fragmentManager The FragmentManager
     */
    fun show(fragmentManager: FragmentManager) {
        this.mFragmentManager = fragmentManager
        show(fragmentManager, DIALOG_TAG)
    }

    fun close() {
        mFragmentManager?.let {
            val dialogFragment: Fragment? = it.findFragmentByTag(DIALOG_TAG)
            if (dialogFragment != null && super.isVisible()) {
                super.dismissAllowingStateLoss()
            }
        }
    }

    companion object {
        private const val DIALOG_TAG = "DialogLoading"
        private const val MESSAGE = "message"
        private const val TITLE = "title"

        /**
         * Initializes the AlertDialog.
         *
         * @param id      The id
         * @param title   The id string of title
         * @param message The id string of message
         * @return The DialogFragment
         */
        fun newDialog(title: String?, message: String?): DialogLoading {
            val bundle = Bundle()
            val dialogFragment = DialogLoading()

            bundle.putString(TITLE, title)
            bundle.putString(MESSAGE, message)
            dialogFragment.arguments = bundle

            return dialogFragment
        }
    }
}