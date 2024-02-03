package com.example.card.fragments.category


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.card.data.room.model.CategoryModel
import com.example.card.databinding.ItemCotegoryBinding


class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private val list = ArrayList<CategoryModel>()

    fun setList(list : List<CategoryModel>){
        this.list.addAll(list)
        notifyDataSetChanged()
    }
    inner class CategoryViewHolder(private var binding: ItemCotegoryBinding) : RecyclerView.ViewHolder(binding.root){

        fun OnBind(position: Int){
            binding.txtName.text = list[position].name.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            ItemCotegoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.OnBind(position)
    }

}

