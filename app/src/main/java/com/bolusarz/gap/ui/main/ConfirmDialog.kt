package com.bolusarz.gap.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bolusarz.gap.R
import kotlinx.android.synthetic.main.dialog_confirm.*

class ConfirmDialog: DialogFragment() {

    private var listener: (() -> Unit)? = null

    fun setListener(listener: (() -> Unit)) {
        this.listener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_confirm, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        closeBtn.setOnClickListener {
            dismiss()
        }
        confirmBtn.setOnClickListener {
            listener?.invoke()
            dismiss()
        }
    }

}