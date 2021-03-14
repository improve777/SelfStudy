package com.improve777.selfstudy.home

import android.os.Bundle
import android.view.View
import com.improve777.common.base.BindFragment
import com.improve777.common.utils.click
import com.improve777.common.utils.startActivity
import com.improve777.selfstudy.R
import com.improve777.selfstudy.databinding.FragmentHomeBinding
import com.improve777.selfstudy.video.VideoListActivity

class HomeFragment : BindFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnVideo click {
                activity?.startActivity<VideoListActivity>()
            }
        }
    }
}