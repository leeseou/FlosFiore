package com.example.flosfiore.data.entities

data class GoodsOvernight(
    var select: Int? = null,   // 선택 이미지
    var img: Int? = null,      // 제품 이미지
    var place: String? = "",   // 장소
    var name: String? = "",    // 이름
    var color: String? = "",   // 색깔
    var count: Int = 0,        // 제품 개수
    var price: Int = 0,        // 가격
    var total: Int = 0,        // 총 사는 금액
    var choose: Boolean = true // 제품 선택
)
