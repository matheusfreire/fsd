package login_pkg;

public class ApplicationProxy implements login_pkg.Application_PortType {
  private String _endpoint = null;
  private login_pkg.Application_PortType application_PortType = null;
  
  public ApplicationProxy() {
    _initApplicationProxy();
  }
  
  public ApplicationProxy(String endpoint) {
    _endpoint = endpoint;
    _initApplicationProxy();
  }
  
  private void _initApplicationProxy() {
    try {
      application_PortType = (new login_pkg.Application_ServiceLocator()).getApplication();
      if (application_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)application_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)application_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (application_PortType != null)
      ((javax.xml.rpc.Stub)application_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public login_pkg.Application_PortType getApplication_PortType() {
    if (application_PortType == null)
      _initApplicationProxy();
    return application_PortType;
  }
  
  public java.lang.Boolean login(java.lang.String temp_login, java.lang.String temp_password) throws java.rmi.RemoteException{
    if (application_PortType == null)
      _initApplicationProxy();
    return application_PortType.login(temp_login, temp_password);
  }
  
  
}