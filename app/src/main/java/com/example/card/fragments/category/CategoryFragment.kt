package com.example.card.fragments.category

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.card.App
import com.example.card.R
import com.example.card.data.room.model.CategoryModel
import com.example.card.databinding.FragmentCategoryBinding


class CategoryFragment : Fragment() {


    private lateinit var binding: FragmentCategoryBinding

    private lateinit var adapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initOnBoard()
        initAdapter()
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.addCategoryFragment)
        }
    }

    private fun initAdapter() {
        adapter = CategoryAdapter(this)
        adapter.setList(App.database.getDao().getAllCard())
        binding.rvMain.adapter = adapter
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        adapter = CategoryAdapter(this)
        adapter.setList(App.database.getDao().getAllCard())
        binding.rvMain.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        adapter = CategoryAdapter(this)
        adapter.setList(App.database.getDao().getAllCard())
        binding.rvMain.adapter = adapter
    }

    fun initOnBoard() {
        if (!App.prefs.isShow()) {
            App.prefs.changeShow(true)
            findNavController().navigate(R.id.onBoardFragment)
        }
    }

    fun OnClick(pos: Int, list: List<CategoryModel>) {
        val bundle  = Bundle()
        val cat = ArrayList(list)
        bundle.putSerializable("pos", cat)
        findNavController().navigate(R.id.categoryFragment, bundle)
    }

}