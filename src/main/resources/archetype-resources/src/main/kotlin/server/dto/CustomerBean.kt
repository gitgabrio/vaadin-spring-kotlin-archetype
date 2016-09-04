#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
@file:JvmName("CustomerBean")
package ${package}.server.dto;

/**
 * The type <code>CustomerBean</code>.
 */
data class CustomerBean(var firstName: String, var lastName: String, var connectionId: String)