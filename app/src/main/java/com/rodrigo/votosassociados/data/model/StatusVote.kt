package com.rodrigo.votosassociados.data.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class StatusVote(
    val id: String,
    val status: String
) : Parcelable {

    companion object {
        const val ABLE_TO_VOTE = "ABLE_TO_VOTE"
        const val UNABLE_TO_VOTE = "UNABLE_TO_VOTE"
    }
}