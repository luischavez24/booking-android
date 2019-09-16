package org.guis.booking.data

import kotlinx.coroutines.Deferred
import org.guis.booking.data.response.Person
import retrofit2.http.GET
import retrofit2.http.Path


interface SwapiService {

    @GET("people/{id}/")
    fun findPerson(@Path("id") id: Int) : Deferred<Person>

}