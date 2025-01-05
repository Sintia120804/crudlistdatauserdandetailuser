package com.sintia.crud_berita_user.service


import com.sintia.crud_berita_user.model.LoginResponse
import com.sintia.crud_berita_user.model.MahasiswaResponse
import com.sintia.crud_berita_user.model.RegisterResponse
import com.sintia.crud_berita_user.model.ResponseBerita
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface BeritaService {
    @GET("getBerita.php")
    fun getAllBerita() : Call<ResponseBerita>

    @FormUrlEncoded
    @POST("register.php")
    fun register(
        @Field("username") username : String,
        @Field("fullname") fullname : String,
        @Field("email") email : String,
        @Field("password") password : String
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("login.php")
    fun Login(
        @Field("username") username : String,
        @Field("password") password : String
    ): Call<LoginResponse>

    @GET("listmahasiswa.php")
    fun getAllMahasiswa() : Call<MahasiswaResponse>
}
