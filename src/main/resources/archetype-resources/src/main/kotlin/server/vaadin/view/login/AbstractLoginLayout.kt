#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
@file:JvmName("AbstractLoginLayout")
package ${package}.server.vaadin.view.login

import com.vaadin.ui.VerticalLayout
import ${package}.server.service.AuthenticationService
import ${package}.server.vaadin.eventbus.EventBus

/**
 * The type <code>AbstractLoginLayout</code>.
 */
abstract class AbstractLoginLayout(val authenticationService : AuthenticationService) : VerticalLayout() {

    var eventBus : EventBus? = null
}
