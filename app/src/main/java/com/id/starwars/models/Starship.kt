package com.id.starwars.models

import com.google.gson.annotations.SerializedName

data class Starship(
    val name: String,
    val model: String,
    val manufacturer: String,
    @SerializedName("cost_in_credits")
    val costInCredits: String,
    @SerializedName("cargo_capacity")
    val cargoCapacity: String
)

