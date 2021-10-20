package com.hellofresh.task1

import com.hellofresh.task1.model.Recipe

/**
 *Created by rama on 7/9/21.
 **/
interface IMenuManager {
    fun addRecipe(recipeList: List<Recipe>?)
    fun getRecipe(tag: String?): List<Recipe>?
    fun updateRecipe(id: String?, isSelected: Boolean? = false)
    fun updateRecipes(list: List<String>?, isSelected: Boolean? = false)
    fun getSelectedCount(): Int
}