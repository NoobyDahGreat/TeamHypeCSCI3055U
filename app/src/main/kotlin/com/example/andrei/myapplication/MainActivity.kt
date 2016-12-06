package com.example.andrei.myapplication

import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient
import android.os.StrictMode
import android.widget.EditText
import android.widget.ImageView
import java.net.URL


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        setContentView(R.layout.activity_main)
        val pokeApi = PokeApiClient()
        val pokemon = pokeApi.getPokemon(25)
        val pokelist = pokeApi.getPokemonList(0,151)

        val textView = findViewById(R.id.textView3) as TextView
        val editText = findViewById(R.id.editText) as EditText
        val imageView = findViewById(R.id.imageView) as ImageView

        editText.text.clear()
        editText.text.insert(0, pokemon.name)
        textView.text = pokelist.toString()
        val url = URL(pokemon.sprites.frontDefault) as URL
        imageView.setImageBitmap(BitmapFactory.decodeStream(url.openConnection().inputStream))
    }
}
