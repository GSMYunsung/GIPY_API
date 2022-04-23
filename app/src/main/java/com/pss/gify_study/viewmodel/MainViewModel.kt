package com.pss.gify_study.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pss.gify_study.data.remote.model.Data
import com.pss.gify_study.data.remote.model.GiphyRequest
import com.pss.gify_study.data.remote.model.GiphyResponse
import com.pss.gify_study.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val mainRepository: MainRepository
) : ViewModel() {

    var giphyApiGifList = MutableLiveData<List<Data>>()


    suspend fun postLogin() = viewModelScope.launch {  mainRepository.getGiphyApi().let { it->
        //Log.d("this Log",it.body().toString())

        giphyApiGifList.value = it.body()!!.data

    } }

}