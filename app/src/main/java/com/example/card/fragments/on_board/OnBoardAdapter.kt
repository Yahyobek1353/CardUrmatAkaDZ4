package com.example.card.fragments.on_board

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.card.R
import com.example.card.databinding.ItemOnBoardBinding

class OnBoardAdapter: RecyclerView.Adapter<OnBoardAdapter.BoardViewHolder>() {

    private val img = listOf(
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background
    )

    private val title = listOf(
        "Title 1",
        "Title 2",
        "Title 3",
    )

    private val desc = listOf(
        "Description 1",
        "Description 2",
        "Description 3",
    )


    inner class BoardViewHolder(private val binding: ItemOnBoardBinding):
        RecyclerView.ViewHolder(binding.root) {
            fun onBind(pos: Int) {
                binding.imgOnBoard.setImageResource(img[pos])
                binding.txtDesc.text = desc[pos]
                binding.txtTitle.text = title[pos]
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        return BoardViewHolder(
            ItemOnBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = img.size

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.onBind(position)
    }

}