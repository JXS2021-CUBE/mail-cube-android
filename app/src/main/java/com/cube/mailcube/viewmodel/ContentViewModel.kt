package com.cube.mailcube.viewmodel

import androidx.lifecycle.MutableLiveData
import com.cube.mailcube.base.BaseViewModel
import com.cube.mailcube.ui.recyclerview.item.Applicant

internal class ContentViewModel : BaseViewModel() {
    val applicantList = MutableLiveData<List<Applicant>>()
    val templateTitle = MutableLiveData<String>("제목")
    val templateContent = MutableLiveData<String>("내용")

    init {
        applicantList.postValue(
            listOf(
                Applicant("유진", "wishjinit@gmail.com"),
                Applicant("유진", "wishjinit@gmail.com")
            )
        )
    }
}