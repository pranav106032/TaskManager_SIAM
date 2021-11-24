package com.example.splash_screen

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class  CommentsAdapter(val context: Context): RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>(){
    private  var allTask  = ArrayList<CommentResult?>()
    inner class CommentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.textView5)
        val comment: TextView = itemView.findViewById(R.id.textView6)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val viewHolder = CommentsViewHolder(LayoutInflater.from(context).inflate(R.layout.comments,parent,false))
        return  viewHolder
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        holder.name.text = allTask[position]!!.name
        holder.comment.text = allTask[position]!!.text
    }

    override fun getItemCount(): Int {
        return allTask.size
    }

    fun updateList(newList: List<CommentResult?>){
        allTask.clear()
        allTask.addAll(newList)

        notifyDataSetChanged()
    }
}