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

class Signin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signin)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find views
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val signinButton = findViewById<Button>(R.id.signinBtn)
        val signupTextView = findViewById<TextView>(R.id.singuptxt)

        // 🔹 Navigate to Signup page
        signupTextView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // 🔹 Sign-in button logic (FIXED POSITION)
        signinButton.setOnClickListener {
//Specify endpoint
            val api = "https://linushiggs.alwaysdata.net/api/signin"
//Create a request params that will hold a data in a form
            val data = RequestParams()
            data.put("email", email.text.toString())
            data.put("password", password.text.toString())
// Import api helper
            val helper = ApiHelper(applicationContext)
            //By use of the function post_login inside of the helper class ,post your data
            helper.post_login(api, data)
        }
    }
}