package com.dipanshu.cncharactors.view

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import com.dipanshu.cncharactors.R
import com.dipanshu.cncharactors.model.DataGenerator.CHARACTER
import kotlinx.android.synthetic.main.activity_character_detail.*

/**
 * Created by Dipanshu Harbola
 */

// CharacterDetailActivity to shoe the details of a character
class CharacterDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)

        // get the charId to fetch the single character from the Character list.
        val cID = intent.getIntExtra("CHAR_ID", -1)

        // getting the character from the character list. It will return Character or null in case id not matched
        val character = CHARACTER.firstOrNull { it.id == cID }

        // here we are setting dynamic gradient background of container.
        val colors = intArrayOf(Color.parseColor(character?.colorStart), Color.parseColor(character?.colorEnd))
        val gradDrawable = GradientDrawable(GradientDrawable.Orientation.BL_TR, colors)
        gradDrawable.shape = GradientDrawable.RECTANGLE
        gradDrawable.cornerRadii = floatArrayOf(100f,100f,0f,0f,0f,0f,0f,0f) // making the top-left corner curvy.
        container.setBackgroundDrawable(gradDrawable)

        character?.image?.let { charImage.setImageResource(it) }
        charName.text = character?.name
        charSubTitle.text = character?.subTitle
        charDesc.text = character?.description

        // fade-in animation on the description text.
        val fadeIn = AlphaAnimation(0.0f , 1.0f )
        fadeIn.duration = 1000L
        charDesc.startAnimation(fadeIn)

        closeView.setOnClickListener {
            onBackPressed()
        }

        // clip adapter to show dummy clips.
        clipRecyclerView.adapter = ClipsAdapter()
    }
}
