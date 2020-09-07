package com.bolusarz.gap.utils

import android.widget.ImageView
import android.widget.TextView

import androidx.databinding.BindingAdapter
import com.bolusarz.gap.R
import com.bolusarz.gap.data.models.Learner


@BindingAdapter("android:text")
fun setText(view: TextView, learner: Learner) {
    // Some checks removed for clarity
    if(learner.hours != null) {
        view.text = String.format("%d learning hours, %s", learner.hours, learner.country)
    } else {
        view.text = String.format("%d skill IQ Score, %s", learner.score, learner.country)
    }
}

@BindingAdapter("android:src")
fun setImage(view: ImageView, learner: Learner) {
    if (learner.hours != null) {
        view.setImageResource(R.drawable.default_top_learner_badge)
    } else {
        view.setImageResource(R.drawable.default_skill_iq_badge)
    }
}