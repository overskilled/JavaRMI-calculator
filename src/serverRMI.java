import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class serverRMI {
    public static void main(String[] args) throws Exception {
        try {
            Registry registry = LocateRegistry.createRegistry(1098);
            Calculator_interfaceImpl cal = new Calculator_interfaceImpl();
            registry.rebind("CalculatorService", cal);
            System.out.println("Connected to server");
        } catch (Exception e) {
            System.out.println("Unable to  connect to server"+ e);
        }
    }
}
