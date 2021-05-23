package com.cube.mailcube.api

import com.cube.mailcube.api.model.Applicant
import com.cube.mailcube.api.model.Excel
import com.cube.mailcube.api.model.Template
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

internal interface MailCubeNetworkService {
    @GET("excels")
    suspend fun getExcelList(): Response<List<Excel>>

    @GET("excels/{id}")
    suspend fun getExcel(
        @Path("id")
        id: Int
    ): Response<List<Applicant>>

    @GET("templates")
    suspend fun getTemplateList(): Response<List<Template>>

    @GET("templates/{id}")
    suspend fun getTemplate(
        @Path("id")
        id: Int
    ): Response<Template>
}