package com.example.test_5.service

import com.example.test_5.mainFragment.Courses
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface Service {
    @Headers("Content-Type: application/json")
    @GET("/v3/83160a49-fe85-46ba-bcf8-3cf5aa09f92b")
    suspend fun getNewCourseList(): Response<Courses.NewCourse>
}