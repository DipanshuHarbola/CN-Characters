package com.dipanshu.cncharactors.view

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.RecyclerView
import com.dipanshu.cncharactors.R
import com.dipanshu.cncharactors.model.Character
import com.dipanshu.cncharactors.model.DataGenerator.CHARACTER
import kotlin.random.Random

/**
 * Created by Dipanshu Harbola
 */

// CharacterAdapter to communicate between character data and related view(UI).
class CharacterAdapter : RecyclerView.Adapter<CharacterViewHolder>() {

    // listener for click callback
    var listener: Listener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder =
        CharacterViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_character,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = CHARACTER.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bindTo(CHARACTER[position], listener)
    }
}

// interface to provide click callback
interface Listener {
    fun onItemClick(charId: Int, charImage: View, charName: View, charSubTitle: View)
}

// CharacterViewHolder to perform view(ui)related functions
class CharacterViewHolder(parent: View) : RecyclerView.ViewHolder(parent) {

    val baseView: LinearLayoutCompat = itemView.findViewById(R.id.baseView)
    val charImage: AppCompatImageView = itemView.findViewById(R.id.charImage)
    val charName: AppCompatTextView = itemView.findViewById(R.id.charName)
    val charSubTitle: AppCompatTextView = itemView.findViewById(R.id.charSubTitle)

    // binding data with the related view.
    fun bindTo(character: Character, listener: Listener?) {

        // dynamically set the gradient color to the view.
        val colors = intArrayOf(Color.parseColor(character.colorStart), Color.parseColor(character.colorEnd))  // start and end color array
        val gradDrawable = GradientDrawable(GradientDrawable.Orientation.BL_TR, colors) // set gradient colors and angle
        gradDrawable.shape = GradientDrawable.RECTANGLE // gradient shape
        gradDrawable.cornerRadius = 12f  // gradient corner radius
        baseView.setBackgroundDrawable(gradDrawable)

        charImage.setImageResource(character.image)
        charName.text = character.name
        charSubTitle.text = character.subTitle

        baseView.setOnClickListener {
            listener?.onItemClick(
                character.id,
                charImage,
                charName,
                charSubTitle
            )
        }
        charImage.setOnClickListener {
            listener?.onItemClick(
                character.id,
                charImage,
                charName,
                charSubTitle
            )
        }
        setAnimation(charImage, layoutPosition)
    }

    // this function is used to scale the character image when appear first time.
    private fun setAnimation(charImage: AppCompatImageView, position: Int) {
        var lastPosition = -1
        if (position > lastPosition) {
            val anim = ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            anim.duration = Random.nextInt(501).toLong()//to make duration random number between [0,501)
            charImage.startAnimation(anim)
            lastPosition = position
        }
    }
}