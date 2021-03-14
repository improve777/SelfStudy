package com.improve777.selfstudy.video

import android.os.Bundle
import android.view.ViewGroup
import androidx.activity.viewModels
import com.improve777.common.base.BindActivity
import com.improve777.common.recyclerview.BaseListAdapter
import com.improve777.common.recyclerview.BindViewHolder
import com.improve777.common.utils.click
import com.improve777.common.utils.startActivity
import com.improve777.selfstudy.R
import com.improve777.selfstudy.databinding.ActivityVideoListBinding
import com.improve777.selfstudy.databinding.ItemVideoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideoListActivity : BindActivity<ActivityVideoListBinding>(R.layout.activity_video_list) {

    private val viewModel: VideoListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val adapter = object : BaseListAdapter<VideoVo, ItemVideoBinding>() {
            override fun onCreateViewHolder(
                parent: ViewGroup,
                viewType: Int,
            ): BindViewHolder<VideoVo, ItemVideoBinding> {
                return object :
                    BindViewHolder<VideoVo, ItemVideoBinding>(R.layout.item_video, parent) {}.apply { 
                    itemView click {
                        this@VideoListActivity.startActivity<VideoActivity>()
                    }
                }
            }
        }

        binding.rvVideo.adapter = adapter

        viewModel.videos.observe {
            adapter.submitList(it)
        }

        viewModel.getVideoList()
    }
}