package ifService;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import javax.xml.rpc.ServiceException;

import com.currencysystem.webservices.currencyserver.CurncsrvReturnRate;
import com.currencysystem.webservices.currencyserver.CurrencyServerLocator;
import com.currencysystem.webservices.currencyserver.CurrencyServerSoap;

import Bank.Bank;
import Bank.BankServiceLocator;
import Bank.BankSoapBindingStub;
import Common.IIfShare;
import Common.IProduct;
import userManager.UserManager;
import userManager.UserManagerServiceLocator;

public class IfService {
	
	IIfShare service;
	Bank bankService;
	UserManager userManager;
	List<IProduct> products;

	public IfService() throws ServiceException, RemoteException, UnknownHostException, NotBoundException {
		// connection to IfShare service
		String ip = Inet4Address.getLocalHost().getHostAddress();
		if (ip == null || ip == "") {
			ip = "localhost";
		}
		Registry r2 = LocateRegistry.getRegistry(ip, 1709);
		service = (IIfShare) r2.lookup("//" + ip + "/IFShareService");
				
		// get Bank service
		bankService = new BankServiceLocator().getBank();
		((BankSoapBindingStub)bankService).setMaintainSession(true);
		
		// get userManager service
		userManager = new UserManagerServiceLocator().getUserManager();
	}
	
	public double balanceValue(int id) throws RemoteException {
		return bankService.balanceValue(id);
	}
	
	public String login(int id, String password) throws RemoteException {
		boolean user = userManager.login(id, password);
		if (user == false) {
			return null;
		}
		return "Welcome : " + userManager.getUserFullName(id);
	}
	
	public boolean signUp(int id, String password, String firstName, String lastName) throws RemoteException {
		boolean user = userManager.addUser(id, password, lastName, firstName);
		if (user) {
			bankService.depositOf(id, 1500.0);
		}
		return user;
	}
	
	public String[] getAllProduct() throws RemoteException {
		products = service.getSoldProduct();
		String[] tabProducts = new String[products.size()];
		for(int i = 0; i < products.size(); i++) {
			tabProducts[i] = products.get(i).getId();
		}
		return tabProducts;
	}
	
	public String getType(String id) throws RemoteException {
		String type = null;
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getId().equals(id))
				type = products.get(i).getType();
		}
		return type;
	}
	
	public String getName(String id) throws RemoteException {
		String name = null;
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getId().equals(id))
				name = products.get(i).getName();
		}
		return name;
	}
	
	public double getPrice(String id, String currency) throws RemoteException, ServiceException {
		float price = 0.0f;
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getId().equals(id)) {
				price = products.get(i).getPrice();
				CurrencyServerSoap currencySystem = new CurrencyServerLocator().getCurrencyServerSoap();
				double montant = price * (double) currencySystem.rate("", "EUR", currency, false, "", CurncsrvReturnRate.curncsrvReturnRateNumber, "", "");
				return montant;
			}
		}
		return price;
	}
	
	public String getState(String id) throws RemoteException {
		String state = null;
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getId().equals(id))
				state = products.get(i).getState();
		}
		return state;
	}
	
	public float getNote(String id) throws RemoteException {
		float note = -1;
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getId().equals(id))
				note = products.get(i).getNote();
		}
		return note;
	}
	
	public boolean selectProduct(String idProduct) throws RemoteException {
		
		if (idProduct == null) {
			return false;
		}
		
		for(int i = 0; i < products.size(); i++) {
			IProduct p = products.get(i);
			if (p.getId().equals(idProduct) && p.isAvailable()) {
				return true;
			}
			
		}
		return false;
		
	}
	
	public boolean buyProduct(String[] idProducts, double price, int idUser) throws RemoteException {
				
		boolean b = bankService.withdrawalOf(idUser, price);
		
		if (!b) {
			return false;
		}
		
		for(int i = 0; i < products.size(); i++) {
			IProduct p = products.get(i);
			for(int j = 0; j < idProducts.length; j++) {
				if(p.getId().equals(idProducts[j])){
					p.setAvailable(false);
				}
			}
		}
		
		return true;
		
	}
	
}
