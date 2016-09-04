#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
@file:JvmName("EventBus")
package ${package}.server.vaadin.eventbus

import ${package}.server.vaadin.event.Event
import java.util.*

/**
 * The type `EventBus`.
 */
class EventBus : Observable() {

    /**
     * Fire event.

     * @param toFire the to fire
     */
    fun fireEvent(toFire: Event) {
        super.setChanged()
        notifyObservers(toFire)
    }

}