package com.hellofresh.task1.model

/**
 *Created by ramavijayapandian on 9/4/21.
 **/

data class Subscription(
    var id: String?,
    var deliveryDay: String?,
    var isForFamily: Boolean
)

class SubscriptionServices {
    private lateinit var subscription: Subscription

    fun setSubscription(subscription: Subscription) {
        this.subscription = subscription
    }

    fun getSubscription(): Subscription {
        return subscription
    }
}
