package com.pss.gify_study.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.cys.gify_study.R
import com.cys.gify_study.databinding.FragmentFavoritBinding
import com.cys.gify_study.databinding.FragmentMainBinding
import com.pss.gify_study.base.BaseFragment
import com.pss.gify_study.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FragmentFavoritBinding>(R.layout.fragment_favorit) {
    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun init() {

    }
}