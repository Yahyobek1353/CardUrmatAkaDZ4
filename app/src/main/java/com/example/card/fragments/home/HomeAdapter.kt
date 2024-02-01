package com.example.card.fragments.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.card.data.room.model.CardModel
import com.example.card.data.room.model.CategoryModel
import com.example.card.databinding.ItemHomeBinding

class HomeAdapter(
    private val click: HomeFragment
): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private val list = ArrayList<CardModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<CardModel>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }


    inner class HomeViewHolder(private val binding: ItemHomeBinding): RecyclerView.ViewHolder(binding.root) {
        fun onBind(pos: Int) {
            binding.txtName.text = list[pos].name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            ItemHomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.onBind(position)
        holder.itemView.setOnClickListener {
            click.OnClick(position, list[position].list)
        }
    }


    interface Result {
        fun OnClick(pos: Int, list: List<CategoryModel>)
    }
}