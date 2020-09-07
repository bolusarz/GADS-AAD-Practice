package com.bolusarz.gap.data.repositories

import com.bolusarz.gap.data.models.Form
import com.bolusarz.gap.data.remote.LearnerRemoteDataSource
import javax.inject.Inject

class LearnerRepository @Inject constructor(val dataSource: LearnerRemoteDataSource) {

    suspend fun getTopLearners() = dataSource.getTopLearners()

    suspend fun getTopSkillIQ() = dataSource.getSkillLeaders()

    suspend fun submitProject(form: Form) = dataSource.submitProject(form)

}