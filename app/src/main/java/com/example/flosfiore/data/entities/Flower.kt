package com.example.flosfiore.data.entities

// 상품 정보
data class Flower(
    var img : Int? = null,      // 상품 사진
    var name : String = "",     // 상품 이름
    var price : Int = 0,        // 상품 가격
    var store : String = "",        // 판매 가게 이름
    var sale : Int = 0      // 할인율
)
