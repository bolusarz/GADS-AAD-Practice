package com.bolusarz.gap.data.remote

import com.bolusarz.gap.data.models.Form
import com.bolusarz.gap.data.models.Learner
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST


interface LearnerService {

    @GET("hours")
    suspend fun getLearningLeaders(): Response<List<Learner>>

    @GET("skilliq")
    suspend fun getSkillLeaders(): Response<List<Learner>>

    @POST("https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    suspend fun submitProject(form: Form): Response<Void>

}