package by.htp.first.testproject.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import by.htp.first.testproject.R
import by.htp.first.testproject.databinding.ActivityStartBinding
import by.htp.first.testproject.model.data.StartData
import by.htp.first.testproject.presenter.StartActivityPresenter
import by.htp.first.testproject.presenter.impl.StartActivPresenterImpl
import com.google.android.material.snackbar.Snackbar

class StartActivity : AppCompatActivity() {

    private val presenter: StartActivityPresenter = StartActivPresenterImpl()
    private lateinit var binding: ActivityStartBinding
    private lateinit var view: View
    private var validationFlag = false
    private var operator = ""
    private var customer = ""
    private var farm = ""
    private var field = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        view = findViewById(R.id.rootView)
        binding = ActivityStartBinding.bind(view)

        binding.rgOperator.setOnCheckedChangeListener { group, checkedId ->
            operator = when (checkedId) {
                R.id.rbOperator1 -> binding.rbOperator1.text.toString()
                else -> binding.rbOperator2.text.toString()
            }
        }

        binding.rgCustomer.setOnCheckedChangeListener { group, checkedId ->
            customer = when (checkedId) {
                R.id.rbCustomer1 -> binding.rbCustomer1.text.toString()
                else -> binding.rbCustomer2.text.toString()
            }
        }

        binding.rgFarm.setOnCheckedChangeListener { group, checkedId ->
            farm = when (checkedId) {
                R.id.rbFarm1 -> binding.rbFarm1.text.toString()
                else -> binding.rbFarm2.text.toString()
            }
        }

        binding.rgField.setOnCheckedChangeListener { group, checkedId ->
            field = when (checkedId) {
                R.id.rbField1 -> binding.rbField1.text.toString()
                R.id.rbField2 -> binding.rbField3.text.toString()
                else -> binding.rbField3.text.toString()
            }
        }

        binding.buttonStart.setOnClickListener {
            fieldValidation(operator, customer, farm, field)
            if (validationFlag) {
                presenter.addData(StartData(operator,customer,farm,field))
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Snackbar.make(binding.root, "Please, fill the form ", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }

    private fun fieldValidation(
        operator: String,
        customer: String,
        farm: String,
        field: String
    ): Boolean {
        if (operator.isNotEmpty() && customer.isNotEmpty() && farm.isNotEmpty() && field.isNotEmpty()) {
            validationFlag = true
        }
        return validationFlag
    }
}