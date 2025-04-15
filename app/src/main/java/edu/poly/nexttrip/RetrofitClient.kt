package edu.poly.nexttrip

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val instance: AuthApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.56.1:8080/")
            // ⚠️ Đổi thành IP API thật của bạn (localhost:8080 → 10.0.2.2 nếu chạy emulator)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthApi::class.java)
    }
}
