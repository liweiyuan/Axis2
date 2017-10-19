package com.tingyun.client;

import com.tingyun.axis2.HelloWorldStub;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by tingyun on 2017/10/19.
 */
@WebServlet("/stub2")
public class StubClient2 extends HttpServlet{

    public static void main(String[] args) throws AxisFault {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HelloWorldStub helloWorldStub=new HelloWorldStub();
        Options options=helloWorldStub._getServiceClient().getOptions();
        String urlpre=request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + request.getContextPath();

        urlpre+="/services/HelloWorld.HelloWorldHttpSoap12Endpoint/";
        EndpointReference endpointReference=new EndpointReference(urlpre);
        options.setTo(endpointReference);
        helloWorldStub._getServiceClient().setOptions(options);

        HelloWorldStub.GetHelloWorldResponse helloResponse=helloWorldStub.getHelloWorld();
        response.getWriter().println(helloResponse);

    }
}
