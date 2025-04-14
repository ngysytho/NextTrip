package edu.poly.nexttrip

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MyTrip_Fragment : Fragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_trip, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tabLayout = view.findViewById(R.id.tabLayout_booking)
        viewPager = view.findViewById(R.id.viewPager_booking)

        // Gán adapter cho ViewPager2
        val adapter = MyTripPagerAdapter(this)
        viewPager.adapter = adapter

        // Kết nối TabLayout với ViewPager2
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Sắp tới"
                1 -> "Hoàn tất"
                2 -> "Đã huỷ"
                else -> ""
            }
        }.attach()
    }
}