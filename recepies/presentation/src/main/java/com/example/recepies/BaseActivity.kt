package com.example.recepies

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseActivity : AppCompatActivity() {

    protected abstract fun getLayoutResourceId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResourceId())
    }

    protected abstract fun getProgressBar(): ProgressBar?

    fun toggleProgress(toggle: Boolean) {
        getProgressBar()?.visibility = if (toggle) View.VISIBLE else View.GONE
    }

    protected fun replaceFragment(resId: Int, fragment: Fragment) {
        this.supportFragmentManager.beginTransaction()
            .replace(resId, fragment)
            .addToBackStack(fragment.tag)
            .commit()
    }

}