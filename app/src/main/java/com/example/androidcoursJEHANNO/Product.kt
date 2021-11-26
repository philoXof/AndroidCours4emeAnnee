package com.example.androidcoursJEHANNO

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    var name: String,
    var brand: String,
    var barcode: String,
    var nutriscore: String,
    var image: String,
    var quantity: String,
    var countries: Array<String>,
    var ingredients: Array<String>,
    var allergenicSubstances: Array<String>,
    var additives: Array<String>,
    var nutritionFacts : NutritionFacts) : Parcelable
{

    public fun arrayToString(array : Array<String>) : String{
        var temp : String = ""
        for (value in array){
            temp = "$temp $value, "
        }
        return temp
    }

    private fun ingredientsToString():String{
        var temp : String = ""
        for (ingredient in this.ingredients){
            temp = "$temp, $ingredient"
        }
        return temp
    }
    private fun countriesToString():String{
        var temp : String = ""
        for (country in this.countries){
            temp = "$temp, $country"
        }
        return temp
    }
    private fun allergenicSubstancesToString():String{
        var temp : String = ""
        for (allergenicSubstance in this.allergenicSubstances){
            temp = "$temp, $allergenicSubstance"
        }
        return temp
    }
    private fun additivesToString():String{
        var temp : String = ""
        for (additive in this.additives){
            temp = "$temp, $additive"
        }
        return temp
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Product

        if (name != other.name) return false
        if (brand != other.brand) return false
        if (barcode != other.barcode) return false
        if (nutriscore != other.nutriscore) return false
        if (image != other.image) return false
        if (quantity != other.quantity) return false
        if (!countries.contentEquals(other.countries)) return false
        if (!ingredients.contentEquals(other.ingredients)) return false
        if (!allergenicSubstances.contentEquals(other.allergenicSubstances)) return false
        if (!additives.contentEquals(other.additives)) return false
        if (nutritionFacts != other.nutritionFacts) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + brand.hashCode()
        result = 31 * result + barcode.hashCode()
        result = 31 * result + nutriscore.hashCode()
        result = 31 * result + image.hashCode()
        result = 31 * result + quantity.hashCode()
        result = 31 * result + countries.contentHashCode()
        result = 31 * result + ingredients.contentHashCode()
        result = 31 * result + allergenicSubstances.contentHashCode()
        result = 31 * result + additives.contentHashCode()
        result = 31 * result + nutritionFacts.hashCode()
        return result
    }


}