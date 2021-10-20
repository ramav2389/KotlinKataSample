package com.hellofresh.task1

import com.hellofresh.task1.feature.Menu
import com.hellofresh.task1.model.Recipe
import com.hellofresh.task1.model.RecipeServices
import com.hellofresh.task1.model.Subscription
import com.hellofresh.task1.model.SubscriptionServices
import junit.framework.Assert.*
import org.junit.Before
import org.junit.Test

class MenuTest {

    private var recipeList: List<Recipe> = mutableListOf()
    private lateinit var subscription: Subscription
    private lateinit var recipeServices: RecipeServices
    private lateinit var subscriptionServices: SubscriptionServices
    private lateinit var menuManagerImpl: MenuManagerImpl
    private lateinit var menuManager: IMenuManager
    private lateinit var menu: Menu


    @Before
    fun setUP() {
        recipeList = mutableListOf(
            Recipe("1", "Lemon Rice", true, mutableListOf("fast")),
            Recipe("2", "Soup", true, mutableListOf("hot")),
            Recipe("3", "Chicken Rice", false, mutableListOf("hot")),
            Recipe("4", "Pasta", false, mutableListOf("hot")),
            Recipe("5", "Pizza", true, mutableListOf("hot"))
        )
        subscription = Subscription("1", "22/12/2020", true)
        recipeServices = RecipeServices()
        recipeServices.setRecipe(recipeList)
        subscriptionServices = SubscriptionServices()
        subscriptionServices.setSubscription(subscription)
        menuManagerImpl = MenuManagerImpl(recipeServices, subscriptionServices)
        menuManager = menuManagerImpl
        menu = Menu(menuManager)
    }

    @Test
    fun test_menu_setReceipes() {
        assertEquals(menu.getRecipes(), recipeList)
    }

    @Test
    fun test_selection_of_single_and_multiple_recipe() {
        menu.setSelected("1")
        assertEquals(3, menu.getSelectedCount())
        menu.setSelected(mutableListOf("1", "2"))
        assertEquals(2, menu.getSelectedCount())
    }

    @Test
    fun test_set_selection_single_item() {
        menu.setSelected("1")
        assertEquals(3, menu.getSelectedCount())
    }

    @Test
    fun test_set_selection_multiple_item() {
        val list_to_select = mutableListOf("1", "5")
        menu.setSelected(list_to_select)
        assertEquals(3, menu.getSelectedCount())
    }


    @Test
    fun test_get_receipes_with_tag() {
        assertEquals(4, menu.getRecipes("hot")?.size)
    }

    @Test
    fun test_de_select_single_item() {
        menu.setDeselected("2")
        assertEquals(2, menu.getSelectedCount())
    }

    @Test
    fun test_de_select_multiple_item() {
        val list_to_de_select = mutableListOf("1", "5")
        menu.setDeSelected(list_to_de_select)
        assertEquals(1, menu.getSelectedCount())
    }

}