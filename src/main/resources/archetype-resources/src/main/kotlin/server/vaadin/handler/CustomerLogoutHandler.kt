#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
@file:JvmName("CustomerLogoutHandler")
package ${package}.server.vaadin.handler

import ${package}.server.vaadin.event.CustomerLogoutEvent

/**
 * The type <code>CustomerLogoutHandler</code>
 */
interface CustomerLogoutHandler : Handler {

    fun handleCustomerLogoutEvent(event: CustomerLogoutEvent)
}