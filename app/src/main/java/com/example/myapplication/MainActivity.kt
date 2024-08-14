package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

      /*  val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        supportFragmentManager.commit {
            add(R.id.fragContainer1, firstFragment)
            add(R.id.fragContainer2, secondFragment)

        }*/

    }
}