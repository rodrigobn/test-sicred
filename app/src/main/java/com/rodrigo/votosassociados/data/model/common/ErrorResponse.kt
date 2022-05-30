package com.rodrigo.votosassociados.data.model.common

import androidx.annotation.Keep

@Keep
class ErrorResponse(
    val code: Int,
    val message: String?,
    val description: String?
)