
/**
 * HelloWorldCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

    package com.tingyun.axis2;

    /**
     *  HelloWorldCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class HelloWorldCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public HelloWorldCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public HelloWorldCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getWorld method
            * override this method for handling normal response from getWorld operation
            */
           public void receiveResultgetWorld(
                    HelloWorldStub.GetWorldResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getWorld operation
           */
            public void receiveErrorgetWorld(Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getHello method
            * override this method for handling normal response from getHello operation
            */
           public void receiveResultgetHello(
                    HelloWorldStub.GetHelloResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getHello operation
           */
            public void receiveErrorgetHello(Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getHelloWorld method
            * override this method for handling normal response from getHelloWorld operation
            */
           public void receiveResultgetHelloWorld(
                    HelloWorldStub.GetHelloWorldResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getHelloWorld operation
           */
            public void receiveErrorgetHelloWorld(Exception e) {
            }
                


    }
    