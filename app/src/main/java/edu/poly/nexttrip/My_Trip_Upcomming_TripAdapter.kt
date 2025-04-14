package edu.poly.nexttrip

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.poly.nexttrip.My_Trip_Upcomming_TripModel

class My_Trip_Upcomming_TripAdapter(private val trips: List<My_Trip_Upcomming_TripModel>) :
    RecyclerView.Adapter<My_Trip_Upcomming_TripAdapter.TripViewHolder>() {

    inner class TripViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtDestination: TextView = itemView.findViewById(R.id.txtDestination)
        val txtDate: TextView = itemView.findViewById(R.id.txtDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.my_trip_upcomming_item_trip, parent, false)
        return TripViewHolder(view)
    }

    override fun onBindViewHolder(holder: TripViewHolder, position: Int) {
        val trip = trips[position]
        holder.txtDestination.text = trip.destination
        holder.txtDate.text = trip.date
    }

    override fun getItemCount(): Int = trips.size
}