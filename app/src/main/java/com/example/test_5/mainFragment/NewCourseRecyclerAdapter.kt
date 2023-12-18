package com.example.test_5.mainFragment

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test_5.databinding.NewCourseLayoutBinding

class NewCourseRecyclerAdapter :
    ListAdapter<Courses.NewCourse, NewCourseRecyclerAdapter.NewCourseViewHolder>(NewCourseDiffUtil()) {

    class NewCourseDiffUtil : DiffUtil.ItemCallback<Courses.NewCourse>() {
        override fun areItemsTheSame(
            oldItem: Courses.NewCourse,
            newItem: Courses.NewCourse
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Courses.NewCourse,
            newItem: Courses.NewCourse
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewCourseViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        return NewCourseViewHolder(NewCourseLayoutBinding.inflate(inflate, parent, false))
    }

    override fun onBindViewHolder(holder: NewCourseViewHolder, position: Int) {
        val newCourse = getItem(position)
        holder.bind(newCourse)
    }

    inner class NewCourseViewHolder(private val binding: NewCourseLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(newCourses: Courses.NewCourse) {
            with(binding) {
                tvIconType.text = newCourses.iconType
                tvDuration.text = newCourses.duration
                tvTitle.text = newCourses.title
                tvQuestion.text = newCourses.question
                layoutNewCourse.setBackgroundColor(Color.parseColor("#${newCourses.mainColor}"))
            }
        }
    }

}