package com.bolusarz.gap.data.models

data class Learner(val name: String,
                   val country: String,
                   val badgeUrl: String,
                   val hours: Int? = null,
                   val score: Int? = null )