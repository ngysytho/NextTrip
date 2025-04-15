package edu.poly.nexttrip

data class AuthRequest(
    val name: String,
    val phone: String,
    val email: String,
    val password: String
)