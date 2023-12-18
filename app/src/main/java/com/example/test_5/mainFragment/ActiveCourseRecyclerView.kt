package com.example.test_5.mainFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.test_5.databinding.ActiveCourseLayoutBinding

class ActiveCourseRecyclerView: ListAdapter<Courses.ActiveCourse, ActiveCourseRecyclerView.ActiveCourseViewHolder>(ActiveCourseDiffUtil()) {

    class ActiveCourseDiffUtil : DiffUtil.ItemCallback<Courses.ActiveCourse>() {
        override fun areItemsTheSame(
            oldItem: Courses.ActiveCourse,
            newItem: Courses.ActiveCourse
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Courses.ActiveCourse,
            newItem: Courses.ActiveCourse
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActiveCourseViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        return ActiveCourseViewHolder(ActiveCourseLayoutBinding.inflate(inflate, parent, false))
    }

    override fun onBindViewHolder(holder: ActiveCourseViewHolder, position: Int) {
        val activeCourse = getItem(position)
        holder.bind(activeCourse)
    }

    inner class ActiveCourseViewHolder(private val binding: ActiveCourseLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        val context = binding.root.context
        fun bind(activeCourse: Courses.ActiveCourse) {
            with(binding) {
                tvBookingTime.text = activeCourse.bookingTime
                tvProgress.text = "${activeCourse.progress}"
                tvTitle.text = activeCourse.title
                Glide.with(context).load(activeCourse.image).into(ivImage)
            }
        }
    }

}