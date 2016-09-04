#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
@file:JvmName("Config")
package ${package}.server.spring;


import com.vaadin.spring.annotation.EnableVaadin;
import ${package}.server.vaadin.eventbus.EventBus;
import ${package}.server.vaadin.view.login.LoginView;
import ${package}.server.service.AuthenticationService;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * The type <code>Config</code>.
 */
@Configuration
@EnableVaadin
@PropertySource("classpath:application.properties")
@ComponentScan("${package}.server")
open class Config {


    /**
     * This is needed for @Value configuration to work properly
     *
     * @return property sources placeholder configurer
     */
    companion object {
        @Bean
        @JvmStatic open fun propertyPlaceholderConfigurer(): PropertySourcesPlaceholderConfigurer {
            return PropertySourcesPlaceholderConfigurer()
        }
    }


    /**
     * Gets authentication service.
     *
     * @return the authentication service
     */
    @Bean
    open fun getAuthenticationService(): AuthenticationService {
        return AuthenticationService()
    }

    /**
     * Gets event bus.
     *
     * @return the event bus
     */
    @Bean
    @Scope("prototype")
    open fun getEventBus(): EventBus {
        return EventBus()
    }

    /**
     * Gets login view.
     *
     * @return the login view
     */
    @Bean
    @Scope("prototype")
    open fun getLoginView(): LoginView {
        return LoginView(getAuthenticationService())
    }

}
