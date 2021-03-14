package com.improve777.selfstudy

import android.os.Bundle
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import com.improve777.common.base.BindActivity
import com.improve777.common.utils.DoubleTabFinishHandler
import com.improve777.common.utils.naivagionBarMode
import com.improve777.common.utils.toast
import com.improve777.selfstudy.databinding.ActivityMainBinding
import com.improve777.selfstudy.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BindActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val finishHandler = DoubleTabFinishHandler(lifecycleScope) {
        if (naivagionBarMode().isEdgeToEdgeEnabled()) {
            toast("한 번 더 슬라이드 해주세요")
        } else {
            toast("한 번 더 눌러주세요")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add(R.id.container, HomeFragment())
            }
        }
    }

    override fun onBackPressed() {
        finishHandler.onBackPressed {
            super.onBackPressed()
        }
    }
}