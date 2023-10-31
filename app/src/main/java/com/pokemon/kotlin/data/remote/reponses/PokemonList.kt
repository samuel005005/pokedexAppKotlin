package com.pokemon.kotlin.data.remote.reponses

data class PokemonList(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)