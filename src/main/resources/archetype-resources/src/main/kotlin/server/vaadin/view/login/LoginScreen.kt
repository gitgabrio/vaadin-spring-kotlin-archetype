#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
@file:JvmName("LoginScreen")
package ${package}.server.vaadin.view.login

import com.vaadin.navigator.ViewChangeListener
import com.vaadin.spring.annotation.SpringView
import com.vaadin.spring.annotation.UIScope
import ${package}.server.vaadin.eventbus.EventBus
import ${package}.server.vaadin.view.AbstractScreen
import org.springframework.beans.factory.annotation.Autowired

/**
 * The type <code>LoginScreen</code>.
 */
@UIScope
@SpringView(name = "LoginScreen")
class LoginScreen @Autowired constructor(val loginView : LoginView) : AbstractScreen() {


    init {
        addComponent(loginView)
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
    override fun enter(event: ViewChangeListener.ViewChangeEvent?) {
    }

    fun setBus(eventBus : EventBus) {
        super.eventBus = eventBus
        loginView.eventBus = eventBus
    }


}
