#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
@file:JvmName("MyWebAppInitializer")
package ${package}.server.spring

import com.vaadin.spring.server.SpringVaadinServlet
import org.springframework.web.WebApplicationInitializer
import org.springframework.web.context.ContextLoaderListener
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import javax.servlet.ServletContext
import javax.servlet.ServletException

/**
 * The type <code>MyWebAppInitializer</code>.
 */
class MyWebAppInitializer : WebApplicationInitializer {

    @Throws(ServletException::class)
    override fun onStartup(servletContext: javax.servlet.ServletContext) {
        val context = AnnotationConfigWebApplicationContext()
        context.register(Config::class.java)
        servletContext.addListener(ContextLoaderListener(context))
        registerServlet(servletContext)
    }

    private fun registerServlet(servletContext: ServletContext) {
        val dispatcher = servletContext.addServlet("vaadin", SpringVaadinServlet::class.java)
        dispatcher.setLoadOnStartup(1)
        dispatcher.addMapping("/*")
    }

}
