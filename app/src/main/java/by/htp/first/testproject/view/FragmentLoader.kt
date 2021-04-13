package by.htp.first.testproject.view

import androidx.fragment.app.Fragment

interface FragmentLoader {
    fun loadFragment(fragment: Fragment, transitionCode: Int)
}