package com.annaginagili.recyclerviewexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView1: RecyclerView
    lateinit var recyclerView2: RecyclerView
    lateinit var adapter1: ItemAdapter
    lateinit var adapter2: ItemAdapter2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView1 = findViewById(R.id.recyclerView1)
        recyclerView2 = findViewById(R.id.recyclerView2)

        recyclerView1.setHasFixedSize(true)
        recyclerView1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val imageList = mutableListOf(R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background, R.drawable.ic_launcher_background) as ArrayList<Int>

        val textList = mutableListOf("Text1", "Text2", "Text3", "Text4") as ArrayList<String>

        adapter1 = ItemAdapter(this, imageList, textList)
        recyclerView1.adapter = adapter1

        recyclerView2.setHasFixedSize(true)
        recyclerView2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        adapter2 = ItemAdapter2(this, imageList, textList)
        recyclerView2.adapter = adapter2
        adapter2.setOnItemClickListener(object : ItemAdapter2.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                intent.putExtra("image", imageList[position])
                intent.putExtra("text", textList[position])
                startActivity(intent)
            }
        })
    }
}