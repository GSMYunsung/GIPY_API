package com.pss.gify_study.view

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.cys.gify_study.R
import com.cys.gify_study.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pss.gify_study.base.BaseActivity
import com.pss.gify_study.data.remote.model.GiphyRequest
import com.pss.gify_study.viewmodel.MainViewModel
import com.pss.gify_study.widget.utils.Utils.GIPHY_API_KEY
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    lateinit var navi: BottomNavigationView
    private lateinit var navController: NavController

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun init() {

        navi = binding.bottomNavigationView

        navController =
            supportFragmentManager.findFragmentById(R.id.nav_host_container)?.findNavController()!!

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.mainFragment,
                R.id.favoriteFragment
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navi.setupWithNavController(navController)

        initNavigation()

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun initNavigation() {
        val navController = findNavController(R.id.nav_host_container)
        binding.bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.mainFragment || destination.id == R.id.favoriteFragment) {
                binding.bottomNavigationView.visibility = View.VISIBLE
            } else {
                binding.bottomNavigationView.visibility = View.GONE
            }


        }

    }
}