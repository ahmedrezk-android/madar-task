package com.rezk.madarsofttask.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.rezk.madarsofttask.utils.PreferencesUtil

abstract class BaseActivity : AppCompatActivity() {

    protected val gson by lazy { Gson() }
    protected val preferencesUtil: PreferencesUtil by lazy { PreferencesUtil(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initActivity()
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected abstract fun initActivity()

    protected fun showToast(msg : String){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}

