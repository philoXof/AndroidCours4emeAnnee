package com.example.androidcoursJehannoLucas

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info_page_contrainst_view)


        findViewById<TextView>(R.id.barcode)
            .setTextBold(
                getString(R.string.product_barcode, "1234"),
            )
        findViewById<TextView>(R.id.quantity).setTextBold(
            getString(R.string.quantity, "coucou"),
        )
        findViewById<TextView>(R.id.sale).setTextBold(
            getString(R.string.sale, "coucou"),
        )
        findViewById<TextView>(R.id.ingredients).setTextBold(
            getString(R.string.ingredients, "coucou"),
        )
        findViewById<TextView>(R.id.alergenicSubstances).setTextBold(
            getString(R.string.alergenicSubstances, "coucou"),
        )
        findViewById<TextView>(R.id.additives).setTextBold(
            getString(R.string.additives, "coucou"),
        )

//        findViewById<TextView>(R.id)


        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.toolbar))
        Toast.makeText(this,"Bienvenue !",Toast.LENGTH_SHORT).show()
    }

    private fun TextView.setTextBold(text: String, separator: String = ":") {
        val builder = SpannableStringBuilder(text)
        builder.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(separator) + 1, 0)
        setText(builder)
    }
}

