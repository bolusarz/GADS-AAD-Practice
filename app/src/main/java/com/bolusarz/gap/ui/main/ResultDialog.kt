package com.bolusarz.gap.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bolusarz.gap.R
import kotlinx.android.synthetic.main.dialog_result.*

class ResultDialog(): DialogFragment() {

    var status: Boolean = true
    var message: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        messageTv.text = message
        if (status)
            statusIv.setImageResource(R.drawable.ic_baseline_check_circle_24)
        else
            statusIv.setImageResource(R.drawable.ic_baseline_warning_24)
    }
}