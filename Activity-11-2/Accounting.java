/* Accounting class
   Anderson, Franceschi
   Mark Johnson
*/

import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.EOFException;
import java.io.FileNotFoundException;


public class Accounting extends JFrame
{
  private BankAccount bankAccount;

  public Accounting()
  {
    super("Reading objects from a file");
    bankAccount = new BankAccount(getBackground());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(300, 300);
    setVisible(true);
  }

  public void balanceCheckBook()
  {
   //
    // ***** Student writes the body of this method *****
    //
    // Using a while loop, read the file transactions.obj
    // The file transactions.obj contains transaction objects
    //
    //  You will need to call the animate method inside
    //  the body of the loop that reads the objects
    //
    // The animate method takes two arguments:
    //    a Transaction object, representing the transaction
    //    a double, representing the new checkbook balance
    //  So if these two variables are transaction and balance,
    // then the call to animate will be:
    //
    //   animate(transaction, balance);
    //
    //  You should make that call in the body of your while
    //  loop, after you have updated the checkbook balance
    //
    // Student code starts here:

      double balance = 0.00;
      double currentAmount;
      Transaction transaction;
      
      final DecimalFormat MONEY = new DecimalFormat ("$###.00");


      try (FileInputStream fis = new FileInputStream("transactions.obj");
           ObjectInputStream ois = new ObjectInputStream(fis);)
          // fis and cis are resources that will be automatically closed.
      {
         while ( true )
         {
          transaction = (Transaction) ois.readObject( );
          currentAmount = transaction.getAmount();
          balance += currentAmount;
          animate(transaction, balance);
         }
      }
      catch (FileNotFoundException fnfe)
      {
        System.out.println("The file transactions.obj was not found.");
      }
      catch (ClassNotFoundException cnfe)
      {
        System.out.println("A ClassNotFoundException was encountered.");
      }
      catch (EOFException eofe)
      {
       System.out.println("The end of the file was reached.");
       System.out.println("Ending balance = " + MONEY.format(balance));
       JOptionPane.showMessageDialog(null, "Ending balance is " + MONEY.format(balance));

      }
      catch (IOException ioe)
      {
        System.out.println("An IOException was encountered."); 
      }

    // Student code ends here.
  }

  public void writeTransactions(ArrayList<Transaction> transactionList)
  {
    //
    // writing to file transactions.obj
    //

    try
    {
      FileOutputStream fos = new FileOutputStream("transactions.obj");
      ObjectOutputStream oos = new ObjectOutputStream(fos);

      Transaction tempTransaction;
      for (int i = 0; i < transactionList.size(); i++)
      {
        tempTransaction = (Transaction) transactionList.get(i);
        oos.writeObject(tempTransaction);
      }
      oos.close();
    }
    catch (IOException ioe)
    {
      System.out.println(ioe.toString());
      System.out.println(ioe.getMessage());
    }
  }

  public void animate(Transaction currentTransaction, double currentBalance)
  {
    // set the currentTransaction data member in the bankAccount object
    bankAccount.setCurrentTransaction(currentTransaction);

    // set the currentBalance data member in the bankAccount object
    bankAccount.updateBalance(currentBalance);

    repaint();
    try
    {
      Thread.sleep(3000); // wait for the animation to finish
    }
    catch (Exception e)
    {
    }
  }

  public void paint(Graphics g)
  {
    super.paint(g);
    if (bankAccount != null)
    {
      bankAccount.draw(g);
    }
  }

  public static void main(String[] args)
  {
    Accounting app = new Accounting();

    // Generate an ArrayList of Transaction objects to write to file Transaction.obj
    ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
    Check c1 = new Check(-500.00);
    transactionList.add(c1);
    Deposit d1 = new Deposit(3000.00);
    transactionList.add(d1);
    Withdrawal w1 = new Withdrawal(-400.00);
    transactionList.add(w1);
    c1 = new Check(-300.00);
    transactionList.add(c1);

    // write transactions as objects to file transaction.obj
    app.writeTransactions(transactionList);

    // read transaction.obj, balance the checkbook
    app.balanceCheckBook();
  }
}
