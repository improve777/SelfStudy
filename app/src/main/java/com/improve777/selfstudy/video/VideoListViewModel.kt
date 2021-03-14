package com.improve777.selfstudy.video

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.improve777.common.base.BaseViewModel
import com.improve777.selfstudy.BuildConfig
import com.improve777.selfstudy.remote.YoutubeApi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@HiltViewModel
class VideoListViewModel @Inject constructor(
    private val youtubeApi: YoutubeApi,
) : BaseViewModel() {

    private val _videos = MutableLiveData<List<VideoVo>>()
    val videos: LiveData<List<VideoVo>> = _videos

    fun getVideoList() {
        viewModelScope.launch {
            flow {
                emit(
                    youtubeApi.getVideoList(
                        key = BuildConfig.YOUTUBE_KEY,
                        part = "snippet",
                        q = "십오야",
                    )
                )
            }.flowOn(Dispatchers.Default)
                .map { response ->
                    response.items?.map { it.toVo() } ?: emptyList()
                }
                .flowOn(Dispatchers.Main)
                .collect {
                    _videos.value = it
                }
        }
    }
}