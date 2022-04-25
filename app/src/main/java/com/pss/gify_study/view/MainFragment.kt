package com.pss.gify_study.view

import android.os.Bundle
import android.util.Log
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
import com.pss.gify_study.widget.utils.DataComparator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val mainViewModel by activityViewModels<MainViewModel>()

    private val giphyAdapter by lazy { GiphyAdapter(DataComparator) }

    override fun init() : Unit = with(binding){

        mainRecyclerView.adapter = giphyAdapter
        mainRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        mainRecyclerView.setHasFixedSize(true)

        lifecycleScope.launch {
            mainViewModel.flow.collectLatest { pagingData ->
                // 데이터 값을 Paging 할당 Data 로 변환후 Adapter 에 할당시키기
                giphyAdapter.submitData(pagingData)
            }
        }

    }
}