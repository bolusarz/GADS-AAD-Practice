package com.bolusarz.gap

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bolusarz.gap.data.models.Form
import com.bolusarz.gap.ui.main.ConfirmDialog
import com.bolusarz.gap.ui.main.LearnerViewModel
import com.bolusarz.gap.ui.main.ResultDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_google_form.*

@AndroidEntryPoint
class GFormActivity : AppCompatActivity(), View.OnClickListener {

    val viewModel by viewModels<LearnerViewModel>()
    private val dialog: ConfirmDialog = ConfirmDialog()
    private val resultDialog: ResultDialog = ResultDialog()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_form)

        setSupportActionBar(toolbar)

        submitBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val fname = fnameEtv.text.toString()
        val sname = snameEtv.text.toString()
        val email = emailEtv.text.toString()
        val gitLink = linkEtv.text.toString()
        val form = Form(fname, sname, email, gitLink)
        dialog.setListener {
            submitProject(form)
        }
        dialog.show(supportFragmentManager, null)
        resultDialog.onDismiss(object: DialogInterface {
            override fun cancel() {
                finish()
            }

            override fun dismiss() {
               finish()
            }

        })
    }

    private fun submitProject(form: Form) {
        viewModel.submitProject(form).observe(this, {isSuccessful ->
            resultDialog.status = isSuccessful
            if (isSuccessful)
               resultDialog.message = "Submission Successful"
            else
                resultDialog.message = "Submission not Successful"
            resultDialog.show(supportFragmentManager, null)
        })
    }

}