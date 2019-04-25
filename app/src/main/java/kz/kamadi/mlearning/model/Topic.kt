package kz.kamadi.mlearning.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Topic(
    val id: Int,
    val title: String,
    val content: String
) : Parcelable