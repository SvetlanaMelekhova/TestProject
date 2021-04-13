package by.htp.first.testproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.fragment.app.*
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
                R.id.item1 -> { loadFragment(ArchiveFragment(), FragmentTransaction.TRANSIT_FRAGMENT_OPEN) }

                R.id.item2 -> { loadFragment(HomeFragment(), FragmentTransaction.TRANSIT_FRAGMENT_OPEN) }

                R.id.item3 -> { loadFragment(SettingsFragment(), FragmentTransaction.TRANSIT_FRAGMENT_OPEN)}
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
            add<HomeFragment>(R.id.fragmentContainer)
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