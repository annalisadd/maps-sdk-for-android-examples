/*
 * Copyright (c) 2015-2020 TomTom N.V. All rights reserved.
 *
 * This software is the proprietary copyright of TomTom N.V. and its subsidiaries and may be used
 * for internal evaluation purposes or commercial use strictly subject to separate licensee
 * agreement between you and TomTom. If you are the licensee, you are only permitted to use
 * this Software in accordance with the terms of your license agreement. If you are not the
 * licensee then you are not authorised to use this software in any manner and should
 * immediately return it to TomTom N.V.
 */

package com.tomtom.online.sdk.samples.ktx.cases.route.alternatives

import android.app.Application
import com.tomtom.online.sdk.routing.data.RouteQuery
import com.tomtom.online.sdk.routing.data.RouteQueryBuilder
import com.tomtom.online.sdk.samples.ktx.cases.route.RouteViewModel
import com.tomtom.online.sdk.samples.ktx.utils.routes.AmsterdamToRotterdamRouteConfig

class RouteAlternativesViewModel(application: Application) : RouteViewModel(application) {

    fun planRouteWithOneAlternative() {
        planRoute(ONE_ALTERNATIVE)
    }

    fun planRouteWithThreeAlternatives() {
        planRoute(THREE_ALTERNATIVES)
    }

    fun planRouteWithFiveAlternatives() {
        planRoute(FIVE_ALTERNATIVES)
    }

    private fun planRoute(alternatives: Int) {
        val routeQuery = prepareRouteQuery(alternatives)
        planRoute(routeQuery)
    }

    private fun prepareRouteQuery(maxAlternatives: Int): RouteQuery {
        val origin = AmsterdamToRotterdamRouteConfig().origin
        val destination = AmsterdamToRotterdamRouteConfig().destination
        //tag::doc_route_alternatives[]
        val routeQuery = RouteQueryBuilder.create(origin, destination)
                .withMaxAlternatives(maxAlternatives)
                .withConsiderTraffic(false)
                .build()
        //end::doc_route_alternatives[]
        return routeQuery
    }

    companion object {
        const val ONE_ALTERNATIVE = 1
        const val THREE_ALTERNATIVES = 3
        const val FIVE_ALTERNATIVES = 5
    }

}