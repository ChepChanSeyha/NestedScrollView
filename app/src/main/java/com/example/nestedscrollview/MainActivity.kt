package com.example.nestedscrollview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_dialog.*
import kotlinx.android.synthetic.main.activity_dialog.view.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinnerLocation = arrayOf("Location", "Phnom Penh", "Siem Reap", "Kompot")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerLocation)
        location.adapter = adapter

        val spinnerVehicle = arrayOf("Vehicle", "TUK TUK", "SUV", "Motorbike")
        vehicle.adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, spinnerVehicle)

        btn_submit.setOnClickListener {
            val mDialog = LayoutInflater.from(this).inflate(R.layout.activity_dialog, null)
            val mBuilder = AlertDialog.Builder(this).setView(mDialog)
            val mAlertDialog = mBuilder.show()

            val name = mDialog.findViewById<TextView>(R.id.var_name)
            val add = mDialog.findViewById<TextView>(R.id.var_address)
            val pho = mDialog.findViewById<TextView>(R.id.var_phone)
            val loca = mDialog.findViewById<TextView>(R.id.var_location)
            val vehi = mDialog.findViewById<TextView>(R.id.var_vehicle)
            val gend = mDialog.findViewById<TextView>(R.id.var_gender)
            val favor = mDialog.findViewById<TextView>(R.id.var_favorite)

            name.text = first_name.text.toString()+ " " + last_name.text.toString()
            add.text = address.text.toString()
            pho.text = phone.text.toString()
            location.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long){
                    // Display the selected item text on text view
                    loca.text = parent.getItemAtPosition(position).toString()
                }

                override fun onNothingSelected(parent: AdapterView<*>){
                    // Another interface callback
                }
            }
            vehicle.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long){
                    // Display the selected item text on text view
                    vehi.text = parent.getItemAtPosition(position).toString()
                }

                override fun onNothingSelected(parent: AdapterView<*>){
                    // Another interface callback
                }
            }


            mDialog.btn_save.setOnClickListener {
                mAlertDialog.dismiss()
            }
        }

    }

}
