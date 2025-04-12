package edu.poly.nexttrip

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        xulyRecycleview1(view)
    }

    private fun xulyRecycleview1(view: View) {
        val ds_main = mutableListOf<main_outdate>()
        ds_main.add(main_outdate(R.drawable.main_canhanhoa))
        ds_main.add(main_outdate(R.drawable.main_nuocuong))
        ds_main.add(main_outdate(R.drawable.main_nhahang_1))
        ds_main.add(main_outdate(R.drawable.main_batxe))
        ds_main.add(main_outdate(R.drawable.main_doitien))
        ds_main.add(main_outdate(R.drawable.main_diadiemdulich))

        val main_adapter1 = main_RvAdapter(
            ds_main,
            object : main_RvInterface {
                override fun main_OnClickchucnang(pos: Int) {
                    Toast.makeText(requireContext(), "Bạn đã click vào", Toast.LENGTH_SHORT).show()
                }
            },
            function = {}
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.main_recyclerView)
        recyclerView.adapter = main_adapter1
        recyclerView.layoutManager = GridLayoutManager(
            context,
            2,
            GridLayoutManager.HORIZONTAL,
            false
        )
    }
}
