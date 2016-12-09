package com.example.brad.pokedexui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.ListView

import org.jetbrains.anko.*
import org.jetbrains.anko.db.rowParser
import org.jetbrains.anko.db.select

class Favorites : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.favorites_page)
        val pokeAdapter = FavAdapter(this)

        val favView = findViewById(R.id.fav_view) as ListView
        favView.adapter = pokeAdapter
        favView.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                startActivity(intentFor<Pokemon>("ID" to pokeAdapter.getItem(p2).id))
                //throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }


    }

}

class FavAdapter(val activity : AppCompatActivity) : BaseAdapter() {
    val list : List<PokemonRef> = FavDatabaseOpenHelper.getInstance(activity.applicationContext).
            readableDatabase.select("Pokemon").parseList(rowParser { name : String, id: Int->  PokemonRef(name, id)})
    override fun getView(i : Int, v : View?, parent : ViewGroup?) : View {
        val item = getItem(i)
        return with(parent!!.context) {
            relativeLayout {
                textView(Character.toUpperCase(item.name[0])+item.name.substring(1)) {
                    textSize = 32f
                }
            }
        }
    }

    override fun getItem(position : Int) : PokemonRef {
        return list.get(position)
    }

    override fun getCount() : Int {
        return list.size
    }

    override fun getItemId(position : Int) : Long {
        return getItem(position).id.toLong()
    }

}