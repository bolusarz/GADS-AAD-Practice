package com.bolusarz.gap.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bolusarz.gap.data.models.Learner
import com.bolusarz.gap.databinding.RecyclerLearnerItemBinding
import timber.log.Timber

class LearnerAdapter : RecyclerView.Adapter<LearnerAdapter.ViewHolder>() {

    private val learners = arrayListOf<Learner>()

    init {
        Timber.tag("LearnerAdapter")
    }

    class ViewHolder(private val binding: RecyclerLearnerItemBinding):
            RecyclerView.ViewHolder(binding.root) {

        fun bind(learner: Learner) {
            binding.learner = learner
            Timber.d("Binded %s item successfully", learner.name)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = RecyclerLearnerItemBinding.inflate(inflater, parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val learner = learners[position]
        holder.bind(learner)
    }

    override fun getItemCount(): Int = learners.size

    fun setItems(items: List<Learner>) {
        learners.clear()
        learners.addAll(items)
        notifyDataSetChanged()
    }

}