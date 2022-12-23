import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator_interface extends Remote{
    
    public int calculator(int a, int b, int choice) throws RemoteException;
    
}
