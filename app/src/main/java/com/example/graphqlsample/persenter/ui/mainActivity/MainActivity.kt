package com.example.graphqlsample.persenter.ui.mainActivity


import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.graphqlsample.R
import com.example.graphqlsample.persenter.base.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigationBottom()
    }

    private fun setupNavigationBottom() {
        val navController: NavController =
            Navigation.findNavController(this, R.id.navHostFragment_MainActivity)
        val bottomNavigationView =
            findViewById<BottomNavigationView>(R.id.bottomNavigation_MainActivity)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }
}