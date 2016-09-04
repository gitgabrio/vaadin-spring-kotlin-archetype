#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
@file:JvmName("AuthenticationService")
package ${package}.server.service;

import ${package}.server.dto.CustomerBean;
import org.springframework.stereotype.Service
import java.util.*

/**
 * The type <code>AuthenticationService</code>.
 */
@Service
open class AuthenticationService {

    /**
     * Gets customer.

     * @param userName the user name
     * *
     * @param password the password
     * *
     * @return the customer
     */
    fun getCustomer(userName: String, password: String): CustomerBean? {
        fun validate(value: String, fieldName: String) {
            if (value.isEmpty()) {
                throw IllegalArgumentException("Can't return a Customer, null or empty $fieldName")
            }
        }
        validate(userName, "userName")
        validate(password, "password")
        val toReturn = CustomerBean("Scrooge", "McDuck", Date().toString())
        return toReturn
    }

    /**
     * Logout customer.

     * @param customer the customer
     */
    fun logoutCustomer(customer: CustomerBean) {

    }
}