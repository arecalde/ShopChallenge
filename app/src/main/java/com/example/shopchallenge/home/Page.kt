package com.example.shopchallenge.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.shopchallenge.R

class PageFragment : Fragment() {
//    private val viewModel: PageViewModel by viewModels {
//        PageViewModelFactory(
//            requireActivity().application,
//            args.url
//        )
//    }
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            return inflater.inflate(R.layout.page_fragment, container, false)
        }


    }