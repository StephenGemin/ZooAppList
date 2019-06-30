package com.example.zooapplist

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_animal_details.view.*
import kotlinx.android.synthetic.main.animal_ticket.view.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    var listOfAnimals = ArrayList<Animal>()
    var adapter:animalAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //get styled detailed descriptions
//        var temp_baboon:String = getString(R.string.baboon_detail_desc)
//        var styled_temp_baboon:Spanned = Html.fromHtml(temp_baboon, from_html_mode_legace)

        //load animals
        listOfAnimals.add(Animal(
            getString(R.string.baboon), getString(R.string.baboon_desc), getString(R.string.baboon_detail_desc), R.drawable.baboon, false))
        listOfAnimals.add(Animal(
            getString(R.string.panda), getString(R.string.panda_desc), getString(R.string.panda_detail_desc), R.drawable.panda, false))
        listOfAnimals.add(Animal(
            getString(R.string.bulldog), getString(R.string.bulldog_desc), getString(R.string.bulldog_detail_desc), R.drawable.panda, false))
        listOfAnimals.add(Animal(
            getString(R.string.swallow), getString(R.string.swallow_desc), getString(R.string.baboon_detail_desc), R.drawable.swallow_bird, false))
        listOfAnimals.add(Animal(
            getString(R.string.white_tiger), getString(R.string.white_tiger_desc), getString(R.string.baboon_detail_desc), R.drawable.white_tiger, true))
        listOfAnimals.add(Animal(
            getString(R.string.zebra), getString(R.string.zebra_desc), getString(R.string.baboon_detail_desc), R.drawable.zebra, false))
        listOfAnimals.add(Animal(
            getString(R.string.cat), getString(R.string.cat_desc), getString(R.string.baboon_detail_desc), R.drawable.cat, true))
        listOfAnimals.add(Animal(
            getString(R.string.fox), getString(R.string.fox_desc), getString(R.string.baboon_detail_desc), R.drawable.fox, true))

        adapter = animalAdapter(this, listOfAnimals)
        animalList.adapter = adapter
    }

    class animalAdapter:BaseAdapter{
        var listOfAnimals=ArrayList<Animal>()
        var context:Context?=null
        constructor(context:Context, listOfAnimals:ArrayList<Animal>):super(){
            this.listOfAnimals = listOfAnimals
            this.context = context
        }
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val animal = listOfAnimals[p0]
            if (animal.iskiller!!) {
                var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflater.inflate(R.layout.animal_iskiller_ticket, null)
                myView.txt_header.text = animal.name!!
                myView.txt_desc.text = animal.desc!!
                myView.img.setImageResource(animal.image!!)
                myView.img.setOnClickListener{
                    val intent = Intent(context, AnimalDetails::class.java)
                    intent.putExtra("name", animal.name)
                    intent.putExtra("detail_desc", animal.detail_desc)
                    intent.putExtra("image", animal.image!!)
                    context!!.startActivity(intent)
                }
                return myView
            } else {
                var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflater.inflate(R.layout.animal_ticket, null)
                myView.txt_header.text = animal.name!!.toString()
                myView.txt_desc.text = animal.desc!!.toString()
                myView.img.setImageResource(animal.image!!)
                myView.img.setOnClickListener{
                    val intent = Intent(context, AnimalDetails::class.java)
                    intent.putExtra("name", animal.name)
                    intent.putExtra("detail_desc", animal.detail_desc)
                    intent.putExtra("image", animal.image!!)
                    context!!.startActivity(intent)
                }
                return myView
            }
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
