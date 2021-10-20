package com.hellofresh.task1

import com.hellofresh.task1.model.Recipe
import com.hellofresh.task1.model.RecipeServices
import com.hellofresh.task1.model.SubscriptionServices


/**
 *Created by rama on 7/9/21.
 **/
class MenuManagerImpl constructor(
    private val recipeServices: RecipeServices,
    private val subscriptionServices: SubscriptionServices
) : IMenuManager {

    /**
     * This method will help set the Menu content
     * @param recipeList
     */
    override fun addRecipe(recipeList: List<Recipe>?) {
        this.recipeServices.setRecipe(recipeList)
    }

    /**
     * This method will help getAllMenu content and
     * also getRecipe based on tags
     * @param tag @optional
     * @return recipeList
     *
     */
    override fun getRecipe(tag: String?): List<Recipe>? {
        if (tag.isNullOrEmpty().not()) {
            return this.recipeServices.getRecipe()?.filter { it.tags?.contains(tag) ?: false }
        }
        return this.recipeServices.getRecipe()
    }

    /**
     * This below method will update the Menu content like selection
     * and deselection based on single item
     * @param id
     * @param isSelected
     */
    override fun updateRecipe(id: String?, isSelected: Boolean?) {
        if (isSelectionLimitAchieved()) {
            recipeServices.getRecipe()?.forEach {
                if (it.id.equals(id)) {
                    if (it.selected != isSelected) {
                        it.selected = isSelected
                    } else {
                        println(it.id + "Already updated")
                    }
                }
            }
        } else {
            println("Exceeded the limit")
        }
    }

    /**
     * This below method will update the Menu content like selection
     * and deselection based on multiple item
     * @param list
     * @param isSelected
     */
    override fun updateRecipes(list: List<String>?, isSelected: Boolean?) {
        if (isSelectionLimitAchieved()) {
            this.recipeServices.getRecipe()?.forEach { recipe ->
                list?.listIterator()?.forEach { id ->
                    if (recipe.id.equals(id)) {
                        if (recipe.selected != isSelected) {
                            recipe.selected = isSelected
                        } else {
                            println(recipe.id + "Already updated")
                        }
                    }
                }
            }
        } else {
            println("Exceeded the limit")
        }
    }

    /**
     * This method will return the current selected item count
     * in the menu list
     * @return recipeList
     */
    override fun getSelectedCount(): Int =
        recipeServices.getRecipe()?.filter { it.selected == true }?.size ?: 0

    private fun isSelectionLimitAchieved(): Boolean =
        if (subscriptionServices.getSubscription().isForFamily && getSelectedCount() < 5) {
            true
        } else getSelectedCount() < 3
}