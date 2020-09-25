package com.rezk.madarsofttask.ui

import com.rezk.madarsofttask.R
import com.rezk.madarsofttask.base.BaseActivity
import com.rezk.madarsofttask.models.UserModel
import com.rezk.madarsofttask.utils.USER_KEY
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    override fun getLayoutId(): Int = R.layout.activity_home

    override fun initActivity() {

        preferencesUtil.getString(USER_KEY)?.let {
            gson.fromJson(it, UserModel::class.java)?.let {
                setUserData(it)
            }
        }

    }

    private fun setUserData(userModel: UserModel) {
        userName.text = userModel.name
        jobTitle.text = userModel.job
        age.text = userModel.age
        gender.text = userModel.gender
    }


}