package edu.poly.nexttrip

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import java.util.concurrent.Executor

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
       XulyRecyleview1()


    }

    private fun XulyRecyleview1() {
        val ds_main = mutableListOf<main_outdate>()
        ds_main.add(main_outdate(R.drawable.main_canhanhoa))
        ds_main.add(main_outdate(R.drawable.main_nuocuong))
        ds_main.add(main_outdate(R.drawable.main_nhahang_1))
        ds_main.add(main_outdate(R.drawable.main_batxe))
        ds_main.add(main_outdate(R.drawable.main_doitien))
        ds_main.add(main_outdate(R.drawable.main_diadiemdulich))


        val main_adapter1 = main_RvAdapter(
            ds_main, object : main_RvInterface {
                override fun main_OnClickchucnang(pos: Int) {
                    Toast.makeText(this@MainActivity, "ban da click vao", Toast.LENGTH_SHORT).show()
                }
            },
            function = {}
        )

        val main_Recyleview = findViewById<RecyclerView>(R.id.main_recyclerView)
        main_Recyleview.adapter =main_adapter1
        main_Recyleview.layoutManager = GridLayoutManager(
            this,
            2,
            GridLayoutManager.HORIZONTAL,
            false
        )
    }
}