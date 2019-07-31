package com.example.koinsample.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.koinsample.R
import com.example.koinsample.base.common.DataBoundAdapter
import com.example.koinsample.data.local.entity.UserEntity
import kotlinx.android.synthetic.main.rv_item_user.view.*

class UserAdapter : DataBoundAdapter<UserEntity>() {

    override fun inflateView(parent: ViewGroup): View {
        return LayoutInflater.from(parent.context).inflate(R.layout.rv_item_user, parent, false)
    }

    override fun bind(rootView: View, item: UserEntity) {
        rootView.tvName.text = item.name
        rootView.tvEmail.text = item.email
    }

    fun updateAll(data: List<UserEntity>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }
}
