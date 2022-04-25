package com.pss.gify_study.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.pss.gify_study.data.remote.api.GifPagingSource
import com.pss.gify_study.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

    private val pagingRepository: MainRepository

) : ViewModel() {

        val flow = Pager(
            PagingConfig(pageSize = 20)
        ){
            GifPagingSource(gifRepository = pagingRepository)
        }.flow
                //데이터 스트림을 공유 가능하게 하며 제공된 CoroutineScope 을 사용하여 로드된 데이터를 캐시합니다.
            .cachedIn(viewModelScope)


}