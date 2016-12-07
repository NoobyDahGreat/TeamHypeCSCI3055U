package com.example.brad.pokedexui

import android.R.attr.button
import android.R.attr.onClick
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
<<<<<<< HEAD
import kotlinx.android.synthetic.main.activity_pokedex.*
=======
import android.os.StrictMode
import android.widget.Button
import com.example.brad.pokedexui.R.layout.search_page
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.onClick
>>>>>>> d4ce0b7135bea0b81ef859aea826b9efb0d1496b

class Pokedex : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        setContentView(R.layout.activity_pokedex)
<<<<<<< HEAD
        button.setOnClickListener {


                setContentView(R.layout.activity_pokedex)

        }
    }




}
=======

        val search = findViewById(R.id.searchButton) as Button
        val favButton = findViewById(R.id.favoritesButton) as Button
        val createButoon = findViewById(R.id.createButton) as Button



        search.onClick { startActivity(intentFor<Search>()) }
        favButton.onClick { startActivity(intentFor<Favorites>())}
        createButoon.onClick { startActivity(intentFor<CreateTeam>()) }
    }

}
>>>>>>> d4ce0b7135bea0b81ef859aea826b9efb0d1496b
