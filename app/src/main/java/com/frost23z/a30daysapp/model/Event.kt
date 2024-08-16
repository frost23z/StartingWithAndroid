package com.frost23z.a30daysapp.model

import androidx.annotation.StringRes

data class Event(
    @StringRes val day: Int,
    @StringRes val name: Int,
    @StringRes val description: Int
)