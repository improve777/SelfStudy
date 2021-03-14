package com.improve777.selfstudy.video

import com.improve777.common.recyclerview.DiffModel

data class VideoVo(
    val kind: String,
    val id: String,
    val title: String,
) : DiffModel {
    override val diffId: String
        get() = id
}