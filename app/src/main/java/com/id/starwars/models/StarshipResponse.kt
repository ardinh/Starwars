package com.id.starwars.models

data class StarshipResponse(
    val count: Int,
    val results: List<Starship>
)

