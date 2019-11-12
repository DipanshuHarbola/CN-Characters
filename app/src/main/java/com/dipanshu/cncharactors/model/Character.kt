package com.dipanshu.cncharactors.model

/**
 * Created by Dipanshu Harbola
 */

// Model class to set/get Character
data class Character (
    var id: Int,
    var name: String,
    var subTitle: String,
    var description: String,
    var image: Int,
    var colorStart: String,
    var colorEnd: String
)