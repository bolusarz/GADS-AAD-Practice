package com.bolusarz.gap.data.remote

import javax.inject.Inject

class LearnerRemoteDataSource @Inject constructor(val service: LearnerService): BaseDataSource() {

    suspend fun getTopLearners() = getResult { service.getLearningLeaders() }

    suspend fun getSkillLeaders() = getResult { service.getSkillLeaders() }

}