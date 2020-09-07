package com.bolusarz.gap.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bolusarz.gap.data.models.Form
import com.bolusarz.gap.data.models.Learner
import com.bolusarz.gap.data.models.Resource
import com.bolusarz.gap.data.repositories.LearnerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class LearnerViewModel @ViewModelInject
    constructor(val repo: LearnerRepository) : ViewModel() {

    init {
        Timber.tag("LearnerViewModel")
    }

    fun getTopLearners(): LiveData<List<Learner>> {
        val result = MutableLiveData<List<Learner>>()
        viewModelScope.launch(Dispatchers.IO) {
            val response = repo.getTopLearners()
            when(response.status) {
                Resource.Status.SUCCESS -> {
                   response.data.let {
                       Timber.i("%d learners received", it?.size ?: 0)
                       result.postValue(it ?: listOf())
                   }
                }
                else -> {
                    Timber.e(response.message)
                    result.postValue(listOf())
                }
            }
        }
        return result
    }

    fun getTopSkillIQ(): LiveData<List<Learner>> {
        val result = MutableLiveData<List<Learner>>()
        viewModelScope.launch(Dispatchers.IO) {
            val response = repo.getTopSkillIQ()
            when(response.status) {
                Resource.Status.SUCCESS -> {
                    response.data.let {
                        Timber.i("%d learners received", it?.size ?: 0)
                        result.postValue(it ?: listOf())
                    }
                }
                else -> {
                    Timber.e(response.message)
                    result.postValue(listOf())
                }
            }
        }
        return result
    }

    fun submitProject(form: Form): LiveData<Boolean> {
        val result = MutableLiveData<Boolean>()
        viewModelScope.launch(Dispatchers.IO) {
            val response = repo.submitProject(form)
            if (response.status == Resource.Status.ERROR)
                Timber.e(response.message)
            result.postValue(response.status == Resource.Status.SUCCESS)
        }
        return result
    }

}