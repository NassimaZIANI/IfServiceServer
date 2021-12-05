/**
 * UserManager.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package userManager;

public interface UserManager extends java.rmi.Remote {
    public boolean addUser(int id, java.lang.String password, java.lang.String lastName, java.lang.String firstName) throws java.rmi.RemoteException;
    public java.lang.String getUserFullName(int id) throws java.rmi.RemoteException;
    public boolean login(int id, java.lang.String password) throws java.rmi.RemoteException;
}
