#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
@file:JvmName("${artifactId}Servlet")
package ${package}.server.servlet;

import com.vaadin.annotations.VaadinServletConfiguration
import com.vaadin.spring.server.SpringVaadinServlet
import ${package}.server.vaadin.view.Main
import javax.servlet.annotation.WebServlet

/**
 * The type <code>${artifactId}Servlet</code>.
 */
@WebServlet(urlPatterns = arrayOf("/*"), name = "${artifactId}Servlet", asyncSupported = true)
@VaadinServletConfiguration(ui = Main :: class, productionMode = false)
open class ${artifactId}Servlet : SpringVaadinServlet() {


}