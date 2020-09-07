package com.bolusarz.gap.data.remote

import com.bolusarz.gap.data.models.Form
import javax.inject.Inject

class LearnerRemoteDataSource @Inject constructor(val service: LearnerService): BaseDataSource() {

    suspend fun getTopLearners() = getResult { service.getLearningLeaders() }

    suspend fun getSkillLeaders() = getResult { service.getSkillLeaders() }

    suspend fun submitProject(form: Form) = getResult { service.submitProject(form) }

}