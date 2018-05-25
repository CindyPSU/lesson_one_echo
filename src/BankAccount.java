import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 *
 * @author Group 3
 */
public class BankAccount 
{
    public double balance;
    public String name;
    
    Lock transferLock = new ReentrantLock();
    
    public BankAccount(String inputName, double initialBalance)
    {
        name = inputName;
        balance = initialBalance;
    }
}

