package com.yallam.apps.mobiledirectory.vvm.mobileslist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.toast
import com.yallam.apps.mobiledirectory.R
import com.yallam.apps.mobiledirectory.vvm.MobilesListViewModel
import com.yallam.apps.mobiledirectory.vvm.MobilesListViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MobilesListFragment : Fragment() {

    @Inject
    lateinit var mobilesListViewModelFactory: MobilesListViewModelFactory
    @Inject
    lateinit var mobilesListViewModel: MobilesListViewModel

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mobilesListViewModel = ViewModelProviders.of(this, mobilesListViewModelFactory)
                .get(MobilesListViewModel::class.java)

        mobilesListViewModel.mobilesLiveData.observe(this, Observer {
            activity?.toast("${it?.size} mobiles retrieved", Toast.LENGTH_LONG)
        })

        mobilesListViewModel.errorLiveData.observe(this, Observer {
            activity?.toast(it ?: "Some error happened!")
        })

        return inflater.inflate(R.layout.fragment_mobiles_list, container, false)
    }

}
