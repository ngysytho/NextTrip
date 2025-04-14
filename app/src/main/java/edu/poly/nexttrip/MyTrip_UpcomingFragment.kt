package edu.poly.nexttrip

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MyTrip_UpcomingFragment : Fragment() {

    private lateinit var emptyLayout: LinearLayout
    private lateinit var tripRecyclerView: RecyclerView
    private lateinit var txtNoTrip: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_trip__upcoming, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ánh xạ các view
        emptyLayout = view.findViewById(R.id.emptyLayout)
        tripRecyclerView = view.findViewById(R.id.recyclerTrip)
        txtNoTrip = view.findViewById(R.id.txtNoTrip)

        // 🧠 Lấy tên người dùng (ở đây hardcode, bạn có thể lấy từ SharedPreferences)
        val userName = "Tho N"
        txtNoTrip.text = "Xin chào $userName.. Quý khách không có chuyến đi sắp tới nào"

        // 🔄 Lấy danh sách chuyến đi sắp tới
        val listTrips = getUpcomingTrips()

        if (listTrips.isEmpty()) {
            // ❌ Không có chuyến: hiện thông báo + các nút gợi ý
            emptyLayout.visibility = View.VISIBLE
            tripRecyclerView.visibility = View.GONE
        } else {
            // ✅ Có chuyến đi: hiện danh sách
            emptyLayout.visibility = View.GONE
            tripRecyclerView.visibility = View.VISIBLE

            tripRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            tripRecyclerView.adapter = My_Trip_Upcomming_TripAdapter(listTrips)
        }
    }

    // 👉 Tạm thời trả về list trống để test UI
    private fun getUpcomingTrips(): List<My_Trip_Upcomming_TripModel> {
        return emptyList() // thử thay bằng danh sách giả lập nếu cần test phần có dữ liệu
    }
}
