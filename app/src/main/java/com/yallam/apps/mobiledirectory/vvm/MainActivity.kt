package com.yallam.apps.mobiledirectory.vvm

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.yallam.apps.mobiledirectory.R
import com.yallam.apps.mobiledirectory.vvm.mobileslist.MobilesListFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation_view.setOnNavigationItemSelectedListener {
            return@setOnNavigationItemSelectedListener when (it.itemId) {
                R.id.bottom_navigation_profile -> true
                R.id.bottom_navigation_mobiles_list -> {
                    supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.fragment_container, MobilesListFragment())
                            .commit()
                    true
                }
                R.id.bottom_navigation_settings -> true
                else -> false
            }
        }
    }

}
