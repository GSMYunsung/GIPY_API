package com.pss.gify_study.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cys.gify_study.R
import com.cys.gify_study.databinding.ActivityMainBinding
import com.cys.gify_study.databinding.FragmentMainBinding
import com.pss.gify_study.base.BaseActivity
import com.pss.gify_study.base.BaseFragment
import com.pss.gify_study.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun init() : Unit = with(binding){

        lifecycleScope.launch {mainViewModel.postLogin() }

        mainViewModel.giphyApiGifList.observe(requireActivity(), Observer {

            mainRecyclerView.adapter = GiphyAdapter(mainViewModel.giphyApiGifList.value!!)
            mainRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            mainRecyclerView.setHasFixedSize(true)

        })

    }
}