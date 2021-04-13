package by.htp.first.testproject.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.htp.first.testproject.R
import by.htp.first.testproject.databinding.FragmentHomeBinding

class HomeFragment: Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        binding.fab.setColorFilter(resources.getColor(R.color.white))

    }

}