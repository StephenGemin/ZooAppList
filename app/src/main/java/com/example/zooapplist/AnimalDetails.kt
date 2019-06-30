package com.example.zooapplist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animal_details.*

class AnimalDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_details)

        val bundle:Bundle = intent.extras!!
        val name = bundle.getString("name")
        val detail_desc = bundle.getString("detail_desc")
        val image = bundle.getInt("image")
        det_animal_name.text = name
        det_animal_image.setImageResource(image)
        det_animal_extra_description.text = detail_desc


    }
}
