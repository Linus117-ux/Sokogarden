package com.example.sokogarden

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        Find buttons by use of id's '
        val Signinbutton= findViewById<Button>(R.id.signinBtn)
        val Signupbutton = findViewById<Button>(R.id.signupBtn)

//        Create the intents for ste on click listener
        Signupbutton.setOnClickListener {
            val intent = Intent(applicationContext, Signup::class.java)
            startActivity(intent)
        }
//        ============================================
        Signinbutton.setOnClickListener {
            val intent = Intent(applicationContext, Signin::class.java)
            startActivity(intent)
        }
//        find recycleveiw and progress bar
        val recyclerVeiw = findViewById<RecyclerView>(R.id.recyclerveiw)
        val progressbar = findViewById<ProgressBar>(R.id.progressbar)


        //Specify the api url endpoint for fetching products
        val url = "https://linushiggs.alwaysdata.net/api/getproduct"

//        import helper class
        val helper = ApiHelper(applicationContext)
//       Inside helper class access function loadproducts
        helper.loadProducts(url , recyclerVeiw , progressbar)
    }

}