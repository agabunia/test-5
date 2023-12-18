package com.example.test_5.mainFragment

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_5.BaseFragment
import com.example.test_5.databinding.FragmentMainBinding
import kotlinx.coroutines.launch

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {
    private lateinit var newCourseAdapter: NewCourseRecyclerAdapter
    private lateinit var activeCourseAdapter: ActiveCourseRecyclerView
    private val viewModel: ViewModel by viewModels()

    override fun setUp() {
        setNewCourseAdapter()
        setActiveCourseAdapter()
        viewModel.getData()
    }

    override fun setListeners() {

    }

    override fun observeData() {
        newCourse()
    }

    private fun setNewCourseAdapter() {
        newCourseAdapter = NewCourseRecyclerAdapter()
        with(binding) {
            recyclerNewCourse.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            recyclerNewCourse.adapter = newCourseAdapter
        }
    }

    private fun setActiveCourseAdapter() {
        activeCourseAdapter = ActiveCourseRecyclerView()
        with(binding) {
            recyclerCurrentCourse.layoutManager = LinearLayoutManager(requireContext())
            recyclerCurrentCourse.adapter = activeCourseAdapter
        }
    }

    private fun newCourse() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.newCourseFlow.collect {
                    newCourseAdapter.submitList(it)
                }
            }
        }
    }

}
