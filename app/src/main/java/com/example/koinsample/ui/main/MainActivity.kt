package com.example.koinsample.ui.main

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.koinsample.R
import com.example.koinsample.base.ui.BaseActivity
import com.example.koinsample.data.local.entity.UserEntity
import com.example.koinsample.ui.main.adapter.UserAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : BaseActivity(), MainContract.View {

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    private val mMainPresenter: MainContract.Presenter by inject { parametersOf(this) }

    private val mUserAdapter = UserAdapter()

    override val layoutResource: Int
        get() = R.layout.activity_main

    override fun initComponent(savedInstanceState: Bundle?) {
        btMainSave.setOnClickListener {
            val users = makeUser()
            mMainPresenter.onSaveUser(users)
        }

        btMainGet.setOnClickListener {
            mMainPresenter.onGetUser()
        }

        rvUser?.apply {
            adapter = mUserAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        }
    }

    override fun displayError(message: String?) {
        Log.d(TAG, "displayError(): $message")
    }

    override fun displayUser(users: List<UserEntity>) {
        Log.d(TAG, "displayUser(): $users")
        mUserAdapter.updateAll(users)
    }

    private fun makeUser(): List<UserEntity> {
        val users = arrayListOf<UserEntity>()
        for (i in 1 until 50) {
            users.add(UserEntity(i, "Thaihn$i", "Thaihn$i@gmail.com"))
        }
        return users
    }
}
