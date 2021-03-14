package com.improve777.selfstudy.remote


import com.google.gson.annotations.SerializedName

data class VideoListResponse(
    @SerializedName("kind")
    val kind: String?, // youtube#searchListResponse
    @SerializedName("etag")
    val etag: String?, // ZWQwSgaxIdpBC0ed3QF191Nme4k
    @SerializedName("nextPageToken")
    val nextPageToken: String?, // CAUQAA
    @SerializedName("regionCode")
    val regionCode: String?, // KR
    @SerializedName("pageInfo")
    val pageInfo: PageInfoResponse?,
    @SerializedName("items")
    val items: List<VideoItemResponse>?
)

data class PageInfoResponse(
    @SerializedName("totalResults")
    val totalResults: Int?, // 39643
    @SerializedName("resultsPerPage")
    val resultsPerPage: Int? // 5
)

data class VideoItemResponse(
    @SerializedName("kind")
    val kind: String?, // youtube#searchResult
    @SerializedName("etag")
    val etag: String?, // GfcLdW3RJKPf1lxyNCHFskD7PWo
    @SerializedName("id")
    val id: VideoIdResponse?,
    @SerializedName("snippet")
    val snippet: VideoSnippetResponse?
)

data class VideoIdResponse(
    @SerializedName("kind")
    val kind: String?, // youtube#channel
    @SerializedName("channelId")
    val channelId: String?, // UCQ2O-iftmnlfrBuNsUUTofQ
    @SerializedName("videoId")
    val videoId: String? // 5I1D_YKYV1A
)

data class VideoSnippetResponse(
    @SerializedName("publishedAt")
    val publishedAt: String?, // 2019-05-15T19:43:51Z
    @SerializedName("channelId")
    val channelId: String?, // UCQ2O-iftmnlfrBuNsUUTofQ
    @SerializedName("title")
    val title: String?, // 채널 십오야
    @SerializedName("description")
    val description: String?, // 채널 나나나가 채널 십오야로 이름을 바꿨습니다. 앞으로 다양한 창작자들의 '달나라'가는 꿈같은 콘텐츠들이 업로드 될 예정입니다. 꽉찬 보름달 같은 많은 사랑 부탁 ...
    @SerializedName("thumbnails")
    val thumbnails: ThumbnailListResponse?,
    @SerializedName("channelTitle")
    val channelTitle: String?, // 채널 십오야
    @SerializedName("liveBroadcastContent")
    val liveBroadcastContent: String?, // upcoming
    @SerializedName("publishTime")
    val publishTime: String? // 2019-05-15T19:43:51Z
)

data class ThumbnailListResponse(
    @SerializedName("default")
    val default: ThumbnailResponse?,
    @SerializedName("medium")
    val medium: ThumbnailResponse?,
    @SerializedName("high")
    val high: ThumbnailResponse?
)

data class ThumbnailResponse(
    @SerializedName("url")
    val url: String?, // https://yt3.ggpht.com/ytc/AAUvwnjF4scT2AbGUAVFk6spXbnPU1OhSD8yPjDkkkxMwQ=s88-c-k-c0xffffffff-no-rj-mo
    @SerializedName("width")
    val width: Int?, // 120
    @SerializedName("height")
    val height: Int? // 90
)