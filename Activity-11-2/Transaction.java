/* Transaction class
   Anderson, Franceschi
*/

import java.awt.Graphics;
import java.awt.Color;
import java.text.DecimalFormat;
import java.io.Serializable;

public abstract class Transaction implements Serializable
{
 public static final DecimalFormat money = new DecimalFormat( "$#,##0.00" );

 protected double amount;
 protected double currentBalance;

 protected String display2 = "";

 public Transaction( double p )
 {
  setAmount( p );
 }

 public void setAmount( double newAmount )
 {
  amount = newAmount;
  // display1 = "Check:  Amount = " + money.format( amount );
 }

 public double getAmount( )
 {
  return amount;
 }

 public void updateBalance( double newCurrentBalance )
 {
  currentBalance = newCurrentBalance;
  display2 = "Current account balance = " + money.format( currentBalance );
 }

 public abstract void draw( Graphics g, int startX, int endX, int y , Color c );
}
