package com.cube.mailcube.repository

import androidx.annotation.WorkerThread
import com.cube.mailcube.api.MailCubeNetworkService

internal class ContentRepository(
    private val service: MailCubeNetworkService
) {
    @WorkerThread
    suspend fun getExcelList() = service.getExcelList()

    @WorkerThread
    suspend fun getExcel(id: Int) = service.getExcel(id)

    @WorkerThread
    suspend fun getTemplateList() = service.getTemplateList()

    @WorkerThread
    suspend fun getTemplate(id: Int) = service.getTemplate(id)
}