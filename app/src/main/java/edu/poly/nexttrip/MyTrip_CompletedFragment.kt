package edu.poly.nexttrip

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class MyTrip_CompletedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout for this fragment
        return inflater.inflate(R.layout.fragment_cart_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Handle button click
        val searchButton = view.findViewById<Button>(R.id.btnSearchTravel)
        searchButton.setOnClickListener {
            Toast.makeText(requireContext(), "Tìm kiếm du lịch được nhấn", Toast.LENGTH_SHORT).show()
            // TODO: Chuyển sang màn hình tìm kiếm du lịch tại đây
        }
    }
}
