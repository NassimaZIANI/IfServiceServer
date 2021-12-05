/**
 * Bank.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Bank;

public interface Bank extends java.rmi.Remote {
    public boolean withdrawalOf(int id, double amount) throws java.rmi.RemoteException;
    public void depositOf(int id, double amount) throws java.rmi.RemoteException;
    public double balanceValue(int id) throws java.rmi.RemoteException;
}
