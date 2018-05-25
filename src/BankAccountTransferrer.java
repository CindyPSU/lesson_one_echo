import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Group 3
 */
public class BankAccountTransferrer implements Runnable
{
    BankAccount fromAcct;
    BankAccount toAcct;
    double amount;
    
    public BankAccountTransferrer (BankAccount paraFromAccount, BankAccount paraToAccount, double transferAmt)
    {
        fromAcct = paraFromAccount;
        toAcct = paraToAccount;
        amount = transferAmt;
    }
    
    Lock transferLock = new ReentrantLock();
    
    @Override
    public void run() 
    {
        fromAcct.transferLock.lock();
        toAcct.transferLock.lock();
        
        try
        {
            while(fromAcct.balance < amount)
            {
                
            }
            fromAcct.balance -= amount;
            toAcct.balance += amount;
            System.out.println(fromAcct.name+" = "+fromAcct.balance);
            System.out.println(toAcct.name+" = "+toAcct.balance);
        }
        finally
        {
            fromAcct.transferLock.unlock();
            toAcct.transferLock.unlock();
        }         
    }
    
    public static void main(String[] args) 
    {
        BankAccount bankAcctA = new BankAccount("A", 100.00);
        BankAccount bankAcctB = new BankAccount("B", 200.00);
        BankAccountTransferrer myAppOne = new BankAccountTransferrer(bankAcctA, bankAcctB, 200.00);
        BankAccountTransferrer myAppTwo = new BankAccountTransferrer(bankAcctB, bankAcctA, 300.00);
        Thread tOne = new Thread(myAppOne);
        Thread tTwo = new Thread(myAppTwo);
        tOne.start();
        tTwo.start();
        
    }
    
}
