package com.bolusarz.gap.data.remote

import com.bolusarz.gap.data.models.Learner
import retrofit2.Response
import retrofit2.http.GET


interface LearnerService {

    @GET("hours")
    suspend fun getLearningLeaders(): Response<List<Learner>>

    @GET("skilliq")
    suspend fun getSkillLeaders(): Response<List<Learner>>

}