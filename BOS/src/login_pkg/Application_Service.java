/**
 * Application_Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package login_pkg;

public interface Application_Service extends javax.xml.rpc.Service {
    public java.lang.String getApplicationAddress();

    public login_pkg.Application_PortType getApplication() throws javax.xml.rpc.ServiceException;

    public login_pkg.Application_PortType getApplication(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
