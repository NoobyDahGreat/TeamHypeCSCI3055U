package com.example.brad.pokedexui

import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient
import java.net.URL

class Pokemon : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pokemon)
        val id = this.intent.extras.get("ID").toString().toInt()
        val pokemon = getPokemon(id)

        val nameText = findViewById(R.id.pokemon_name) as TextView
        nameText.text = pokemon.name

        val sprite = findViewById(R.id.pokemon_sprite) as ImageView
        val spriteUrl = URL(pokemon.sprites.frontDefault)
        val bmp = BitmapFactory.decodeStream(spriteUrl.openConnection().inputStream)
        sprite.setImageBitmap(bmp)
        sprite.scaleX


        val descriptionText = findViewById(R.id.pokemon_description) as TextView
        descriptionText.text = pokemon.toString()

    }

    fun getPokemon(id : Int) : me.sargunvohra.lib.pokekotlin.model.Pokemon {
        val pokeApi = PokeApiClient()
        return pokeApi.getPokemon(id)
    }
}

