package com.dai.en.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class Test {

    public static void main(String args[]) {
        testCGLIB();
    }

    public static void testJDK(){
        ServiceApi serviceApi = (ServiceApi)Proxy.newProxyInstance(ServiceApi.class.getClassLoader(),new Class[]{ServiceApi.class}, new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /**
                 *
                 */
                Annotation[] annotations = method.getAnnotations();
                for(Annotation annotation:annotations){
                    System.out.println(annotation.toString());
                }

                return null;
            }
        });

        System.out.println(serviceApi.getName());
    }

    /**
     * ��ע��Ľӿڷ���������ʵ��ʱ�������̳�
     * ������@Transactionע���Ƽ����෽���ϣ����ǽӿڷ����ϣ��ӽӿڷ�����ʱ��Ҫʹ��JDK�������Ч��
     * @Description
     */
    public static void testCGLIB(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ServiceApiImpl.class);
        enhancer.setCallback(new MethodInterceptor(){

            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
//                Object object = method.invoke(obj, args); //���ߵݹ��ػش˷�����
                Object object = proxy.invokeSuper(obj, args);
                return object;
            }

        });

        ServiceApiImpl serviceApiImpl = (ServiceApiImpl)enhancer.create();
//        System.out.println(serviceApiImpl.getMyName());
        System.out.println(serviceApiImpl.getName());
    }
}
