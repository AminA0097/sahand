package com.userservice.sahand.Utils;

public class Remote {

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
            } else {
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
    public Class<?> copyToEntity(Class<?> form)throws Exception{
        return null;
    }
}
