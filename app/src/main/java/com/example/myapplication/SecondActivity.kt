package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapters.ContactAdapter
import com.example.myapplication.data.Contact
import com.example.myapplication.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
val c1 = Contact("Adas", "Kerdol", "123456789")
val c2 = Contact("Joanna", "BonkA", "15634454")
val c3 = Contact("Tomek", "Kerdol", "12212129")
val c4 = Contact("Ryszard", "Rolnikl", "997996997")
        val contactList = listOf(c1, c2, c3, c4,c1, c2, c3, c4,c1, c2, c3, c4,c1, c2, c3, c4)

        binding.recycler1.layoutManager = LinearLayoutManager(applicationContext)
        binding.recycler1.adapter = ContactAdapter(
            contactsList = contactList,
            callListener = {
                Toast.makeText(applicationContext, "Call to number to ${it}", Toast.LENGTH_SHORT).show()
            },
            smsListener = {
                Toast.makeText(applicationContext, "Send sms to ${it}", Toast.LENGTH_SHORT).show()
            })
    }
}