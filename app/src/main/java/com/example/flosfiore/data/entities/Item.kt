package com.example.flosfiore.data.entities

// 싯가제품
data class Item(
    var date: String? = "",  // 날짜
    var name: String? = "",  // 이름
    var price: Int = 0,  // 가격
    var img : Int? = null    // 위아래 이미지
)