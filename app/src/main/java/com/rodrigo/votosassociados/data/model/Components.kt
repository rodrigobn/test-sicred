package com.rodrigo.votosassociados.data.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class Components(
    val id: String? = null,
    val tipo: String? = null,
    val titulo: String? = null,
    val texto: String? = null,
    val valor: String? = null,
    val url: String? = null,
    val body: DataCustom? = null
) : Parcelable