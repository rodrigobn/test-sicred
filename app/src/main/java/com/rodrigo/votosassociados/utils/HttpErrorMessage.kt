package com.rodrigo.votosassociados.utils

import com.rodrigo.votosassociados.R

fun handlerHttpError(code: Int?): Int {
    return when (code) {
        -1 -> R.string.message_error_conn
        400 -> R.string.message_error_400
        401 -> R.string.message_error_401
        else -> R.string.message_error_500
    }
}