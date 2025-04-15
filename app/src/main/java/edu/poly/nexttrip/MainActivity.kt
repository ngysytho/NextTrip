package edu.poly.nexttrip

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 🟢 Hiển thị HomeFragment() lúc mới khởi động
        loadFragment(HomeFragment())

        val bottomNav = findViewById<BottomNavigationView>(R.id.main_bottom_navigation1)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.nav_trips -> {
                    loadFragment(MyTrip_Fragment()) // ví dụ Fragment khác
                    true
                }
                R.id.nav_cart -> {
                    loadFragment(Cart_Fragment()) // ví dụ Fragment khác
                    true
                }
                R.id.nav_more -> {
                    loadFragment(MoreFragment()) // ví dụ Fragment khác
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}