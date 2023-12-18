package com.example.test_5.mainFragment

import com.squareup.moshi.Json

data class Courses(
    @Json(name = "new_courses")
    val newCourses: NewCourse,
    @Json(name = "active_courses")
    val activeCourses: ActiveCourse
) {
    data class NewCourse(
        @Json(name = "id")
        val id: Int,
        @Json(name = "icon_type")
        val iconType: String,
        @Json(name = "duration")
        val duration: String,
        @Json(name = "title")
        val title: String,
        @Json(name = "question")
        val question: String,
        @Json(name = "main_color")
        val mainColor: String
    )
    data class ActiveCourse(
        @Json(name = "id")
        val id: Int,
        @Json(name = "booking_time")
        val bookingTime: String,
        @Json(name = "progress")
        val progress: Int,
        @Json(name = "title")
        val title: String,
        @Json(name = "main_color")
        val mainColor: String,
        @Json(name = "background_color_present")
        val backgroundColorPresent: Int,
        @Json(name = "play_button_color_present")
        val playButtonColorPresent: Int,
        @Json(name = "image")
        val image: String
    )
}
