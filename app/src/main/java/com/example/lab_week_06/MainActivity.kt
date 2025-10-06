package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), object : CatAdapter.OnClickListener {
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        //Instantiate ItemTouchHelper for the swipe to delete callback and
        //attach it to the recycler view
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Fred",
                    "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Wilma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Curious George",
                    "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.Anggora,
                    "Garfield",
                    "Cutie Pie",
                    "https://cdn2.thecatapi.com/images/8sj.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.Karawacinese,
                    "Cleo",
                    "Brand Ambassador of SMK",
                    "https://cdn2.thecatapi.com/images/3fc.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.BSDSerpongese,
                    "Michael Kevin",
                    "Prince of Serpong",
                    "https://cdn2.thecatapi.com/images/2js.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.Bengaluru,
                    "Muthu Lapathu",
                    "King Slayer from Bengaluru",
                    "https://cdn2.thecatapi.com/images/2fd.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.Garongese,
                    "Tom Meong",
                    "Best Friend of Jerry",
                    "https://cdn2.thecatapi.com/images/3lm.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.Oyenese,
                    "Orange oren",
                    "Immortal Cat",
                    "https://cdn2.thecatapi.com/images/7gj.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.Belangese,
                    "Miao Miao Meong",
                    "Cat Reborn",
                    "https://cdn2.thecatapi.com/images/8jj.jpg"
                )

            )
        )
    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}
