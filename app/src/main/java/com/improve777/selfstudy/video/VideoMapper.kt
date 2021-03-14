package com.improve777.selfstudy.video

import com.improve777.selfstudy.remote.VideoItemResponse

fun VideoItemResponse.toVo(): VideoVo {
    val kind = (id?.kind ?: "").split("#").lastOrNull()
    val isVideo = kind == "video"

    return VideoVo(
        kind = id?.kind ?: "",
        id = if (isVideo) id?.videoId ?: "" else id?.channelId ?: "",
        title = snippet?.title ?: ""
    )
}