package com.example.recepies.ui.home

import android.widget.ProgressBar
import com.example.recepies.BaseActivity
import com.example.recepies.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity(){

    override fun onStart() {
        super.onStart()
        replaceFragment(R.id.vFragmentContainer, HomeFragment())
    }

    override fun getLayoutResourceId(): Int = R.layout.activity_home

    override fun getProgressBar(): ProgressBar? = vProgressBar
}