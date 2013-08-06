/**
 * Application_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package usermanager;

public interface Application_PortType extends java.rmi.Remote {
    public java.math.BigInteger add_user(loan.services.User user) throws java.rmi.RemoteException;
    public java.math.BigInteger make_a_loan(java.math.BigInteger book_id, java.math.BigInteger user_rb) throws java.rmi.RemoteException;
    public java.math.BigInteger return_a_loan(java.math.BigInteger book_id) throws java.rmi.RemoteException;
}
