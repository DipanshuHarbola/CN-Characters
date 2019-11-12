package com.dipanshu.cncharactors.model

import com.dipanshu.cncharactors.R

/**
 * Created by Dipanshu Harbola
 */

// It's a data object which provides a list of characters to perform further operations based on a set of dummy data.
object DataGenerator {

    val CHARACTER = listOf(
        Character(1, "Dexter", "Dexter's Laboratory",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            R.drawable.dexter, "#FFAB00", "#FFE082"),

        Character(2, "Blossom", "Powerpuff Girls",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            R.drawable.blossom, "#FF8F00", "#E57373"),

        Character(3, "Gumball", "Amazing world of Gumball",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            R.drawable.gumball, "#0288D1", "#4DD0E1"),

        Character(4, "Grim", "Adventures of Billy & Mandy",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            R.drawable.grim, "#EF5350", "#E57373"),

        Character(5, "Mr. Bean", "Mr. Bean animated",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            R.drawable.mr_bean, "#5D4C3E", "#9C826D")

    )

}