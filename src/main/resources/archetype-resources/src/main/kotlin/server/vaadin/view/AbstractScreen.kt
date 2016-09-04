#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
@file:JvmName("AbstractScreen")
package ${package}.server.vaadin.view

import com.vaadin.navigator.View
import com.vaadin.ui.HorizontalLayout
import ${package}.server.vaadin.eventbus.EventBus

/**
 * The type `AbstractScreen`.
 */
abstract class AbstractScreen : HorizontalLayout(), View {

    /**
     * The `EventBus` eventBus.
     */
    var eventBus: EventBus? = null


}
