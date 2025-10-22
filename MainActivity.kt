package com.anggun.prak3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

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

        // --- MULAI TAMBAHAN KODE ---

        // 1. Temukan semua view dari layout
        val etFullName: TextInputEditText = findViewById(R.id.etFullName)
        val etUsername: TextInputEditText = findViewById(R.id.etUsername)
        val etAge: TextInputEditText = findViewById(R.id.etAge)
        val etEmail: TextInputEditText = findViewById(R.id.etEmail)
        val radioGroupGender: RadioGroup = findViewById(R.id.radioGroupGender)
        val etPassword: TextInputEditText = findViewById(R.id.etPassword)
        val etConfirmPassword: TextInputEditText = findViewById(R.id.etConfirmPassword)
        val btnSubmit: Button = findViewById(R.id.btnSubmit)

        // 2. Set listener untuk tombol submit
        btnSubmit.setOnClickListener {
            // 3. Ambil semua data dari input
            val fullName = etFullName.text.toString().trim()
            val username = etUsername.text.toString().trim()
            val age = etAge.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            // Ambil gender dari RadioGroup
            val selectedGenderId = radioGroupGender.checkedRadioButtonId
            val gender = if (selectedGenderId == R.id.rbLakiLaki) {
                "Laki-laki"
            } else {
                "Perempuan"
            }

            // 4. Validasi input
            if (fullName.isEmpty() || username.isEmpty() || age.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "Password dan Konfirmasi Password tidak cocok!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 5. Jika validasi sukses, kirim data ke ResultActivity
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("EXTRA_FULL_NAME", fullName)
            intent.putExtra("EXTRA_USERNAME", username)
            intent.putExtra("EXTRA_AGE", age)
            intent.putExtra("EXTRA_EMAIL", email)
            intent.putExtra("EXTRA_GENDER", gender)
            startActivity(intent)
        }

        // --- AKHIR TAMBAHAN KODE ---
    }
}

