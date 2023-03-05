package com.example.businessbuddyv2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private val itemTitles = arrayOf(
            //Demo Text:
            "I learn code online", "The greatest solutions ever", "I learned alot", "what code to use",
            "The greatest of them all", "We help alot", "The greatest solution", "helps alot",
            "I read alot", "the best", "amazing"
    )


    private val itemDetails = arrayOf(
            "The greatest tool of all time", "written by us", "The universal help of all time"
    )

    private val itemImages = intArrayOf(
            R.drawable.lwic,
            R.drawable.logo,
            R.drawable.lcarrier,
            R.drawable.lconstellation,
            R.drawable.lfidelity,
            R.drawable.lbrite,
            R.drawable.lwaygate,
            R.drawable.llutron
            //R.drawable.nyccc - what file?
    )


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var image : ImageView
        var textTitle : TextView
        var textDes : TextView


        init{
            image = itemView.findViewById(R.id.item_image)
            textTitle = itemView.findViewById(R.id.item_title)
            textDes = itemView.findViewById(R.id.item_details)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycleview_model,parent, false)
        return ViewHolder(v)


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textTitle.text = itemTitles [position]
        holder.textDes.text = itemDetails [position]
        holder.image.setImageResource(itemImages[position])

        holder.itemView.setOnClickListener { v: View ->
            Toast.makeText(v.context, "Clicked on the item", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return itemTitles.size
    }

}