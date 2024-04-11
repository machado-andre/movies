package com.example.movies

import MyAdapter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    // EXAMPLE OF USE:
    // https://api.themoviedb.org/3/movie/550?api_key=0bca2bda23d1c14dc7b5be1c3fb90bb0

    // ACCESS TOKEN AUTH:
    // eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwYmNhMmJkYTIzZDFjMTRkYzdiNWJlMWMzZmI5MGJiMCIsInN1YiI6IjY2MTdiYTllMWZkMzZmMDE3Y2FkMzQ1NiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.vdRbCZojM21-iMMwKA1CzePmOhMpexxgZtevYULzB_Y

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // Sample data for the RecyclerView
        val dataList = listOf(
            ShowItem("interesting", 8.8, "Insanity"),
            ShowItem("interesting", 9.9, "The Boondocks"),
            ShowItem("interesting", 5.5,"The Walking Dead After 5th season"),
            ShowItem("interesting", 2.3,"No"),
            ShowItem("interesting", 1.0,"Yes")
        )

        // Create and set up the adapter
        val adapter = MyAdapter(dataList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}