#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
@file:JvmName("Event")
package ${package}.server.vaadin.event

import ${package}.server.vaadin.handler.Handler

/**
 * Base Event object.

 * @param  abstract class extended by concrete events
 */
abstract class Event {


    /**
     * This is a method used primarily for debugging. It gives a string
     * representation of the event details. This does not override the toString
     * method because the compiler cannot always optimize toString out correctly.
     * Event types should override as desired.

     * @return a string representing the event's specifics.
     */
    fun toDebugString(): String {
        var name = this.javaClass.name
        name = name.substring(name.lastIndexOf(".") + 1)
        return "event: $name:"
    }

    /**
     * The toString() for abstract event is overridden to avoid accidently
     * including class literals in the compiled output. Use {@link Event}
     * #toDebugString to get more information about the event.
     *
     * @return the string
     */
    override fun toString() : String {
        return "An event type"
    }

    abstract fun manage(handler: Handler)

}
