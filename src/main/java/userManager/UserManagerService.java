/**
 * UserManagerService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package userManager;

public interface UserManagerService extends javax.xml.rpc.Service {
    public java.lang.String getUserManagerAddress();

    public userManager.UserManager getUserManager() throws javax.xml.rpc.ServiceException;

    public userManager.UserManager getUserManager(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
