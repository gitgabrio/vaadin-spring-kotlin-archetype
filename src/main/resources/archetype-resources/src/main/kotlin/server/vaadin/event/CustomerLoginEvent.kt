#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
@file:JvmName("CustomerLoginEvent")
package ${package}.server.vaadin.event

import ${package}.server.dto.CustomerBean
import ${package}.server.vaadin.handler.CustomerLoginHandler
import ${package}.server.vaadin.handler.Handler

/**
 * The type <code>CustomerLoginEvent</code>.
 */
class CustomerLoginEvent(var customer: CustomerBean) : Event() {

    override fun manage(handler: Handler) {
        when (handler) {
            is CustomerLoginHandler -> {
                handler.handleCustomerLoginEvent(this)
            }
        }
    }


}