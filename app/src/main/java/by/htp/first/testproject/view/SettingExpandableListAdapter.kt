package by.htp.first.testproject.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import android.widget.Toast
import by.htp.first.testproject.R
import com.kyleduo.switchbutton.SwitchButton
import java.util.HashMap

class SettingExpandableListAdapter(
    private val context: Context,
    private val expListTitle: List<String>,
    private val expListDetail: HashMap<String, List<String>>
) : BaseExpandableListAdapter() {

    override fun getGroup(groupPosition: Int): Any {
        return expListTitle[groupPosition]
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup
    ): View {
        var convert = convertView
        val listTitle: String = getGroup(groupPosition) as String
        if (convert == null) {
            val layoutInflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convert = layoutInflater.inflate(R.layout.list_group_expandable_list_settings, null)
        }
        val listTitleTextView = convert!!.findViewById<TextView>(R.id.tvTitle)
        listTitleTextView?.text = listTitle

        /*val switch = convert.findViewById<SwitchButton>(R.id.swOnOffManualStop)
        switch.setOnClickListener {
            Toast.makeText(context, "hhh", Toast.LENGTH_SHORT).show()
        }*/

        return convert
    }





    override fun getChild(listPosition: Int, expListPosition: Int): Any {
        return expListDetail[expListTitle[listPosition]]!![expListPosition]
    }

    override fun getChildView(
        listPosition: Int, expandedListPosition: Int,
        isLastChild: Boolean, convertView: View?, parent: ViewGroup
    ): View {
        var convert = convertView
        val expListText = getChild(listPosition, expandedListPosition) as String
        if (convert == null) {
            val layoutInflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convert = layoutInflater.inflate(R.layout.list_child_expandable_list_settings, null)
        }
        val textChild = convert!!.findViewById<TextView>(R.id.tvNameOfSpectra)
        textChild.text = expListText

        return convert
    }

    override fun getGroupId(listPosition: Int): Long {
        return listPosition.toLong()
    }

    override fun getChildId(listPosition: Int, expandedListPosition: Int): Long {
        return expandedListPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return expListTitle.size
    }

    override fun getChildrenCount(listPosition: Int): Int {
        return expListDetail[expListTitle[listPosition]]!!.size
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(listPosition: Int, expandedListPosition: Int): Boolean {
        return true
    }
}

/*
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import by.htp.first.testproject.R
import java.util.HashMap

class SettingExpandableListAdapter(
    private val context: Context,
    private val expListTitle: ArrayList<String>,
    private val expListDetails: HashMap<String, List<String>>
) :BaseExpandableListAdapter() {

    override fun getGroup(groupPosition: Int): Any {
        return this.expListTitle[groupPosition]
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        var convert = convertView
        val listTitle: String = getGroup(groupPosition) as String
        if (convert == null) {
            val layoutInflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convert = layoutInflater.inflate(R.layout.list_group_expandable_list_settings, null)
        }
        val listTitleTextView = convert!!.findViewById<TextView>(R.id.tvTitle)
        listTitleTextView?.text = listTitle

        return convert
    }

    override fun getChild(groupPosition: Int, childPosition: Int): String? {
        return this.expListDetails[this.expListTitle[groupPosition]]?.get(childPosition)
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?
    ): View {
        var convert = convertView
        val expListText = getChild(groupPosition, childPosition) as String
        if (convert == null) {
            val layoutInflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convert = layoutInflater.inflate(R.layout.list_child_expandable_list_settings, null)
        }
        val textChild = convert!!.findViewById<TextView>(R.id.tvNameOfSpectra)
        textChild.text = expListText

        return convert
    }

    override fun getGroupCount() = this.expListTitle.size

    override fun getChildrenCount(groupPosition: Int): Int {
       return this.expListDetails[this.expListTitle[groupPosition]]!!.size
    }

    override fun getGroupId(groupPosition: Int) = groupPosition.toLong()

    override fun getChildId(groupPosition: Int, childPosition: Int) = childPosition.toLong()

    override fun hasStableIds() = false

    override fun isChildSelectable(groupPosition: Int, childPosition: Int) = true
}*/
