package com.mobishop.api
import com.mobishop.api.APIClient.getApiClient


object APIUntil {
    private const val baseURL =
        "https://mobishops.herokuapp.com/" // https://mobishops.herokuapp.com/ http://vtnshop.herokuapp.com/

    val server: APIServiceInterface
        get() = getApiClient(baseURL)?.create(APIServiceInterface::class.java)!!

}