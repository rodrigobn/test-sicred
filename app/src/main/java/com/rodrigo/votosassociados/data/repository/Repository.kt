package com.rodrigo.votosassociados.data.repository

import com.rodrigo.votosassociados.data.repository.local.pref.PreferencesHelper
import com.rodrigo.votosassociados.data.repository.network.BaseApi

interface Repository : PreferencesHelper, BaseApi {

}