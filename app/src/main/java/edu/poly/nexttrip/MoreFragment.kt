package edu.poly.nexttrip

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MoreFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MoreAdapter
    private lateinit var headerContainer: FrameLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_more_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        headerContainer = view.findViewById(R.id.More_headerContainer)
        recyclerView = view.findViewById(R.id.More_recyclerMore)

        setupHeader()
        setupRecycler()
    }

    private fun setupHeader() {
        val prefs = requireContext().getSharedPreferences("user_session", Context.MODE_PRIVATE)
        val isLoggedIn = prefs.getBoolean("isLoggedIn", false)

        val headerView = if (isLoggedIn) {
            layoutInflater.inflate(R.layout.layout_header_logged_in, headerContainer, false)
        } else {
            layoutInflater.inflate(R.layout.layout_header_logged_out, headerContainer, false)
        }

        headerContainer.removeAllViews()
        headerContainer.addView(headerView)

        if (!isLoggedIn) {
            val loginBtn = headerView.findViewById<Button>(R.id.Login_btnLogin)
            loginBtn.setOnClickListener {
                startActivity(Intent(requireContext(), LoginActivity::class.java))
            }
        } else {
            val logoutBtn = headerView.findViewById<TextView>(R.id.HeaderLoggedin_logout)
            logoutBtn.setOnClickListener {
                prefs.edit().clear().apply()
                Toast.makeText(requireContext(), "Đã đăng xuất", Toast.LENGTH_SHORT).show()
                setupHeader() // reload lại header sau khi logout
            }
        }
    }

    private fun setupRecycler() {
        val items = listOf(
            MoreItem(R.drawable.main_more, "Danh sách yêu thích"),
            MoreItem(R.drawable.main_more, "NextTrip"),
            MoreItem(R.drawable.main_more, "Thông tin thẻ đã lưu của tôi"),
            MoreItem(R.drawable.main_more, "Tiền Trip", "0 đ"),
            MoreItem(R.drawable.main_more, "Cashback", "0 đ"),
            MoreItem(R.drawable.main_more, "PointsMAX"),
            MoreItem(R.drawable.main_more, "Khuyến mãi"),
            MoreItem(R.drawable.main_more, "Hộp thư"),
            MoreItem(R.drawable.main_more, "Nhận xét của tôi"),
            MoreItem(R.drawable.main_more, "Ngôn ngữ", "Tiếng Việt 🇻🇳"),
            MoreItem(R.drawable.main_more, "Giá hiển thị", "VND"),
            MoreItem(R.drawable.main_more, "Km hay dặm?", "km"),
            MoreItem(R.drawable.main_more, "Thông báo")
        )

        adapter = MoreAdapter(items) {
            Toast.makeText(requireContext(), "Chọn: ${it.title}", Toast.LENGTH_SHORT).show()
        }

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }
}
