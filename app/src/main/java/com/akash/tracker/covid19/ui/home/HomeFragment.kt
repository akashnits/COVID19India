package com.akash.tracker.covid19.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.akash.tracker.covid19.AppExecutors
import com.akash.tracker.covid19.R
import com.akash.tracker.covid19.binding.FragmentDataBindingComponent
import com.akash.tracker.covid19.databinding.FragmentHomeBinding
import com.akash.tracker.covid19.di.Injectable
import com.akash.tracker.covid19.ui.common.RetryCallback
import com.akash.tracker.covid19.util.autoCleared
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val covidViewModel: CovidViewModel by viewModels {
        viewModelFactory
    }

    @Inject
    lateinit var appExecutors: AppExecutors

    var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)
    var binding by autoCleared<FragmentHomeBinding>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val dataBinding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )
        dataBinding.retryCallback = object : RetryCallback {
            override fun retry() {
                covidViewModel.retry()
            }
        }
        binding = dataBinding
        return dataBinding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //repoViewModel.setId(params.owner, params.name)
        binding.lifecycleOwner = viewLifecycleOwner
//        binding.repo = repoViewModel.repo
//
//        val adapter = ContributorAdapter(dataBindingComponent, appExecutors) {
//                contributor, imageView ->
//            val extras = FragmentNavigatorExtras(
//                imageView to contributor.login
//            )
//            findNavController().navigate(
//                RepoFragmentDirections.showUser(contributor.login, contributor.avatarUrl),
//                extras
//            )
//        }
//        this.adapter = adapter
//        binding.contributorList.adapter = adapter
//        initContributorList(repoViewModel)
    }
}
