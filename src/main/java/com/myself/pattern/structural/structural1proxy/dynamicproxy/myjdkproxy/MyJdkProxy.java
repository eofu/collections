package com.myself.pattern.structural.structural1proxy.dynamicproxy.myjdkproxy;

public class MyJdkProxy {
    private static final String LN = "/r/n";
    private MyInvocationHandler myInvocationHandler;

    private static String generateSrc(Class<?>[] myInterfaces) {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("package com.myself.pattern4proxy.dynamicproxy.myjdkproxy;" + LN);
        stringBuffer.append("public class $Proxy0 implements " + getInterfaceName(myInterfaces) + "{" + LN);



        stringBuffer.append("}");

        return null;
    }

    private static String getInterfaceName(Class<?>[] myInterfaces) {
        String myInterfaceName = "";
        for (int i = 0; i < myInterfaces.length; i++) {
            String name = myInterfaces[i].getName();
            if (i != myInterfaces.length - 1) {
                myInterfaceName += name + ",";
            }
        }
        return myInterfaceName;
    }

    public Object newProxyInstance(MyClassLoader classloader, Class<?>[] myInterfaces, MyInvocationHandler myInvocationHandler) {

        // 1、生成java文件
        generateSrc(myInterfaces);
        // 2、输出磁盘
        // 3、编译java文件
        // 4、加载.class文件到JVM
        // 5、返回字节码重组以后的代理对象

        return null;
    }
}
