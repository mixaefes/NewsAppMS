package com.example.newsapptask.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    @DrawableRes val imageSourceId : Int,
    @StringRes val nameSourceId : Int)
