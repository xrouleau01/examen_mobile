package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.databinding.ActivityConfirmationBinding
import com.example.myapplication.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
lateinit var binding2: ActivityConfirmationBinding
class confirmation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2 = ActivityConfirmationBinding.inflate(layoutInflater)
        setContentView(binding2.root)

        val tag2: String = "Confirmation Activity"
        Log.i(tag2, intent.getStringExtra("modele").toString())
        Log.i(tag2, intent.getStringExtra("couleur").toString())
        Log.i(tag2, intent.getStringExtra("nbJours").toString())

        val quitter = View.OnClickListener{
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Confirmer")
            builder.setMessage("Êtes-vous sûr de vouloir quitter?")
            builder.setPositiveButton("Oui") { _, _ ->
                finish()
            }
            builder.setNegativeButton("Non") { dialog, _ ->
                dialog.dismiss()
            }
            builder.setCancelable(true)

            val dialog = builder.create()
            dialog.show()
        }

        binding2.bQuitter.setOnClickListener(quitter)

        val nbJours = intent.getStringExtra("nbJours")?.toInt()
        var total = "$ "
        total += ((nbJours?.times(72)).toString())
        binding2.tVCout.text = total
    }

}