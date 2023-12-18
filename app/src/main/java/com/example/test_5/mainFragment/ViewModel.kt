package com.example.test_5.mainFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_5.network.NetworkModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import retrofit2.Response

class ViewModel : ViewModel() {

    private val _newCourseFlow = MutableStateFlow<List<Courses.NewCourse>>(emptyList())
    val newCourseFlow: SharedFlow<List<Courses.NewCourse>> = _newCourseFlow
    private val courseList = mutableListOf<Courses.NewCourse>()

//    private val _activeCourseFlow = MutableStateFlow<Resource<Courses.ActiveCourse>>(Resource.Loading(isLoading = true))
//    val activeCourseFlow: SharedFlow<Resource<Courses.ActiveCourse>> = _activeCourseFlow.asStateFlow()

    fun getData() {
        viewModelScope.launch {
            try {
                val response: Response<Courses.NewCourse> = NetworkModel.get().getNewCourseList()
                if (response.isSuccessful) {
                    val coursesData = response.body()
                    courseList.addAll(coursesData)
                    _newCourseFlow.value = courseList

                } else {
//                    _newCourseFlow.value = response.body().toString()
//                    _activeCourseFlow.value = Resource.Fail(errorMessage = response.errorBody()?.toString() ?: "")
                }
            } catch (e: Throwable) {
//                _newCourseFlow.value = Resource.Fail(errorMessage = e.message.toString())
//                _activeCourseFlow.value = Resource.Fail(errorMessage = e.message.toString())
            }
        }
    }


}
