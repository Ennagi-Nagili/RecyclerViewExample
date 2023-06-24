package com.annaginagili.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    lateinit var image: ImageView
    lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        image = findViewById(R.id.image)
        text = findViewById(R.id.text)

        image.setImageResource(intent.getIntExtra("image", 0))
        text.text = intent.getStringExtra("text")
    }
}