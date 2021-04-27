package by.htp.first.testproject.view

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ExpandableListView
import androidx.appcompat.app.AppCompatActivity
import by.htp.first.testproject.R
import java.util.ArrayList
import java.util.HashMap

class SettingActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.fragment_settings)

        val expListDetails: HashMap<String, List<String>> = HashMap<String, List<String>>()

        val oopLanguages: MutableList<String> = ArrayList()
        oopLanguages.add("Java")
        oopLanguages.add("C++")
        oopLanguages.add("C#")
        oopLanguages.add("Python")
        oopLanguages.add("Scala")

        val structuredLanguages: MutableList<String> = ArrayList()
        structuredLanguages.add("ALGOL")
        structuredLanguages.add("COBOL")
        structuredLanguages.add("QBasic")
        structuredLanguages.add("COMAL")
        structuredLanguages.add("LEAP")

        val functionalLanguages: MutableList<String> = ArrayList()
        functionalLanguages.add("Haskell")
        functionalLanguages.add("Miranda")
        functionalLanguages.add("Curry")
        functionalLanguages.add("Clean")
        functionalLanguages.add("Joy")

        expListDetails["OOP языки программирования"] = oopLanguages
        expListDetails["Structured языки программирования"] = structuredLanguages
        expListDetails["Functional языки программирования"] = functionalLanguages

        val expListTitle = ArrayList(expListDetails.keys)

        val expandableListView = findViewById<ExpandableListView>(R.id.expandableList)
        val adapter = SettingExpandableListAdapter(this, expListTitle, expListDetails)
        expandableListView.setAdapter(adapter)

    }
}


