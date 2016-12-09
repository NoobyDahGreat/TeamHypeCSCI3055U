package com.example.brad.pokedexui

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient
import java.net.URL
import org.jetbrains.anko.db.*
import org.jetbrains.anko.onClick

class Pokemon : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pokemon)
        val id = this.intent.extras.get("ID").toString().toInt()
        val pokemon = getPokemon(id)
        val db = FavDatabaseOpenHelper.getInstance(this.applicationContext).writableDatabase

        val nameText = findViewById(R.id.pokemon_name) as TextView
        nameText.text = pokemon.name

        val sprite = findViewById(R.id.pokemon_sprite) as ImageView
        val spriteUrl = URL(pokemon.sprites.frontDefault)
        val bmp = BitmapFactory.decodeStream(spriteUrl.openConnection().inputStream)
        sprite.setImageBitmap(bmp)
        sprite.scaleX


        val descriptionText = findViewById(R.id.pokemon_description) as TextView
        descriptionText.text = pokemon.toString()

        val favButton = findViewById(R.id.fav_button) as Button
        favButton.onClick { db.insert("Pokemon", "name" to pokemon.name ,"id" to pokemon.id) }

    }

    fun getPokemon(id : Int) : me.sargunvohra.lib.pokekotlin.model.Pokemon {
        val pokeApi = PokeApiClient()
        return pokeApi.getPokemon(id)
    }
}



class FavDatabaseOpenHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx,
        FavDatabaseOpenHelper.DB_NAME, null, FavDatabaseOpenHelper.DB_Version) {
    companion object {
        val DB_NAME = "favorites.db"
        val DB_Version = 1
        private var instance: FavDatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): FavDatabaseOpenHelper {
            if (instance == null) {
                instance = FavDatabaseOpenHelper(ctx.getApplicationContext())
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable("Pokemon", true,
                "id" to INTEGER + PRIMARY_KEY,
                "name" to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
        db.dropTable("Pokemon", true)
        onCreate(db)
    }
}
