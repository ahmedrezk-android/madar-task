package com.rezk.madarsofttask.ui

import android.content.Intent
import com.rezk.madarsofttask.R
import com.rezk.madarsofttask.base.BaseActivity
import com.rezk.madarsofttask.models.UserModel
import com.rezk.madarsofttask.utils.USER_KEY
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity() {

    override fun getLayoutId(): Int = R.layout.activity_register

    override fun initActivity() {

        gender.setSelection(0)

        saveButton.setOnClickListener {
            saveUserData()
        }
    }

    private fun saveUserData() {
        val userName = userName.text?.trim().toString()
        val job = jobTitle.text?.trim().toString()
        val age = age.text?.trim().toString()
        val gender = gender.selectedItem.toString()

        when {
            userName.isEmpty() -> {
                showToast(getString(R.string.msg_validation_usr_name))
                return
            }
            job.isEmpty() -> {
                showToast(getString(R.string.msg_valifation_user_job))
                return
            }
            age.isEmpty() -> {
                showToast(getString(R.string.msg_valifation_user_age))
                return
            }
            else -> {
                val userModel = UserModel(userName, age, job, gender)
                preferencesUtil.saveOrUpdateString(USER_KEY, gson.toJson(userModel))
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }
        }

    }


}