package com.cube.mailcube.viewmodel

import androidx.lifecycle.MutableLiveData
import com.cube.mailcube.base.BaseViewModel
import com.cube.mailcube.ui.recyclerview.item.Applicant

internal class ContentViewModel : BaseViewModel() {
    val applicantList = MutableLiveData<List<Applicant>>()

    init {
        applicantList.postValue(
            listOf(
                Applicant("유진", "wishjinit@gmail.com"),
                Applicant("유진", "wishjinit@gmail.com")
            )
        )
    }
}