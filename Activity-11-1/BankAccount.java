/* BankAccount class
   Anderson, Franceschi
   Mark Johnson
*/

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;

public class BankAccount
{
 private Transaction currentTransaction;

 private double currentBalance;
 private Color background;

 public BankAccount( Color newBackground )
 {
  currentBalance = 0.0;
  currentTransaction = null;
  background = newBackground;
 }

 public void setCurrentTransaction( Transaction ca )
 {
  currentTransaction = ca;
 }

 public Transaction getCurrentTransaction( )
 {
  return currentTransaction;
 }

 public void updateBalance( double newCurrentBalance )
 {
  currentBalance = newCurrentBalance;
  currentTransaction.updateBalance( currentBalance );
 }

 public void draw( Graphics g )
 {
  if ( currentTransaction != null )
    	currentTransaction.draw( g, 50, 200, 175, background );
 }
}
