package com.cube.mailcube.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.cube.mailcube.api.model.Excel
import com.cube.mailcube.api.model.Template
import com.cube.mailcube.base.BaseViewModel
import com.cube.mailcube.repository.ContentRepository
import com.cube.mailcube.ui.recyclerview.item.Applicant
import com.cube.mailcube.util.LiveEvent
import kotlinx.coroutines.launch

internal class ContentViewModel(
    private val repository: ContentRepository
) : BaseViewModel() {
    val excelName = MutableLiveData<String>("엑셀파일 선택")
    val excelList = MutableLiveData<List<Excel>>()
    val applicantList = MutableLiveData<List<Applicant>>()
    val templateList = MutableLiveData<List<Template>>()
    val template = MutableLiveData<Template>()
    val templateName = MutableLiveData<String>("템플릿 선택")
    val isShowExcelDropdown = LiveEvent<Boolean>()
    val isShowTemplateDropdown = LiveEvent<Boolean>()

    fun loadExcelList() {
        excelList.value = listOf()
        isShowExcelDropdown.value = true
        viewModelScope.launch {
            val res = repository.getExcelList()
            if (res.isSuccessful) {
                excelList.postValue(res.body())
            }
        }
    }

    fun loadApplicantList(id: Int, name: String) {
        excelName.value = name
        applicantList.value = listOf()
        hideExcelDropdown()
        viewModelScope.launch {
            val res = repository.getExcel(id)
            if (res.isSuccessful) {
                val applicants = res.body()?.map {
                    Applicant(it.name, it.email)
                }
                applicantList.postValue(applicants)
            }
        }
    }

    fun loadTemplateList() {
        templateList.value = listOf()
        isShowTemplateDropdown.value = true
        viewModelScope.launch {
            val res = repository.getTemplateList()
            if (res.isSuccessful) {
                templateList.postValue(res.body())
            }
        }
    }

    fun selectTemplate(id: Int, name: String, content: String) {
        template.value = Template(id, name, content)
        templateName.value = name
        hideTemplateDropdown()
    }

    fun hideExcelDropdown() {
        isShowExcelDropdown.postValue(false)
    }

    fun hideTemplateDropdown() {
        isShowTemplateDropdown.postValue(false)
    }
}