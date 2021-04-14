package by.htp.first.testproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.add
import androidx.fragment.app.commit
import by.htp.first.testproject.R
import by.htp.first.testproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FragmentLoader {

    private lateinit var binding: ActivityMainBinding
    private lateinit var rootView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rootView = findViewById(R.id.rootMainLayout)
        binding = ActivityMainBinding.bind(rootView)
        binding.bottomNavigation.setBackgroundColor(getColor(R.color.black))
        showFragment()

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.fragment_archive -> { loadFragment(ArchiveFragment(), FragmentTransaction.TRANSIT_FRAGMENT_OPEN) }

                R.id.fragment_home -> { loadFragment(HomeFragment(), FragmentTransaction.TRANSIT_FRAGMENT_OPEN) }

                R.id.fragment_settings -> { loadFragment(SettingsFragment(), FragmentTransaction.TRANSIT_FRAGMENT_OPEN)}
            }
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_bottom_navigation_view, menu)
        return true
    }

    private fun showFragment() {
        supportFragmentManager.commit {
            add<ArchiveFragment>(R.id.fragmentContainer)
        }
    }

    override fun loadFragment(fragment: Fragment, transitionCode: Int) {
        supportFragmentManager.commit {
            setTransition(transitionCode)
            replace(R.id.fragmentContainer, fragment)
            addToBackStack(null)
        }
    }
}