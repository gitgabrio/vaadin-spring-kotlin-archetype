#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
@file:JvmName("CustomerLoginEvent")
package ${package}.server.vaadin.handler

import ${package}.server.vaadin.event.CustomerLoginEvent

/**
 * The type <code>CustomerLoginHandler</code>
 */
interface CustomerLoginHandler : Handler {

    fun handleCustomerLoginEvent(event: CustomerLoginEvent)

}