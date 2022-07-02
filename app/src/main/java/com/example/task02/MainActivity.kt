package com.example.task02

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var weekSalaryEt: EditText? = null
    var weekSalesEt: EditText? = null
    var commissionPercentageEt: EditText? = null
    var totalSalaryTv: TextView? = null
    var week_salary: Float = 0f
    var week_sales: Float = 0f
    var commission_percent: Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        weekSalaryEt = findViewById(R.id.weekSalaryEt)
        weekSalesEt = findViewById(R.id.weekSalesEt)
        commissionPercentageEt = findViewById(R.id.commissionPercentageEt)
        totalSalaryTv = findViewById(R.id.totalSalaryTv)

        weekSalaryEt!!.addTextChangedListener(object : TextWatcher {

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int, after: Int
            ) {// TODO Auto-generated method stub
            }

            override fun afterTextChanged(s: Editable) {
                calculate()

            }
        })

        weekSalesEt!!.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int, after: Int
            ) {// TODO Auto-generated method stub
            }

            override fun afterTextChanged(s: Editable) {
                calculate()

            }
        })

        commissionPercentageEt!!.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int, after: Int
            ) {// TODO Auto-generated method stub
            }

            override fun afterTextChanged(s: Editable) {
                if (commissionPercentageEt.toString().isEmpty()) {
                    totalSalaryTv!!.text = weekSalaryEt.toString();
                }
                else
                    calculate()
            }
        })

    }

    fun calculate() {
        if (weekSalaryEt.toString().isEmpty() &&
            weekSalesEt.toString().isEmpty() &&
            commissionPercentageEt.toString().isEmpty()) {
            totalSalaryTv!!.text = "0";
        }
        if (weekSalaryEt!!.text.toString().isNotEmpty()) {
            week_salary = weekSalaryEt!!.text.toString().toFloat()
        }
        else {
            weekSalaryEt.toString().isEmpty()
            weekSalaryEt!!.setText("0")
        }

        if (weekSalesEt!!.text.toString().isNotEmpty()) {
            week_sales = weekSalesEt!!.text.toString().toFloat()
        }
        else {
            weekSalesEt.toString().isEmpty()
            weekSalesEt!!.setText("0")
        }

        if (commissionPercentageEt!!.text.toString().isNotEmpty()) {
            commission_percent = commissionPercentageEt!!.text.toString().toFloat()

            val commission = (week_sales / 100) * (commission_percent)
            val salary = commission + week_salary
            totalSalaryTv!!.text = salary.toInt().toString()


    }

}
}


