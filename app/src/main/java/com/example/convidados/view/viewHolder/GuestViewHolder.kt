package com.example.convidados.view.viewHolder

import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.convidados.databinding.RowGuestBinding
import com.example.convidados.model.GuestModel
import com.example.convidados.view.listener.OnGuestListener

class GuestViewHolder(private val bind: RowGuestBinding, private val listener: OnGuestListener) :
    RecyclerView.ViewHolder(bind.root) {

    fun bind(guestItem: GuestModel) {
        bind.textName.text = guestItem.name

        bind.textName.setOnClickListener() {
            listener.onClick(guestItem.id)
        }

        bind.textName.setOnLongClickListener {
            AlertDialog.Builder(itemView.context)
                .setTitle("Remoção de convidado")
                .setMessage("Tem certeza que desaja remover?")
                .setPositiveButton("Sim") { dialog, which ->
                    listener.onDelete(guestItem.id)
                }
                .setNegativeButton("Não", null)
                .create()
                .show()
            true
        }

    }

}