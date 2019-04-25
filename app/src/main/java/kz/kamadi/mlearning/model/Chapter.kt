package kz.kamadi.mlearning.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Chapter(
    val id: Int,
    val title: String,
    val questions: List<Question>
) : Parcelable