package org.example.server;

import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class EmbeddedServer {
    public void start() throws Exception {

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.scan("org.example.configurations");

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        StandardContext ctx = (StandardContext) tomcat.addContext("", null);
        Tomcat.addServlet(ctx, "dispatcher", new DispatcherServlet(context)).setLoadOnStartup(1);
        ctx.addServletMappingDecoded("/", "dispatcher");

        context.setServletContext(ctx.getServletContext());
        context.refresh();

        System.out.println("Embedded Tomcat running at port: 8080");
        tomcat.start();
        tomcat.getServer().await();
    }
}
