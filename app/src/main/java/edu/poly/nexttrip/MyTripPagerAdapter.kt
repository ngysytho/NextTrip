package edu.poly.nexttrip

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import edu.poly.nexttrip.mytrip.MyTrip_CancelledFragment

class MyTripPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3  // Số lượng tab

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MyTrip_UpcomingFragment()    // Tab 1 - Sắp tới
            1 -> MyTrip_CompletedFragment()   // Tab 2 - Hoàn tất
            2 -> MyTrip_CancelledFragment()   // Tab 3 - Đã huỷ
            else -> Fragment()
        }
    }
}
