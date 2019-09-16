package org.guis.booking.data.response


import com.google.gson.annotations.SerializedName

data class Person(
  @SerializedName("birth_year")
  val birthYear: String,
  @SerializedName("eye_color")
  val eyeColor: String,
  val gender: String,
  @SerializedName("hair_color")
  val hairColor: String,
  val height: String,
  val mass: String,
  val name: String,
  @SerializedName("skin_color")
  val skinColor: String
)