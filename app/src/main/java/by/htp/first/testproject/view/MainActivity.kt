package by.htp.first.testproject.view

import android.os.Bundle
import android.view.View
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import by.htp.first.testproject.R
import java.util.ArrayList
import java.util.HashMap

//class MainActivity : AppCompatActivity() {

/*private lateinit var binding: ActivityMainBinding
private lateinit var rootView: View*/

//var switch : SwitchButton? = null

/* override fun onCreate(savedInstanceState: Bundle?) {
     super.onCreate(savedInstanceState)
     setContentView(R.layout.expexample)*/

class MainActivity : AppCompatActivity() {
    var expListView: ExpandableListView? = null
    var expListAdapter: ExpandableListAdapter? = null
    var expListTitle: List<String>? = null
    var expListDetail: HashMap<String, List<String>>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_settings)
        expListView = findViewById<View>(R.id.expandableList) as ExpandableListView
        expListDetail = loadData()
        expListTitle = ArrayList(expListDetail!!.keys)
        expListAdapter = SettingExpandableListAdapter(this, expListTitle as ArrayList<String>, expListDetail!!)
        expListView!!.setAdapter(expListAdapter)

        expListView!!.setOnGroupClickListener { parent, v, groupPosition, id ->
            setListViewHeight(parent, groupPosition)
            false
        }
        /* expListView!!.setOnGroupExpandListener { groupPosition ->
             Toast.makeText(
                 applicationContext, (expListTitle as ArrayList<String>).get(groupPosition) + " Список раскрыт.",
                 Toast.LENGTH_SHORT
             ).show()
         }
         expListView!!.setOnGroupCollapseListener { groupPosition ->
             Toast.makeText(
                 applicationContext, (expListTitle as ArrayList<String>).get(groupPosition) + " Список скрыт.",
                 Toast.LENGTH_SHORT
             ).show()
         }
         expListView!!.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
             Toast.makeText(
                 applicationContext,
                 (expListTitle as ArrayList<String>).get(groupPosition) + " : " + (expListDetail!![(expListTitle as ArrayList<String>).get(
                     groupPosition
                 )]
                     ?.get(childPosition) ?: ), Toast.LENGTH_SHORT
             ).show()
             false
         }*/
    }

    private fun loadData(): HashMap<String, List<String>>? {
        val expDetails = HashMap<String, List<String>>()

        val oopLanguages: MutableList<String> = mutableListOf()
        oopLanguages.add("Name of Spectra")
        oopLanguages.add("Name of Spectra")
        oopLanguages.add("Name of Spectra")

        val structuredLanguages: MutableList<String> = mutableListOf()
        structuredLanguages.add("Number of Spectra")
        structuredLanguages.add("Number of Spectra")

        expDetails["Automatic stop of the analysis"] = oopLanguages
        expDetails["Analysis by samples"] = structuredLanguages

        return expDetails
    }

    private fun setListViewHeight(listView: ExpandableListView, group: Int) {
        val listAdapter = listView.expandableListAdapter as ExpandableListAdapter
        var totalHeight = 0
        val desiredWidth: Int =
            View.MeasureSpec.makeMeasureSpec(listView.width, View.MeasureSpec.EXACTLY)
        for (i in 0 until listAdapter.groupCount) {
            val groupItem: View = listAdapter.getGroupView(i, false, null, listView)
            groupItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED)
            totalHeight += groupItem.measuredHeight
            if (listView.isGroupExpanded(i) && i != group || !listView.isGroupExpanded(i) && i == group) {
                for (j in 0 until listAdapter.getChildrenCount(i)) {
                    val listItem: View = listAdapter.getChildView(i, j, false, null, listView)
                    listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED)
                    totalHeight += listItem.measuredHeight
                }
            }
        }

        val params = listView.layoutParams
        var height = (totalHeight + listView.dividerHeight * (listAdapter.groupCount - 1))
        if (height < 10) height = 200
        params.height = height
        listView.layoutParams = params
        listView.requestLayout()
    }
}

// switch = findViewById<SwitchButton>(R.id.swOnOff)

//  switch?.setOnClickListener{

/*if(switch?.isChecked!!){
    switch?.setBackColorRes(R.color.green)
}
else{
    switch?.setBackColorRes(R.color.gray)
}*/
// }
//  }
/*rootView = findViewById(R.id.rootMainLayout)
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
}*/

