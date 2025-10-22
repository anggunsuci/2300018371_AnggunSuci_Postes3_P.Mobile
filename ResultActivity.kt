package com.anggun.prak3

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Temukan TextViews dari layout
        val tvFullNameResult: TextView = findViewById(R.id.FullNameResult)
        val tvUsernameResult: TextView = findViewById(R.id.UsernameResult)
        val tvAgeResult: TextView = findViewById(R.id.AgeResult)
        val tvEmailResult: TextView = findViewById(R.id.EmailResult)
        val tvGenderResult: TextView = findViewById(R.id.GenderResult)

        // Ambil data yang dikirim dari MainActivity
        val fullName = intent.getStringExtra("EXTRA_FULL_NAME")
        val username = intent.getStringExtra("EXTRA_USERNAME")
        val age = intent.getStringExtra("EXTRA_AGE")
        val email = intent.getStringExtra("EXTRA_EMAIL")
        val gender = intent.getStringExtra("EXTRA_GENDER")

        // Set text ke TextViews
        tvFullNameResult.text = "Full Name: $fullName"
        tvUsernameResult.text = "Username: $username"
        tvAgeResult.text = "Age: $age"
        tvEmailResult.text = "Email: $email"
        tvGenderResult.text = "Gender: $gender"
    }
}
