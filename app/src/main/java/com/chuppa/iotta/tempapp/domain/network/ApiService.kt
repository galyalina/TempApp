package com.chuppa.iotta.tempapp.domain.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import com.chuppa.iotta.tempapp.domain.network.model.Result
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit


interface ApiService {

    @GET("search/users")
    fun search(@Query("q") query: String,
               @Query("page") page: Int,
               @Query("per_page") perPage: Int): Observable<Result>

    /**
     * Factory class for convenient creation of the Api Service interface
     */
    companion object Factory {
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.github.com/")
                    .build()

            return retrofit.create(ApiService::class.java)
        }
    }

}