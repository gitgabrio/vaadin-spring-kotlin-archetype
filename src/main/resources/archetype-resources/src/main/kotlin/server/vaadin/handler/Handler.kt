#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
@file:JvmName("Handler")
package ${package}.server.vaadin.handler

import ${package}.server.vaadin.event.Event
import java.util.*

/**
 * The interface <code>Handler</code>
 */
interface Handler : Observer {


    /**
     * This method is called whenever the observed object is changed. An
     * application calls an Observable object's
     * `notifyObservers` method to have all the object's
     * observers notified of the change.

     * @param o   the observable object.
     * *
     * @param arg an argument passed to the `notifyObservers`
     */
    override fun update(o: Observable, arg: Any) {
        when (arg) {
            is Event -> {
                arg.manage(this)
            }
        }
    }
}
