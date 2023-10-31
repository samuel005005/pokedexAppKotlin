package com.pokemon.kotlin.repository

import com.pokemon.kotlin.data.remote.PokeApi
import com.pokemon.kotlin.data.remote.reponses.Pokemon
import com.pokemon.kotlin.data.remote.reponses.PokemonList
import com.pokemon.kotlin.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset);
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred.")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInto(name: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(name);
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred.")
        }
        return Resource.Success(response)
    }
}