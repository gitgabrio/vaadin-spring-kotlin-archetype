#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
@file:JvmName("Main")

package ${package}.server.vaadin.view

import com.vaadin.annotations.Theme
import com.vaadin.annotations.Widgetset
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.Label
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout
import ${package}.server.dto.CustomerBean
import ${package}.server.vaadin.event.CustomerLoginEvent
import ${package}.server.vaadin.event.CustomerLogoutEvent
import ${package}.server.vaadin.eventbus.EventBus
import ${package}.server.vaadin.handler.CustomerLoginHandler
import ${package}.server.vaadin.handler.CustomerLogoutHandler
import ${package}.server.vaadin.view.customer.CustomerScreen
import ${package}.server.vaadin.view.login.LoginScreen
import org.springframework.beans.factory.annotation.Autowired
import javax.annotation.PostConstruct

/**
 * The type <code>Main</code>.
 */
@Theme("mytheme")
@Widgetset("${package}.${artifactId}Widgetset")
@SpringUI
class Main : UI(), CustomerLoginHandler, CustomerLogoutHandler {


    /**
     * The `EventBus` eventBus.
     */
    @Autowired
    val eventBus: EventBus? = null


    /**
     * The LoginScreen.
     */
    @Autowired
    val loginScreen: LoginScreen? = null

    /**
     * The CustomerScreen.
     */
    @Autowired
    val customerScreen: CustomerScreen? = null

    /**
     * The `VerticalLayout` verticalLayout.
     */
    private val verticalLayout = VerticalLayout()

    @PostConstruct
    fun init() {
        eventBus!!.addObserver(this)
        loginScreen!!.setBus(eventBus)
        customerScreen!!.eventBus = eventBus
    }

    override fun init(request: VaadinRequest?) {
        getPage().setTitle("${artifactId}");
        verticalLayout.setMargin(true)
        val label = Label("Vaadin Spring Kotlin Model")
        verticalLayout.addComponent(label)
        setLoginScreen()
        setContent(verticalLayout)
    }

    override fun handleCustomerLoginEvent(event: CustomerLoginEvent) {
        setCustomerScreen(event.customer)  }


    override fun handleCustomerLogoutEvent(event: CustomerLogoutEvent) {
        setLoginScreen()
    }

    /**
     * Sets login screen.
     */
    private fun setLoginScreen() {
        verticalLayout.removeComponent(customerScreen)
        verticalLayout.addComponent(loginScreen)
    }

    /**
     * Sets customer screen.

     * @param customer the customer
     */
    private fun setCustomerScreen(customer: CustomerBean) {
        verticalLayout.removeComponent(loginScreen)
        verticalLayout.addComponent(customerScreen)
        customerScreen!!.setCustomer(customer)
    }
}