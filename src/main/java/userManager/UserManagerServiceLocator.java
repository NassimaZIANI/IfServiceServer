/**
 * UserManagerServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package userManager;

public class UserManagerServiceLocator extends org.apache.axis.client.Service implements userManager.UserManagerService {

    public UserManagerServiceLocator() {
    }


    public UserManagerServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public UserManagerServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for UserManager
    private java.lang.String UserManager_address = "http://localhost:8080/UserManager/services/UserManager";

    public java.lang.String getUserManagerAddress() {
        return UserManager_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String UserManagerWSDDServiceName = "UserManager";

    public java.lang.String getUserManagerWSDDServiceName() {
        return UserManagerWSDDServiceName;
    }

    public void setUserManagerWSDDServiceName(java.lang.String name) {
        UserManagerWSDDServiceName = name;
    }

    public userManager.UserManager getUserManager() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(UserManager_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getUserManager(endpoint);
    }

    public userManager.UserManager getUserManager(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            userManager.UserManagerSoapBindingStub _stub = new userManager.UserManagerSoapBindingStub(portAddress, this);
            _stub.setPortName(getUserManagerWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setUserManagerEndpointAddress(java.lang.String address) {
        UserManager_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (userManager.UserManager.class.isAssignableFrom(serviceEndpointInterface)) {
                userManager.UserManagerSoapBindingStub _stub = new userManager.UserManagerSoapBindingStub(new java.net.URL(UserManager_address), this);
                _stub.setPortName(getUserManagerWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("UserManager".equals(inputPortName)) {
            return getUserManager();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://userManager", "UserManagerService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://userManager", "UserManager"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("UserManager".equals(portName)) {
            setUserManagerEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
