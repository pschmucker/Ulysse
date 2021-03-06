
package org.qualipso.factory.bugtracker.client.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "bugtracker", targetNamespace = "http://org.qualipso.factory.ws/service/bugtracker")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Bugtracker {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     * @throws BugTrackerServiceException_Exception
     */
    @WebMethod
    @WebResult(name = "path", partName = "path")
    public String createIssue(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        IssueDto arg1)
        throws BugTrackerServiceException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @throws BugTrackerServiceException_Exception
     */
    @WebMethod
    public void deleteIssue(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1)
        throws BugTrackerServiceException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns org.qualipso.factory.bugtracker.client.ws.FactoryResource
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
     * @param arg0
     * @return
     *     returns org.qualipso.factory.bugtracker.client.ws.IssueDtoArray
     * @throws BugTrackerServiceException_Exception
     */
    @WebMethod
    @WebResult(name = "issue", partName = "issue")
    public IssueDtoArray getAllIssues(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws BugTrackerServiceException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns org.qualipso.factory.bugtracker.client.ws.IssueDto
     * @throws BugTrackerServiceException_Exception
     */
    @WebMethod
    @WebResult(name = "issue", partName = "issue")
    public IssueDto getIssue(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1)
        throws BugTrackerServiceException_Exception
    ;

    /**
     * 
     * @return
     *     returns org.qualipso.factory.bugtracker.client.ws.IssueAttributesDto
     * @throws BugTrackerServiceException_Exception
     */
    @WebMethod
    @WebResult(name = "issueAttributes", partName = "issueAttributes")
    public IssueAttributesDto getIssueAttributes()
        throws BugTrackerServiceException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns org.qualipso.factory.bugtracker.client.ws.IssueDtoArray
     * @throws BugTrackerServiceException_Exception
     */
    @WebMethod
    @WebResult(name = "issue", partName = "issue")
    public IssueDtoArray getModifiedIssues(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        XMLGregorianCalendar arg1)
        throws BugTrackerServiceException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns org.qualipso.factory.bugtracker.client.ws.IssueDtoArray
     * @throws BugTrackerServiceException_Exception
     */
    @WebMethod
    @WebResult(name = "issue", partName = "issue")
    public IssueDtoArray getNewIssues(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        XMLGregorianCalendar arg1)
        throws BugTrackerServiceException_Exception
    ;

    /**
     * 
     * @return
     *     returns org.qualipso.factory.bugtracker.client.ws.StringArray
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
     * @throws BugTrackerServiceException_Exception
     */
    @WebMethod
    public void updateIssue(
        @WebParam(name = "arg0", partName = "arg0")
        IssueDto arg0)
        throws BugTrackerServiceException_Exception
    ;

}
