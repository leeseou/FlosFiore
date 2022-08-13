package com.example.flosfiore.data.entities

//인스타그램 데이터
data class Instagram(
    var img : Int? = null,      // 인스타 사진
    var title : String = "",        //인스타 제목
    var content : String = "",      //인스타 내용
    var like : Int = 0      //좋아요 개수
)
