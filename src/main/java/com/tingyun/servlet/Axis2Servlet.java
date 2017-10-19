package com.tingyun.servlet;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import java.io.IOException;

/**
 * Created by tingyun on 2017/10/19.
 */
public class Axis2Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "http://127.0.0.1:8080/services/HelloWorld";
        String result = null;
        //使用RPC方式调用WebService
        RPCServiceClient serviceClient=new RPCServiceClient();
        Options options=serviceClient.getOptions();

        // 指定调用WebService的URL
        EndpointReference endpointReference=new EndpointReference(url);
        options.setTo(endpointReference);
        // 在创建QName对象时，QName类的构造方法的第一个参数表示WSDL文件的命名空间名，
        // 也就是<wsdl:definitions>元素的targetNamespace属性值
        // 指定要调用的getWorld方法及WSDL文件的命名空间.....
        options.setAction("getWorld");
        QName opAddEntry = new QName("http://tingyun.com", "getWorld");
        // 指定getGreeting方法的参数值，如果有多个，继续往后面增加即可，不用指定参数的名称
        Object[] opAddEntryArgs=new Object[]{"java"};
        //返回参数类型，这个和axis1有点区别
// invokeBlocking方法有三个参数，其中第一个参数的类型是QName对象，表示要调用的方法名；
// 第二个参数表示要调用的WebService方法的参数值，参数类型为Object[]；
// 第三个参数表示WebService方法的返回值类型的Class对象，参数类型为Class[]。
// 当方法没有参数时，invokeBlocking方法的第二个参数值不能是null，而要使用new Object[]{}
// 如果被调用的WebService方法没有返回值，应使用RPCServiceClient类的invokeRobust方法，
// 该方法只有两个参数，它们的含义与invokeBlocking方法的前两个参数的含义相同
// 指定getGreeting方法返回值的数据类型的Class对象.....
        Class[] classes = new Class[] { String.class };
// 调用getGreeting方法并输出该方法的返回值.......
        result = (String) serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0];
        System.out.println(result);

        response.getWriter().println(result);
    }
}
