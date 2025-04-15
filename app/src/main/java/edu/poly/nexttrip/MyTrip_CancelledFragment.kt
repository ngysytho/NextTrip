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
        // Sửa tên layout cho đúng nếu cần
        return inflater.inflate(R.layout.fragment_my_trip__cancelled, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txtNoTripCompleted = view.findViewById(R.id.MyTrip_Cancelled_txtNoTripCompleted)
        recyclerView = view.findViewById(R.id.MyTrip_Cancelled_recyclerCompletedTrip)
        emptyLayout = view.findViewById(R.id.MyTrip_Cancelled_completeLayout)

        // 🔥 Đổi đúng key "user_session" thay vì "user_prefs"
        val prefs = requireContext().getSharedPreferences("user_session", Context.MODE_PRIVATE)
        val userName = prefs.getString("userName", "Tho N.") ?: "Tho N."

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
        return emptyList()
    }
}
