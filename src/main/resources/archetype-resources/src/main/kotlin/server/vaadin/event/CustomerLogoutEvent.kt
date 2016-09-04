#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
@file:JvmName("CustomerLogoutEvent")
package ${package}.server.vaadin.event

import ${package}.server.dto.CustomerBean
import ${package}.server.vaadin.handler.CustomerLogoutHandler
import ${package}.server.vaadin.handler.Handler

/**
 * The type <code>CustomerLogoutEvent</code>.
 */
class CustomerLogoutEvent(var customer: CustomerBean) : Event () {

    override fun manage(handler: Handler) {
        when (handler) {
            is CustomerLogoutHandler -> {
                handler.handleCustomerLogoutEvent(this)
            }
        }
    }
}