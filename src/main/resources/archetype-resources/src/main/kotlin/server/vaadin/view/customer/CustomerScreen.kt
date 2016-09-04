#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
@file:JvmName("CustomerScreen")
package ${package}.server.vaadin.view.customer

import com.vaadin.navigator.ViewChangeListener
import com.vaadin.spring.annotation.SpringView
import com.vaadin.spring.annotation.UIScope
import com.vaadin.ui.*
import ${package}.server.dto.CustomerBean
import ${package}.server.service.AuthenticationService
import ${package}.server.vaadin.event.CustomerLogoutEvent
import ${package}.server.vaadin.view.AbstractScreen
import org.springframework.beans.factory.annotation.Autowired


/**
 * The type <code>CustomerScreen</code>.
 */
@UIScope
@SpringView(name = "CustomerScreen")
class CustomerScreen : AbstractScreen() {


    /**
     * The First Name
     */
    private var firstNameText: TextField = TextField()
    /**
     * The Last Name
     */
    private var lastNameText: TextField = TextField()

    private var popupLabel: Label = Label()

    private var logoutButton: Button = Button("LOGOUT")

    private var loginPopupView: PopupView = getLoginPopupView()

    /**
     * The `EventBus` eventBus.
     */
    @Autowired
    val authenticationService : AuthenticationService? = null


    /**
     * Instantiates a new <code>CustomerScreen</code>.
     *
     * @param authenticationService the <code>authenticationService</code> authentication service
     */
    init {
        var firstNameLayout: VerticalLayout = VerticalLayout()
        firstNameLayout.addComponent(Label("First Name"))
        firstNameLayout.addComponent(firstNameText)
        addComponent(firstNameLayout)
        var lastNameLayout: VerticalLayout = VerticalLayout()
        lastNameLayout.addComponent(Label("Last Name"))
        lastNameLayout.addComponent(lastNameText)
        addComponent(lastNameLayout)
        addComponent(logoutButton)
        addComponent(loginPopupView);
    }

    /**
     * Sets customer.
     *
     * @param customer the customer
     */
    fun setCustomer(customer: CustomerBean) {
        val (fn, lb, ci) = customer
        firstNameText.setValue(fn)
        lastNameText.setValue(lb)
        popupLabel.setValue("Connection ID : " + ci)
        loginPopupView.setPopupVisible(true)
        logoutButton.addClickListener  {
            authenticationService?.logoutCustomer(customer)
            eventBus?.fireEvent(CustomerLogoutEvent(customer))
        }
    }

    /**
     * This view is navigated to.
     * <p/>
     * This method is always called before the view is shown on screen.
     * {@link ViewChangeEvent#getParameters() event.getParameters()} may contain
     * extra parameters relevant to the view.
     *
     * @param event ViewChangeEvent representing the view change that is              occurring. {@link ViewChangeEvent#getNewView()
     *              event.getNewView()} returns <code>this</code>.
     */
    @Override
    override fun enter(event: ViewChangeListener.ViewChangeEvent) {

    }

    /**
     * Gets login popup panel.
     *
     * @return the login popup panel
     */
    private fun getLoginPopupView(): PopupView {
        var verticalLayout: VerticalLayout = VerticalLayout()
        verticalLayout.addComponent(popupLabel);
        val toReturn: PopupView = PopupView(null, verticalLayout);
        val button: Button = Button("Close")
        button.addClickListener { toReturn.setPopupVisible(false) }
        verticalLayout.addComponent(button)
        return toReturn
    }
}