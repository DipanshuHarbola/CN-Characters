package com.dipanshu.cncharactors.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dipanshu.cncharactors.R

/**
 * Created by Dipanshu Harbola
 */

// ClipsAdapter is for show the character related clips. currently I am showing constant or dummy data with repetitive image and fixed list size.
class ClipsAdapter : RecyclerView.Adapter<ClipsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClipsViewHolder =
        ClipsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_clip,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = 6

    override fun onBindViewHolder(holder: ClipsViewHolder, position: Int) {

    }
}

class ClipsViewHolder(parent: View) : RecyclerView.ViewHolder(parent) {

}