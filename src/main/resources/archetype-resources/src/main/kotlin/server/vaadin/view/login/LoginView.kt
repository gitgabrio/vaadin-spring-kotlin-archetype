#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
@file:JvmName("LoginView")
package ${package}.server.vaadin.view.login

import com.vaadin.ui.Button
import com.vaadin.ui.Label
import com.vaadin.ui.PasswordField
import com.vaadin.ui.TextField
import ${package}.server.dto.CustomerBean
import ${package}.server.service.AuthenticationService
import ${package}.server.vaadin.event.CustomerLoginEvent

/**
 * The type <code>LoginView</code>.
 */
class LoginView(authenticationService: AuthenticationService) : AbstractLoginLayout(authenticationService) {

    /**
     * The User input.
     */
    private val userInput: TextField = TextField()

    private val passwordInput: PasswordField = PasswordField()

    init {
        addComponent(Label("UserName"))
        addComponent(userInput)
        addComponent(Label("Password"))
        addComponent(passwordInput)
        addComponent(getLoginButton())
    }

    /**
     * Gets login button.

     * @return the login button
     */
    private fun getLoginButton(): Button {
        val toReturn = Button("LOGIN")
        toReturn.addClickListener {
            val customer: CustomerBean? = authenticationService.getCustomer(userInput.value, passwordInput.value)
            eventBus?.fireEvent(CustomerLoginEvent(customer!!))
        }
        return toReturn
    }

}
