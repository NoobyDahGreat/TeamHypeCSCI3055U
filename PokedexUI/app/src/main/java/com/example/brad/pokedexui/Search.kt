package com.example.brad.pokedexui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SearchView
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient
import me.sargunvohra.lib.pokekotlin.model.NamedApiResourceList
import org.jetbrains.anko.*
import java.util.concurrent.Future

class Search : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_page)
        val pokeApi = PokeApiClient()
        val list = pokeApi.getPokemonList(0,721)

        val searchbox = findViewById(R.id.searchView) as SearchView
        val serchResult = findViewById(R.id.SearchResults) as ListView



        searchbox.queryHint = "search for pokemon"


    }
}
