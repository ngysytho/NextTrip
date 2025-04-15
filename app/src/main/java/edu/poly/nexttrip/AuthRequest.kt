package edu.poly.nexttrip

data class AuthRequest(
    val name: String,
    val user: String,
    val phone: String,
    val email: String,
    val password: String
)