package com.voyager.forcastmvvm.Ui.weather.future.detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.voyager.forcastmvvm.R

class FutureDetailViewFragment : Fragment() {

    companion object {
        fun newInstance() =
            FutureDetailViewFragment()
    }

    private lateinit var viewModel: FutureDetailViewViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.future_detail_view_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FutureDetailViewViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
