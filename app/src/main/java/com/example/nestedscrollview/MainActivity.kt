package com.example.nestedscrollview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_dialog.view.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n", "InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var strLocation = ""
        var strGender = ""

        // Array spinner of Location
        val spinnerLocation = arrayOf("Location", "Phnom Penh", "Siem Reap", "Kompot")
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerLocation)
        location.adapter = adapter1

        // Set value when click specific position
        location.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long){
                // Display the selected item text on text view
                strLocation = parent.getItemAtPosition(position).toString()
//                locat.text = parent.getItemAtPosition(position).toString()
//                    Log.d("ggg", parent.getItemAtPosition(position).toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>){
                // Another interface callback
            }
        }

        // Array spinner of Vehicle
        val spinnerVehicle = arrayOf("Vehicle", "TUK TUK", "SUV", "Motorbike")
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerVehicle)
        vehicle.adapter = adapter2

        // Set value when click specific position
        vehicle.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long){
                // Display the selected item text on text view
                strGender = parent.getItemAtPosition(position).toString()
//                vehi.text = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>){
                // Another interface callback
            }
        }

        // When Click button Done
        btn_submit.setOnClickListener {

            // Call new activity
            val mDialog = LayoutInflater.from(this).inflate(R.layout.activity_dialog, null)
            // Show Dialog view
            val mBuilder = AlertDialog.Builder(this).setView(mDialog)
            val mAlertDialog = mBuilder.show()

            // value of id new activity
            val nameV = mDialog.findViewById<TextView>(R.id.var_name)
            val addressV = mDialog.findViewById<TextView>(R.id.var_address)
            val phoneV = mDialog.findViewById<TextView>(R.id.var_phone)
            val locationV = mDialog.findViewById<TextView>(R.id.var_location)
            val vehicleV = mDialog.findViewById<TextView>(R.id.var_vehicle)
            val genderV = mDialog.findViewById<TextView>(R.id.var_gender)
            val favoriteV = mDialog.findViewById<TextView>(R.id.var_favorite)

            nameV.text = "${first_name.text.toString()} ${last_name.text.toString()}"
            addressV.text = address.text.toString()
            phoneV.text = phone.text.toString()
            locationV.text = strLocation
            vehicleV.text = strGender


            // get checked radioButton
            val id = gender.checkedRadioButtonId
            if (id!= -1) {
                val radio = findViewById<RadioButton>(id)
                genderV.text = radio.text
            }

            // get checked checkBox
            if (reading.isChecked) {
                val strReading = reading.text.toString()
                favoriteV.text = "$strReading; ${favoriteV.text}"
            }
            if (spot.isChecked) {
                val strSpot = spot.text.toString()
                favoriteV.text = "$strSpot; ${favoriteV.text}"
            }
            if (watchMovie.isChecked) {
                val strWatch = watchMovie.text.toString()
                favoriteV.text = "$strWatch; ${favoriteV.text}"
            }
            if (computerGame.isChecked) {
                val strComputer = computerGame.text.toString()
                favoriteV.text = "$strComputer; ${favoriteV.text}"
            }
            if (eating.isChecked) {
                val strEat = eating.text.toString()
                favoriteV.text = "$strEat; ${favoriteV.text}"
            }
            if (travel.isChecked) {
                val strTravel = travel.text.toString()
                favoriteV.text = "$strTravel; ${favoriteV.text}"
            }

            mDialog.btn_save.setOnClickListener {
                mAlertDialog.dismiss()
            }
        }

    }

}
