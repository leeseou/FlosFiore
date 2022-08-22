package com.example.flosfiore.data.entities

data class Comment(
    var img: Int?,
    var content: String?,
    var writer: String = "",
    var time : Long?,
    var comments: ArrayList<Comment>?
)
