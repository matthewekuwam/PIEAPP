package com.example.pieapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class MainActivity : AppCompatActivity() {
    //   declaring our view
    private lateinit var etusername: EditText
    private lateinit var etpassword: EditText
    private lateinit var btnsignin: ExtendedFloatingActionButton
    private val sharedPrefsFile="mynameprefs"
    private lateinit var SharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etusername = findViewById(R.id.etusername)
        etpassword = findViewById(R.id.etpassword)
        btnsignin = findViewById(R.id.btnsignin)
//        sharedPrefrences = getSharedPreferences(sharedPrefsFile, Context.MODE_PRIVATE)
        btnsignin.setOnClickListener {
//            grabbing text from edittext
            val username = etusername.text.toString().trim()
            val password = etpassword.text.toString().trim()
//            Toast.makeText( this,"hello", Toast.LENGTH_LONG).show()


            val homeActivity2 = Intent(Intent(this, HomeActivity2::class.java))
            homeActivity2.putExtra("username", username)
            startActivity(homeActivity2)


        }
    }
}