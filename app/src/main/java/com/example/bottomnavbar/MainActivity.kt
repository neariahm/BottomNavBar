package com.example.bottomnavbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bottomnavbar.fragments.FavoritesFragment
import com.example.bottomnavbar.fragments.HomeFragment
import com.example.bottomnavbar.fragments.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialize Fragments
        val homeFragment = HomeFragment()
        val searchFragment = SearchFragment()
        val favoritesFragment = FavoritesFragment()

        makeCurrentFragment(homeFragment)

     //  val nav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.ic_home -> makeCurrentFragment(homeFragment)
                R.id.ic_search -> makeCurrentFragment(searchFragment)
                R.id.ic_favorite -> makeCurrentFragment(favoritesFragment)
            }
            true
        }

    }
    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}