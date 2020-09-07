package com.bolusarz.gap.ui.main

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bolusarz.gap.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*

/**
 * A placeholder fragment containing a simple view.
 */
@AndroidEntryPoint
class LearnerPlaceholderFragment : Fragment() {

    val viewModel by viewModels<LearnerViewModel>()
    private var type = TOP_LEARNER

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().apply {
            type = getString(ARG_SECTION_TYPE).toString()
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        root.recycler_view.adapter = LearnerAdapter()
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (type == TOP_LEARNER) {
            viewModel.getTopLearners().observe(viewLifecycleOwner, {
                hideProgressBar()
                (recycler_view.adapter as LearnerAdapter).setItems(it)
            })
        } else {
            viewModel.getTopSkillIQ().observe(viewLifecycleOwner, {
                hideProgressBar()
                (recycler_view.adapter as LearnerAdapter).setItems(it)
            })
        }
    }

    private fun hideProgressBar() {
        ObjectAnimator.ofFloat(progressBar, "alpha", 0.0F).apply {
            duration = 1000
            start()
        }
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_TYPE = "com.bolusarz.gap.fragment_type"
        const val TOP_LEARNER = "com.bolusarz.gap.top_learners"
        const val TOP_SKILL_IQ = "com.bolusarz.gap.top_skill_iq"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionType: String): LearnerPlaceholderFragment {
            return LearnerPlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_SECTION_TYPE, sectionType)
                }
            }
        }
    }
}