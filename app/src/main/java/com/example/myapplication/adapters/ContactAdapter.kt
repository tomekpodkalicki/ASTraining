package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.Contact
import com.example.myapplication.databinding.ListRowBinding

class ContactAdapter(private val contactsList: List<Contact>,
                     private val callListener: (String) -> Unit,
                     private val smsListener: (String) -> Unit
                     ):

    RecyclerView.Adapter<ContactAdapter.ContactsViewHolder>() {

    inner class ContactsViewHolder(binding: ListRowBinding):
        RecyclerView.ViewHolder(binding.root){

        val contactName = binding.contactName
        val contactNumber = binding.contactNumber

        init {
            binding.callImage.setOnClickListener {
                callListener(contactsList[adapterPosition].phoneNumber)
            }
        }
        init {
            binding.smsImage.setOnClickListener {
                smsListener(contactsList[adapterPosition].phoneNumber)
            }
        }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListRowBinding.inflate(inflater, parent,false)
        return ContactsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        val fullName = "${contactsList[position].name} ${contactsList[position].surname}"
        holder.contactName.text = fullName
        holder.contactNumber.text = contactsList[position].phoneNumber
    }


}