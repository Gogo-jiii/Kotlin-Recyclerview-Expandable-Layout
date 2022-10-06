package com.example.recyclerviewexpandablelayout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_item.view.*

class MyAdapter(context: MainActivity, arrayList: ArrayList<ModelClass>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private val context: Context
    private val arrayList: ArrayList<ModelClass>

    init {
        this.context = context
        this.arrayList = arrayList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.row_item, parent,
            false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val modelClass = arrayList[position]
        holder.itemView.textView.text = modelClass.name
        if (modelClass.isShouldShowImageview) {
            holder.itemView.imageView.visibility = View.VISIBLE
        } else {
            holder.itemView.imageView.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView
        private val rowItem: ConstraintLayout
        private val imageView: ImageView
        private val imageViewArrow: ImageView

        init {
            textView = itemView.findViewById(R.id.textView)
            rowItem = itemView.findViewById(R.id.rowitem)
            imageView = itemView.findViewById(R.id.imageView)
            imageViewArrow = itemView.findViewById(R.id.imageViewArrow)
            rowItem.setOnClickListener {
                Toast.makeText(
                    context, arrayList[adapterPosition].toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
            imageViewArrow.setOnClickListener {
                arrayList[adapterPosition].isShouldShowImageview =
                    !arrayList[adapterPosition].isShouldShowImageview
                notifyItemChanged(adapterPosition)
            }
        }
    }
}