package com.bolusarz.gap.data.models

import retrofit2.http.Field

data class Form (
    @Field("entry.1877115667") val firstName: String,
    @Field("entry.2006916086") val lastName: String,
    @Field("entry.1824927963") val emailAddress: String,
    @Field("entry.284483984") val githubLink: String
)