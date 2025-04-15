package edu.poly.nexttrip


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView

class main_RvAdapter(
    var main_ds: List<main_outdate>,
    var main_Onclickchucnang: main_RvInterface,
    function: () -> Unit
):RecyclerView.Adapter<main_RvAdapter.Chucnang>() {
    //class viewhoder
    inner class Chucnang(itemView:View) :RecyclerView.ViewHolder(itemView)
    //ctrl i
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Chucnang {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_recycleview, parent, false)
        return Chucnang(view)
    }

    @SuppressLint("WrongViewCast")
    override fun onBindViewHolder(
        holder: Chucnang,
        position: Int
    ) {
        holder.itemView.apply {
            val imgChucnang = findViewById<ImageButton>(R.id.imgChucnang)
            imgChucnang.setImageResource(main_ds[position].main_image)

            //lang nghe item click chon
            holder.itemView.setOnClickListener {
                main_Onclickchucnang.main_OnClickchucnang(position)
            }


        }
    }

    override fun getItemCount(): Int {
        return main_ds.size
    }

}