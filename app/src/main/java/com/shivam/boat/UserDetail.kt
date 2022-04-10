package com.shivam.boat

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.jar.Manifest

class UserDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val lists: MutableList<Model>
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)
        val name = findViewById<TextView>(R.id.name)
        val company = findViewById<TextView>(R.id.company)
        val city = findViewById<TextView>(R.id.city)
        val street = findViewById<TextView>(R.id.street)
        val bS = findViewById<TextView>(R.id.bS)
        val catchPr = findViewById<TextView>(R.id.catchPr)
        val suite = findViewById<TextView>(R.id.suite)
        val zipcode = findViewById<TextView>(R.id.zipcode)
        val email = findViewById<TextView>(R.id.email)

        val btnPhn = findViewById<ImageView>(R.id.btnPhn)
        val openWeb = findViewById<ImageView>(R.id.openWeb)




        val position = intent.extras?.getInt("pos")
        if (position != null) {
            Log.d("hello","hiii")

            fun makeRequest() {
                ActivityCompat.requestPermissions(this,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    1)
            }

            fun setupPermissions() {
                val permission = ContextCompat.checkSelfPermission(this,
                    android.Manifest.permission.CALL_PHONE)

                if (permission != PackageManager.PERMISSION_GRANTED) {
                    Log.i("noone", "Permission to Call has denied")
                    makeRequest()
                }else{
//                    var call:String = MainActivity.list.get(position).phone.toString()
//                    Toast.makeText(this, call, Toast.LENGTH_SHORT).show()
                    val intent = Intent(Intent.ACTION_CALL)
                    intent.data = Uri.parse("tel:" + "+918982149171")
                    startActivity(intent)
                }
            }
            //Log.d("check",MainActivity.list.get(position).toString())

            //MainActivity.list.get(position).toString()
            var str:String = MainActivity.list.get(position).name.toString()
            name.setText(str)

            var str1:String = MainActivity.list.get(position).company.name.toString()
            company.setText(str1)

            var str3:String = MainActivity.list.get(position).address.city.toString()
            city.setText(str3)

            var str4:String = MainActivity.list.get(position).address.street.toString()
            street.setText(str4)

            var str5:String = MainActivity.list.get(position).address.suite.toString()
            suite.setText(str5)

            var str6:String = MainActivity.list.get(position).address.zipcode.toString()
            zipcode.setText(str6)

            var str7:String = MainActivity.list.get(position).company.catchPhrase.toString()
            catchPr.setText(str7)

            var str8:String = MainActivity.list.get(position).company.bs.toString()
            bS.setText(str8)

            var str9:String = MainActivity.list.get(position).email.toString()
            email.setText(str9)





            btnPhn.setOnClickListener{
                setupPermissions()
            }

            openWeb.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                Toast.makeText(this, MainActivity.list[position].website.toString(), Toast.LENGTH_SHORT).show()
                intent.data = Uri.parse("https://www." + MainActivity.list[position].website.toString());
                startActivity(intent)
            }




        }




    }
}