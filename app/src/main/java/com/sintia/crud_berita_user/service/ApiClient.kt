package com.sintia.crud_berita_user.service

import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Arrays

object ApiClient {
    //http://10.208.104.237:8080/beritaDb/getBerita.php

    private const val BASE_URL = "http://192.168.18.22/beritadb/"

    private val client = OkHttpClient.Builder()
        .connectionSpecs(Arrays.asList(ConnectionSpec.CLEARTEXT, ConnectionSpec.MODERN_TLS))
        .addInterceptor{ chain ->
            val request = chain.request().newBuilder()
                .addHeader("Content-type", "application/jason")
                .build()
            chain.proceed(request)
        }
        .build()

    val retrofit : BeritaService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(interceptor())
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BeritaService::class.java)
    }

    fun interceptor() : OkHttpClient{
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

//    val beritaServices : BeritaService by lazy {
//        retrofit.create(BeritaService::class.java)
//    }

}