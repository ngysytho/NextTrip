package edu.poly.nexttrip

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MyTrip_CancelledFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var emptyLayout: View
    private lateinit var txtNoTripCompleted: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_trip__completed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txtNoTripCompleted = view.findViewById(R.id.txtNoTripCompleted)
        recyclerView = view.findViewById(R.id.recyclerCompletedTrip)
        emptyLayout = view.findViewById(R.id.completeLayout)

        // Lấy tên người dùng từ SharedPreferences
        val prefs = requireContext().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val userName = prefs.getString("username", "Tho N.") ?: "Tho N."
        txtNoTripCompleted.text =
            "Chào $userName. Quý khách không có đặt chỗ đã hủy gần đây"

        val trips = getCompletedTrips()

        if (trips.isEmpty()) {
            emptyLayout.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
        } else {
            emptyLayout.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE

            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = My_Trip_Upcomming_TripAdapter(trips)
        }
    }

    private fun getCompletedTrips(): List<My_Trip_Upcomming_TripModel> {
        // ⚠️ Tạm thời trả về danh sách trống (test UI)
        return emptyList()

        // Có thể giả lập test:
        /*
        return listOf(
            TripModel("Hà Nội", "01/01/2025", "03/01/2025"),
            TripModel("Đà Nẵng", "15/02/2025", "20/02/2025")
        )
        */
    }
}
