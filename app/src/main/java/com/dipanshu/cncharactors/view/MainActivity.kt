package com.dipanshu.cncharactors.view

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.dipanshu.cncharactors.R
import android.util.Pair as UtilPair // giving another name to prevent from name conflict.
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Dipanshu Harbola
 */

class MainActivity : AppCompatActivity(), Listener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val charAdapter = CharacterAdapter()
        charRecyclerView.adapter = charAdapter
        charAdapter.listener = this

        fbShare.setOnClickListener {
            showToast("Find us on Facebook")
        }

        twShare.setOnClickListener {
            showToast("Find us on Twitter")
        }
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onItemClick(
        charId: Int,
        charImage: View,
        charName: View,
        charSubTitle: View
    ) {
        // here are the elements which have to translate to other view.
        val options = ActivityOptions.makeSceneTransitionAnimation(this,
            UtilPair.create(charImage, "charImg"), // used to translate more then one element
            UtilPair.create(charName, "charName"), // used to translate more then one element
            UtilPair.create(charSubTitle, "charSubT")) // used to translate more then one element

        val intent = Intent(this, CharacterDetailActivity::class.java)
        intent.putExtra("CHAR_ID", charId)
        startActivity(intent, options.toBundle())
    }


}
