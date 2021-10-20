package com.hellofresh.task1.feature

import com.hellofresh.task1.IMenuManager
import com.hellofresh.task1.model.Recipe


class Menu constructor(private val menuManager: IMenuManager) {

    //  get Services
    fun getRecipes(): List<Recipe>? = menuManager.getRecipe(null)

    fun getRecipes(tag: String): List<Recipe>? = menuManager.getRecipe(tag)

    fun setSelected(id: String) {
        menuManager.updateRecipe(id, isSelected = true)
    }

    fun setSelected(list: List<String>) {
        menuManager.updateRecipes(list, isSelected = true)
    }

    fun setDeselected(id: String) {
        menuManager.updateRecipe(id, isSelected = false)
    }

    fun setDeSelected(list: List<String>?) {
        menuManager.updateRecipes(list, isSelected = false)
    }

    /**
     * This function will return selected recipes count
     */
    fun getSelectedCount(): Int = menuManager.getSelectedCount()
}