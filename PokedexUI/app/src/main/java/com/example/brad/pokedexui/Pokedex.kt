package com.example.brad.pokedexui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Pokedex : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokedex)
        setContentView(R.layout.create_team_page)
    }
}
