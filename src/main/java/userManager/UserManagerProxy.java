package userManager;

public class UserManagerProxy implements userManager.UserManager {
  private String _endpoint = null;
  private userManager.UserManager userManager = null;
  
  public UserManagerProxy() {
    _initUserManagerProxy();
  }
  
  public UserManagerProxy(String endpoint) {
    _endpoint = endpoint;
    _initUserManagerProxy();
  }
  
  private void _initUserManagerProxy() {
    try {
      userManager = (new userManager.UserManagerServiceLocator()).getUserManager();
      if (userManager != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)userManager)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)userManager)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (userManager != null)
      ((javax.xml.rpc.Stub)userManager)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public userManager.UserManager getUserManager() {
    if (userManager == null)
      _initUserManagerProxy();
    return userManager;
  }
  
  public boolean addUser(int id, java.lang.String password, java.lang.String lastName, java.lang.String firstName) throws java.rmi.RemoteException{
    if (userManager == null)
      _initUserManagerProxy();
    return userManager.addUser(id, password, lastName, firstName);
  }
  
  public boolean login(int id, java.lang.String password) throws java.rmi.RemoteException{
    if (userManager == null)
      _initUserManagerProxy();
    return userManager.login(id, password);
  }
  
  public java.lang.String getUserFullName(int id) throws java.rmi.RemoteException{
    if (userManager == null)
      _initUserManagerProxy();
    return userManager.getUserFullName(id);
  }
  
  
}