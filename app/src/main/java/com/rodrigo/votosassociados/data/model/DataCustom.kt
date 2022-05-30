package com.rodrigo.votosassociados.data.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class DataCustom(
    val dadosOpcao: String? = null,
    val campo1: String? = null,
    val campo2: String? = null
) : Parcelable