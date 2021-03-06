
package org.qualipso.factory.greeting.client.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "greeting", targetNamespace = "http://org.qualipso.factory.ws/service/greeting")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Greeting {


    /**
     * 
     * @param arg1
     * @param arg0
     * @throws GreetingServiceException_Exception
     */
    @WebMethod
    public void createName(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1)
        throws GreetingServiceException_Exception
    ;

    /**
     * 
     * @param arg0
     * @throws GreetingServiceException_Exception
     */
    @WebMethod
    public void deleteName(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws GreetingServiceException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns org.qualipso.factory.greeting.client.ws.FactoryResource
     * @throws FactoryException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    public FactoryResource findResource(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws FactoryException_Exception
    ;

    /**
     * 
     * @return
     *     returns org.qualipso.factory.greeting.client.ws.StringArray
     */
    @WebMethod
    @WebResult(partName = "return")
    public StringArray getResourceTypeList();

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    public String getServiceName();

    /**
     * 
     * @param arg0
     * @return
     *     returns org.qualipso.factory.greeting.client.ws.Name
     * @throws GreetingServiceException_Exception
     */
    @WebMethod
    @WebResult(name = "name", partName = "name")
    public Name readName(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws GreetingServiceException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     * @throws GreetingServiceException_Exception
     */
    @WebMethod
    @WebResult(name = "message", partName = "message")
    public String sayHello(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws GreetingServiceException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @throws GreetingServiceException_Exception
     */
    @WebMethod
    public void updateName(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1)
        throws GreetingServiceException_Exception
    ;

}
