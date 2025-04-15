package edu.poly.nexttrip

import retrofit2.Response
import retrofit2.Call // ✅ THÊM DÒNG NÀY
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("/register")
    suspend fun register(@Body request: AuthRequest): Response<Unit>

    @POST("/login")
    suspend fun LoginUser(@Body request: LoginRequest): Response<LoginResponse>
}
