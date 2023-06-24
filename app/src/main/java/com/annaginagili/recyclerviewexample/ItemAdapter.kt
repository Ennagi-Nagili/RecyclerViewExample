package com.annaginagili.recyclerviewexample

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val context: Context, private val imageList: ArrayList<Int>,
                     private val textList: ArrayList<String>):
    RecyclerView.Adapter<ItemAdapter.ItemHolder>() {

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.image)
        private val textView: TextView = itemView.findViewById(R.id.text)

        fun setData(image: Int, text: String, context: Context) {
            imageView.setImageResource(image)
            textView.text = text

            itemView.setOnClickListener {
                val intent = Intent(context, SecondActivity::class.java)
                intent.putExtra("image", image)
                intent.putExtra("text", text)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ItemHolder(view)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.setData(imageList[position], textList[position], context)
    }
}