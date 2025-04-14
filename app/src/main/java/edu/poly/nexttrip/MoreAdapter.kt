package edu.poly.nexttrip

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MoreAdapter(
    private val items: List<MoreItem>,
    private val onItemClick: (MoreItem) -> Unit
) : RecyclerView.Adapter<MoreAdapter.MoreViewHolder>() {

    inner class MoreViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.findViewById(R.id.iconItem)
        val title: TextView = view.findViewById(R.id.titleItem)
        val subText: TextView = view.findViewById(R.id.subTextItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoreViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.more_item, parent, false)
        return MoreViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoreViewHolder, position: Int) {
        val item = items[position]
        holder.icon.setImageResource(item.iconResId)
        holder.title.text = item.title
        if (item.subText != null && item.subText.isNotEmpty()) {
            holder.subText.visibility = View.VISIBLE
            holder.subText.text = item.subText
        } else {
            holder.subText.visibility = View.GONE
        }

        holder.itemView.setOnClickListener {
            onItemClick(item)
        }
    }

    override fun getItemCount(): Int = items.size
}
