package com.pokemon.kotlin.data.remote.reponses

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)