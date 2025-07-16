package com.userservice.sahand.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

@Service
public class Remote {

    private static final Logger log = LoggerFactory.getLogger(Remote.class);

    public static Class<?> getClass(Class<?> className, String whatClass) throws Exception {
        if (className == null) {
            throw new IllegalArgumentException("Input class cannot be null");
        }

        try {
            String simpleName = className.getSimpleName();
            String packageName = className.getPackage().getName();
            String outClass;

            if (simpleName.endsWith("Service")) {
                outClass = simpleName.replace("Service", whatClass);
            } else if (simpleName.endsWith("Controller")) {
                outClass = simpleName.replace("Controller", whatClass);
            } else if (simpleName.endsWith("Form")) {
                outClass = simpleName.replace("Form", whatClass);
            }else if (simpleName.endsWith("Simple")) {
                outClass = simpleName.replace("Simple", whatClass);
            }
            else {
                throw new IllegalArgumentException("Class must end with 'Service' or 'Controller'");
            }

            String fullyQualified = packageName + "." + outClass;
            return Class.forName(fullyQualified);

        } catch (ClassNotFoundException e) {
            throw new Exception(whatClass + " for " + className.getName() + " not found");
        }
    }
    public static <T> T makeRemote(Class<T> clazz) throws Exception {
        String className = clazz.getSimpleName();
        String simpleName = className.replace("Interface", "");
        String serviceName = simpleName + "Service";
        String fullClassName = "com.userservice.sahand." + simpleName + "." + serviceName;
        Class<?> implClass = Class.forName(fullClassName);
        Object instance = SpringContextHelper.getContext().getBean(implClass);
        return clazz.cast(instance);
    }
    static WebApplicationContext context;

    public static Object getRemote(Class<?> form) throws Exception {
        String className = form.getSimpleName();
        String simpleName = className.replace("Interface", "");
        String serviceName = simpleName + "Service";
        String fullClassName = "com.userservice.sahand." + simpleName + "." + serviceName;

        System.out.println("Attempting to load: " + fullClassName);

        Class<?> implClass = Class.forName(fullClassName);

        ApplicationContext ctx = SpringContextHelper.getContext();
        if (ctx == null) {
            throw new IllegalStateException("Spring context is not initialized");
        }

        Object instance = ctx.getBean(implClass);
        if (instance == null) {
            throw new IllegalStateException("No bean found for class: " + fullClassName);
        }

        return form.cast(instance);
    }

}
