package com.example.demo20

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class WordListAdapter(private val rowLayoutObj: Int, private val wordList: ArrayList<Item>) : RecyclerView.Adapter<WordListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(rowLayoutObj, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item.text = wordList[position].name
    }
    override fun getItemCount(): Int = wordList.size
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val item: TextView = itemView.findViewById(R.id.row_textView)
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(view: View?) {
            Log.d("onclick", "onClick $layoutPosition ${item.text}")
            Toast.makeText(itemView.context, "Clicked: ${item.text}", Toast.LENGTH_SHORT).show()
        }
    }
}
