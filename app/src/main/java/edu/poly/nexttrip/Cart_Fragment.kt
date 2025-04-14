package edu.poly.nexttrip

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Cart_Fragment : Fragment() {

    // Mock danh sách giỏ hàng
    private val cartItems = mutableListOf<String>() // đổi thành model của bạn nếu có

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cart_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val emptyLayout = view.findViewById<LinearLayout>(R.id.emptyLayout)
        val itemLayout = view.findViewById<LinearLayout>(R.id.itemLayout)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerCart)
        val headerText = view.findViewById<TextView>(R.id.cartHeader)
        val searchBtn = view.findViewById<Button>(R.id.btnSearchTravel)

        searchBtn.setOnClickListener {
            Toast.makeText(requireContext(), "Tìm kiếm du lịch được nhấn", Toast.LENGTH_SHORT).show()
        }

        // Cập nhật UI tùy theo dữ liệu giỏ hàng
        if (cartItems.isEmpty()) {
            emptyLayout.visibility = View.VISIBLE
            itemLayout.visibility = View.GONE
            headerText.text = "Xe đẩy hàng (0 mục)"
        } else {
            emptyLayout.visibility = View.GONE
            itemLayout.visibility = View.VISIBLE
            headerText.text = "Xe đẩy hàng (${cartItems.size} mục)"

            // Setup RecyclerView
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = CartAdapter(cartItems)
        }
    }

    // Adapter mẫu, bạn có thể thay bằng custom adapter riêng của bạn
    class CartAdapter(private val items: List<String>) :
        RecyclerView.Adapter<CartAdapter.ViewHolder>() {

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val textView: TextView = view.findViewById(android.R.id.text1)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(android.R.layout.simple_list_item_1, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.textView.text = items[position]
        }

        override fun getItemCount(): Int = items.size
    }
}
