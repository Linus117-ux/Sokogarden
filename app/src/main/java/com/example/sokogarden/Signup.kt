package com.example.sokogarden

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.loopj.android.http.RequestParams

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        Find veiws by use of their id"s "
        val username = findViewById<EditText>(R.id.username)
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val phone = findViewById<EditText>(R.id.phone)
        val signupbutton = findViewById<Button>(R.id.signupBtn)
        val sigintextveiw = findViewById<TextView>(R.id.singintxt)

// Below when a person clicks on the txext veiw he or she is navigated to the signin
        sigintextveiw.setOnClickListener {
            val intent = Intent(applicationContext, Signin::class.java)
            startActivity(intent)
        }

        // onclick of signup button we want to register a person
        signupbutton.setOnClickListener {
            val api = "https://linushiggs.alwaysdata.net/api/signup"

            val data = RequestParams()
            data.put("username",username.text.toString().trim())
            data.put("email",email.text.toString().trim())
            data.put("password",password.text.toString().trim())
            data.put("phone",phone.text.toString().trim())

            val helper = ApiHelper(applicationContext)

            helper.post(api,data)
        }





    }




}