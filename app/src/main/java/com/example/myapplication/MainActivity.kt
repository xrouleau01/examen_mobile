package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = Intent(this, confirmation::class.java)

        val termes = View.OnClickListener {
            binding.bReserver.isEnabled = binding.switch1.isChecked
        }

        val reserver = View.OnClickListener {
            var pass = true
            try {
                val nbJours = binding.eTNbJours.text.toString().toInt()
                intent.putExtra("nbJours", nbJours.toString())
            }
            catch (_: NumberFormatException) {
                Toast.makeText(this, "Veuillez entrer un nombre de jours valide", Toast.LENGTH_LONG).show()
                pass = false
            }
            finally {
                val tag: String = "Main Activity"
                Log.i(tag, binding.spinModele.selectedItem.toString())
                Log.i(tag, binding.spinCouleur.selectedItem.toString())
                Log.i(tag, binding.eTNbJours.text.toString())
                binding.eTNbJours.text.clear()
                binding.switch1.isChecked = false
                binding.bReserver.isEnabled = false
                if (pass) {
                    intent.putExtra("modele", binding.spinModele.selectedItem.toString())
                    intent.putExtra("couleur", binding.spinCouleur.selectedItem.toString())
                    startActivity(intent)
                }
            }
        }
        binding.switch1.setOnClickListener(termes)
        binding.bReserver.setOnClickListener(reserver)
    }


}