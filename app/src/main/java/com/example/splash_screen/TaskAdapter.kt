package com.example.splash_screen

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class  TaskAdapter(val context: Context): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>(){
    private  var allTask  = ArrayList<TaskResult?>()
    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val desc: TextView = itemView.findViewById(R.id.textView16)
        val dept: TextView = itemView.findViewById(R.id.textView11)
        val query: TextView = itemView.findViewById(R.id.textView14)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val viewHolder = TaskViewHolder(LayoutInflater.from(context).inflate(R.layout.task,parent,false))
        return  viewHolder
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val txt = allTask[allTask.size-1- position]!!.department
        holder.dept.text = txt
        holder.desc.text = allTask[allTask.size -1 - position]!!.description
        holder.query.setOnClickListener{
            val intent = Intent(context,QueryActivity::class.java)
            intent.putExtra("task_id",allTask[allTask.size -1 - position]!!._id)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return allTask.size
    }

    fun updateList(newList: List<TaskResult?>){
        allTask.clear()
        allTask.addAll(newList)

        notifyDataSetChanged()
    }
}