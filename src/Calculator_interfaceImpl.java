import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Calculator_interfaceImpl extends UnicastRemoteObject implements Calculator_interface{

    int result = 0;
    
    protected Calculator_interfaceImpl() throws RemoteException {
        super();
        //TODO Auto-generated constructor stub
    }
    
    @Override
    public int calculator(int a, int b, int choice) throws RemoteException {
        // TODO Auto-generated method stub
        switch(choice){
            case 0:
                result = a + b;
                break;
            case 1:
                result = a * b;
                break;
            case 2:
                result = a / b;
                break;
            case 3:
                result = a - b;
                break;
            default:
                System.out.println("Chose a correct operator");
        }
        return result;
    }
    

}
