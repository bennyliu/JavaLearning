package com.homework2.base;

import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionProxyFactory;
import junit.framework.TestCase;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.Dispatcher;
import org.apache.struts2.views.JspSupportServlet;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.ContextLoader;

import java.util.HashMap;

public  class BaseSpringTestCase extends TestCase {
    private static final String CONFIG_LOCATIONS = "applicationContext.xml";
    private static ApplicationContext applicationContext;
    private Dispatcher dispatcher;
    protected ActionProxy proxy;
    protected static MockServletContext servletContext;
    protected static MockServletConfig servletConfig;
    protected MockHttpServletRequest request;
    protected MockHttpServletResponse response;
    protected HashMap params = new HashMap();
    protected void setParam(String name,String value) {
        params.put(name, value);
    }


    public BaseSpringTestCase(String name) {
        super(name);
    }

    @SuppressWarnings("unchecked")
    protected <T> T createAction(Class<T> clazz, String namespace, String name)
            throws Exception {

        proxy = dispatcher.getContainer().getInstance(ActionProxyFactory.class)
                .createActionProxy(namespace, name, null, true, false);

        // by default, don't pass in any request parameters
        proxy.getInvocation().getInvocationContext()
                .setParameters(new HashMap());

        // do not execute the result after executing the action
        proxy.setExecuteResult(true);

        // set the actions context to the one which the proxy is using
        ServletActionContext.setContext(proxy.getInvocation()
                .getInvocationContext());
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        ServletActionContext.setRequest(request);
        ServletActionContext.setResponse(response);
        ServletActionContext.setServletContext(servletContext);
        return (T) proxy.getAction();
    }
    @Before
    protected void setUp() throws Exception {
        if (applicationContext == null) {
            // this is the first time so initialize Spring context
            servletContext = new MockServletContext();
            servletContext.addInitParameter(
                    ContextLoader.CONFIG_LOCATION_PARAM, CONFIG_LOCATIONS);
            applicationContext = (new ContextLoader())
                    .initWebApplicationContext(servletContext);

            // Struts JSP support servlet (for Freemarker)
            new JspSupportServlet().init(new MockServletConfig(servletContext));
        }
        dispatcher = new Dispatcher(servletContext, params);
        dispatcher.init();
        Dispatcher.setInstance(dispatcher);
    }
}