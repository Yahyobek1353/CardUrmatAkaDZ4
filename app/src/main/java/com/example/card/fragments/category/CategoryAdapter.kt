package com.example.card.fragments.category

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.card.data.room.model.CardModel
import com.example.card.data.room.model.CategoryModel
import com.example.card.databinding.ItemHomeBinding
import com.example.card.fragments.home.HomeAdapter

@Suppress("UNREACHABLE_CODE")
class CategoryAdapter(
    private val click: Parcel
): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(), Parcelable {

    private val list = ArrayList<CardModel>()


    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<CardModel>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }


    inner class CategoryViewHolder(private val binding: ItemHomeBinding): RecyclerView.ViewHolder(binding.root) {
        fun onBind(pos: Int) {
            binding.txtName.text = list[pos].name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.HomeViewHolder {
        TODO("Not yet implemented")
    }


    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: HomeAdapter.HomeViewHolder, position: Int) {
        holder.onBind(position)
        holder.itemView.setOnClickListener {
            click.OnClick(position, list[position].list)
        }
    }


    interface Result {
        fun OnClick(pos: Int, list: List<CategoryModel>)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CategoryAdapter> {
        override fun createFromParcel(parcel: Parcel): CategoryAdapter {
            return CategoryAdapter(parcel)
        }

        override fun newArray(size: Int): Array<CategoryAdapter?> {
            return arrayOfNulls(size)
        }
    }

}