package com.example.androidcoursJEHANNO

import android.content.res.ColorStateList
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.example.androidcoursJEHANNO.R.color
import com.example.androidcoursJEHANNO.R.color.nutrient_level_high
import com.example.androidcoursJEHANNO.R.string
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.details_sheet.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
/*
        supportFragmentManager
            .beginTransaction().apply {
                //add()
                replace(R.id.detailsFragment, ProductsListFragment())
                commitAllowingStateLoss()
            }
*/

        //detail_sheet
        //DrawableCompat.setTintList(saltPastille.background, ColorStateList.valueOf( resources.getColor(color.nutrient_level_high)))
        //DrawableCompat.setTintList(sugarPastille.background, ColorStateList.valueOf(resources.getColor(color.nutrient_level_moderate)))
        //DrawableCompat.setTintList(fatty_acidPastille.background, ColorStateList.valueOf(resources.getColor(color.nutrient_level_high)))
        //DrawableCompat.setTintList(fatsPastille.background, ColorStateList.valueOf(resources.getColor(color.nutrient_level_low)))
        //DrawableCompat.setTintList(saltPastille.background, nutrient_level_high)

        //page_sheet
        val product : Product = Product("Petits pois et carottes",
        "Cassegrain",
        "3083680085304",
            "",
            "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
            "400 g (280 g net égoutté)",
            arrayOf("France","Japon","Suisse"),
            arrayOf("Petits poids 66%", "eau","garniture 2,8% (salade, oignons grelot)", "sucre","sel","arôme naturel"),
            arrayOf("Aucune"),
            arrayOf("Aucun")
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_sheet)

        //  Picasso.get().load(product.image).into(R.id.productImage)
        findViewById<TextView>(R.id.productName)
            .setTextBold(
            getString(string.productName)
        )

        findViewById<TextView>(R.id.productBrand)
            .setTextBold(
                getString(string.brand, product.brand),
            )

        findViewById<TextView>(R.id.productBarcode)
            .setTextBold(
                getString(string.productBarcode, product.barcode),
            )

        findViewById<TextView>(R.id.productQuantity)
            .setTextBold(
            getString(string.quantity, product.quantity),
        )

        findViewById<TextView>(R.id.productSale)
            .setTextBold(
            getString(string.sale, product.arrayToString(product.countries)),
        )

        findViewById<TextView>(R.id.productIngredients)
            .setTextBold(
            getString(string.ingredients, product.arrayToString(product.ingredients)),
        )

        findViewById<TextView>(R.id.productAlergenicSubstances)
            .setTextBold(
            getString(string.alergenicSubstances, product.arrayToString(product.allergenicSubstances)),
        )

        findViewById<TextView>(R.id.productAdditives)
            .setTextBold(
            getString(string.additives, product.arrayToString(product.additives)),
        )

        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.toolbar))
        // la petite bulle qui apparait au démarrage de l'app
        Toast.makeText(this,"Bienvenue !", Toast.LENGTH_SHORT).show()

    }

    private fun TextView.setTextBold(text: String, separator: String = ":") {
        val builder = SpannableStringBuilder(text)
        builder.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(separator) + 1, 0)
        setText(builder)
    }
}