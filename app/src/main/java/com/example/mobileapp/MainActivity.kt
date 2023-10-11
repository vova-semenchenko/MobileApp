package com.example.mobileapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dataModel: ChangeTextModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        dataModel.changedText.observe(this ) {
            binding.textView.text = it
        }

        binding.changeTextButton.setOnClickListener {

            if(binding.editTextField.text.isNullOrEmpty()) {

                Toast.makeText(this, "Please enter text.", Toast.LENGTH_LONG).show()
            }
            else
            {
                dataModel.setText(binding.editTextField.text.toString())
                Toast.makeText(this, "Text changed successfully.", Toast.LENGTH_LONG).show()

                binding.editTextField.clearFocus()
                binding.editTextField.text.clear()
            }
        }

    }

}