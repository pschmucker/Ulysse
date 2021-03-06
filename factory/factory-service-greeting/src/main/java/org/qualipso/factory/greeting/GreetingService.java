package org.qualipso.factory.greeting;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.qualipso.factory.FactoryNamingConvention;
import org.qualipso.factory.FactoryService;
import org.qualipso.factory.greeting.entity.Name;
import org.qualipso.factory.membership.MembershipServiceException;
import org.qualipso.factory.notification.NotificationServiceException;
import org.qualipso.factory.indexing.IndexableDocument;
import org.qualipso.factory.indexing.IndexableService;
import org.qualipso.factory.indexing.IndexingServiceException;

/**
 * @author Jerome Blanchard (jayblanc@gmail.com)
 * @date 11 june 2009
 */
@Remote
@WebService(name = GreetingService.SERVICE_NAME, targetNamespace = FactoryNamingConvention.SERVICE_NAMESPACE + GreetingService.SERVICE_NAME)
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface GreetingService extends FactoryService, IndexableService{

    public static final String SERVICE_NAME = "greeting";
    public static final String[] RESOURCE_TYPE_LIST = new String[] { Name.RESOURCE_NAME };

    @WebMethod
    public void createName(String path, String name) throws GreetingServiceException;

    @WebMethod
    @WebResult(name = "name")
    public Name readName(String path) throws GreetingServiceException;

    @WebMethod
    public void updateName(String path, String name) throws GreetingServiceException;

    @WebMethod
    public void deleteName(String path) throws GreetingServiceException;

    @WebMethod
    @WebResult(name = "message")
    public String sayHello(String path) throws GreetingServiceException;

    @WebMethod
    @WebResult(name = "name")
    public void throwNullEvent() throws NotificationServiceException;

    @WebMethod
    @WebResult(name = "name")
    public void throw2SameEvent(String path) throws NotificationServiceException, MembershipServiceException;

    @WebMethod
    @WebResult(name = "name")
    public void throwFacticeEvent() throws NotificationServiceException;
    
    @WebMethod
    @WebResult(name = "name")
    public IndexableDocument getIndexableDocument(String path) throws IndexingServiceException;


}
