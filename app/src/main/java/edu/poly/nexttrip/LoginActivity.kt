package edu.poly.nexttrip

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import retrofit2.HttpException

class LoginActivity : AppCompatActivity() {

    private lateinit var edtUser: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtUser = findViewById(R.id.Login_edtEmail)
        edtPassword = findViewById(R.id.Login_edtPassword)
        btnLogin = findViewById(R.id.Login_btnLogin)

        prefs = getSharedPreferences("user_session", MODE_PRIVATE)

        btnLogin.setOnClickListener {
            val user = edtUser.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            if (user.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            LoginUser(user, password)
        }
    }

    private fun LoginUser(user: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitClient.instance.LoginUser(LoginRequest(user, password))
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful && response.body()?.success == true) {
                        // ✅ Lưu trạng thái đăng nhập
                        prefs.edit().apply {
                            putBoolean("isLoggedIn", true)
                            putString("userName", response.body()?.name)
                            apply()
                        }
                        Toast.makeText(this@LoginActivity, "Đăng nhập thành công", Toast.LENGTH_SHORT).show()
                        finish() // quay lại màn hình trước
                    } else {
                        Toast.makeText(this@LoginActivity, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: HttpException) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@LoginActivity, "Lỗi server", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@LoginActivity, "Lỗi: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
