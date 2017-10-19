package com.tingyun.client;

import com.tingyun.axis2.HelloWorldStub;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by tingyun on 2017/10/19.
 */
@WebServlet("/stub")
public class StubClient extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String urlpre=request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + request.getContextPath();

        HelloWorldStub helloWorldStub=new HelloWorldStub(urlpre+"/services/HelloWorld.HelloWorldHttpSoap12Endpoint/");
        HelloWorldStub.GetWorld getWorld=new HelloWorldStub.GetWorld();
        getWorld.setName("world");
        String result=helloWorldStub.getWorld(getWorld).get_return();
        response.getWriter().println(result);
        response.getWriter().println(request);
    }
}
