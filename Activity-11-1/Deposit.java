/* Deposit class
   Anderson, Franceschi
   Mark Johnson
*/
import java.awt.Graphics;
import java.awt.Color;
import java.text.DecimalFormat;

public class Deposit extends Transaction
{
 public Deposit( double p )
 {
  super( p );
 }

 public void draw( Graphics g, int startX, int endX, int y, Color background )
 {
  String display1 = "Deposit:  Amount = " + money.format( amount );
  // set color to blue
  g.setColor( Color.BLUE );
  g.drawString( display1, 20, 50 );

  // set color to black
  g.setColor( Color.BLACK );
  g.drawString( display2, 20, 75 );

  // set color to blue
  g.setColor( Color.BLUE );
  g.drawString( "Deposit", startX + 3, y - 44 );

  // draw Work, Internet, Bank
  g.drawLine( startX, y - 20, endX, y - 20 );
  g.drawLine( startX, y + 40, endX, y + 40 );
  g.drawString( "Work", startX - 40, y + 20 );
  g.drawString( "ABC Bank", endX + 10, y + 20 );

  // Animate a dollar bill
  int x;
  for ( x = startX; x < endX - 60; x += 5 )
  {
   g.setColor ( new Color( 0, 255, 0 ) );// green
   g.fillRect( x, y, 60, 20 );
   g.setColor ( new Color( 0, 0, 0 ) );
   g.drawString( "$$$", x + 20, y + 15 );

   try {
      Thread.sleep( ( int )( 100 ) );
   }
   catch ( InterruptedException e )
   {
      e.printStackTrace( );
   }
   g.setColor( background ); // background
   g.fillRect( x, y, 60, 20 ); //erase
  }
  g.setColor ( new Color( 0, 255, 0 ) ); // green
  g.fillRect( x, y, 60, 20 );
  g.setColor ( new Color( 0, 0, 0 ) );
  g.drawString( "$$$", x + 20, y + 15 );
 }
}
