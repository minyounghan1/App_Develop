package com.hankyong.hankyongsample.functional

import com.hankyong.hankyongsample.extensions.empty

//Todo EventBus 는 Object 간 통신 혹은 데이터 전달을 편리하게 해주는 lib.
// 사용이 필요한 경우 문의 주세요...

data class AppFinishEvent(
    val title: String = String.empty(),
    val message: String = String.empty(),
)