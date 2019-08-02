package com.example.nestedscrollview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_dialog.*
import kotlinx.android.synthetic.main.activity_dialog.view.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinnerLocation = arrayOf("Location", "Phnom Penh", "Siem Reap", "Kompot")
        location.adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, spinnerLocation)

        val spinnerVehicle = arrayOf("Vehicle", "TUK TUK", "SUV", "Motorbike")
        vehicle.adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, spinnerVehicle)

        btn_submit.setOnClickListener {
            val mDialog = LayoutInflater.from(this).inflate(R.layout.activity_dialog, null)
            val mBuilder = AlertDialog.Builder(this).setView(mDialog)
            val mAlertDialog = mBuilder.show()

            val name = mDialog.findViewById<TextView>(R.id.var_name)
            name.text = first_name.text.toString()

//            val fName = mDialog.findViewById<EditText>(R.id.first_name).text.toString()
//            val lName = mDialog.findViewById<EditText>(R.id.last_name).text.toString()
//            val address = mDialog.findViewById<EditText>(R.id.address).text.toString()
//            val phone = mDialog.findViewById<EditText>(R.id.phone).text.toString()
//            val location = mDialog.findViewById<Spinner>(R.id.location).toString()
//            val vehicle = mDialog.findViewById<Spinner>(R.id.vehicle).toString()
//            val gender = mDialog.findViewById<RadioGroup>(R.id.gender).toString()
//            val favorite = mDialog.findViewById<TableRow>(R.id.favorite).toString()
//
//            var_name.text = "$fName $lName"
//            var_address.text = address
//            var_phone.text = phone
//            var_location.text = location
//            var_vehicle.text = vehicle
//            var_gender.text = gender
//            var_favorite.text = favorite

            mDialog.btn_save.setOnClickListener {
                mAlertDialog.dismiss()
            }
        }


    }
}
