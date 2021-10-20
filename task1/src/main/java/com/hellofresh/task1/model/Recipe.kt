package com.hellofresh.task1.model


/**
 *Created by ramavijayapandian on 9/5/21.
 **/
data class Recipe(
    var id: String?,
    var title: String?,
    var selected: Boolean? = false,
    var tags: List<String>?,
)

class RecipeServices {
    private var recipeList: List<Recipe>? = arrayListOf()
    fun getRecipe(): List<Recipe>? {
        return recipeList
    }

    fun setRecipe(recipeList: List<Recipe>?) {
        this.recipeList = recipeList
    }
}

