package com.example.myapplication.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.Contact
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow

class SecondViewModel: ViewModel() {

    private val _contacts = MutableLiveData<List<Contact>>()
    val contacts: LiveData<List<Contact>> = _contacts
    val contactFlow = flow{

        for (i in 0..1_000){
            val c3 = Contact("$i", "$i", "$i")
            kotlinx.coroutines.delay(1000)
            emit(c3)

        }
    }.filter { it.name.toInt() % 2==0 }

    /*fun getContactList(): List<Contact> {
        val c1 = Contact("Adas", "Kerdol", "123456789")
        val c2 = Contact("Joanna", "BonkA", "15634454")
        val c3 = Contact("Tomek", "Kerdol", "12212129")
        val c4 = Contact("Ryszard", "Rolnikl", "997996997")
        return listOf(c1, c2, c3, c4,c1, c2, c3, c4,c1, c2, c3, c4,c1, c2, c3, c4)
    }*/

    fun updateContactList() {
        val c3 = Contact("Tomek", "Podkalicki", "570232955")
        _contacts.value = listOf(c3)
    }

}