package com.example.moviefy_clean_architecture.feature

import com.example.moviefy_clean_architecture.R
import com.example.moviefy_clean_architecture.common.ui.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardFragment: BaseFragment<Unit>() {
    override val viewModel: DashboardViewModel by viewModel()
    override val layoutId: Int = R.layout.fragment_dashboard

    override fun render(contentT: Unit) {
    }

}