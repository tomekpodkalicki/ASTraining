package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapters.ContactAdapter
import com.example.myapplication.data.Contact
import com.example.myapplication.databinding.ActivitySecondBinding
import com.example.myapplication.viewmodels.SecondViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    private val vm by viewModels<SecondViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.recycler1.layoutManager = LinearLayoutManager(applicationContext)

        CoroutineScope(Dispatchers.Main).launch {
           vm.contactFlow.collect { contact ->
               binding.recycler1.adapter = ContactAdapter(
                   contactsList = listOf(contact),
                   callListener = {
                       Toast.makeText(applicationContext, "Call to number to ${it}", Toast.LENGTH_SHORT).show()
                   },
                   smsListener = {
                       Toast.makeText(applicationContext, "Send sms to ${it}", Toast.LENGTH_SHORT).show()
                   })

           }
        }
/*
        vm.contacts.observe(this) { contactList ->
            binding.recycler1.adapter = ContactAdapter(
                contactsList = contactList,
                callListener = {
                    Toast.makeText(applicationContext, "Call to number to ${it}", Toast.LENGTH_SHORT).show()
                },
                smsListener = {
                    Toast.makeText(applicationContext, "Send sms to ${it}", Toast.LENGTH_SHORT).show()
                })
        }*/
        vm.updateContactList()
    }
}