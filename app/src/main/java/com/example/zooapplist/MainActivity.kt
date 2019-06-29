package com.example.zooapplist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.animal_ticket.view.*

class MainActivity : AppCompatActivity() {

    var listOfAnimals = ArrayList<Animal>()
    var adapter:animalAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //load animals
        listOfAnimals.add(Animal(R.string.baboon, R.string.baboon_desc, R.drawable.baboon))
        listOfAnimals.add(Animal(R.string.bulldog, R.string.bulldog_desc, R.drawable.bulldog))
        listOfAnimals.add(Animal(R.string.panda, R.string.panda_desc, R.drawable.panda))
        listOfAnimals.add(Animal(R.string.swallow, R.string.swallow_desc, R.drawable.swallow_bird))
        listOfAnimals.add(Animal(R.string.white_tiger, R.string.white_tiger_desc, R.drawable.white_tiger))
        listOfAnimals.add(Animal(R.string.zebra, R.string.zebra_desc, R.drawable.zebra))

        adapter = animalAdapter(this, listOfAnimals)
        animalList.adapter = adapter
    }

    class animalAdapter:BaseAdapter{
        var listOfAnimals=ArrayList<Animal>()
        var context:Context?=null
        constructor(listOfAnimals:ArrayList<Animal>):super(){
            this.listOfAnimals = listOfAnimals
            this.context = context
        }
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val animal = listOfAnimals[p0]
            val myView = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) layoutInflator.inflate(R.layout.animal_ticket, null)
            myView.txt_header.text = animal.name
            myView.txt_desc.text = animal.desc
            myView.img.setImageResource(animal.image)
            return myView
        }

        override fun getItem(p0: Int): Any {
            return p0.toLong()
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listOfAnimals.size
        }

    }

}
