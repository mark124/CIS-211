/* UnknownTransaction class
   Anderson, Franceschi
   Mark Johnson
*/

import java.awt.Graphics;
import java.awt.Color;
import java.text.DecimalFormat;

public class UnknownTransaction extends Transaction
{
 public UnknownTransaction( double p )
 {
  super( p );
 }

 public void draw( Graphics g, int startX, int endX, int y, Color background )
 {
  String display1 = "Unknown Transaction:  Amount = " + money.format( amount );
  if ( amount < 0 )
        g.setColor( Color.RED );
  else
        g.setColor( Color.BLUE );
  g.drawString( display1, 20, 50 );

  // set color to black
  g.setColor( Color.BLACK );
  g.drawString( display2, 20, 75 );

  // set color to blue
  g.setColor( Color.BLUE );
  g.drawString( "Unknown Transaction", startX + 5, y - 45 );

  int x;
  for ( x = startX; x < endX; x += 5 )
  {
   g.setColor( Color.DARK_GRAY );
   // Draw a question mark
   g.drawArc( x, y, 20, 20, 0, 180 );
   g.drawLine( x + 20, y + 10, x, y + 60 );
   g.drawArc( x, y + 55, 10, 10, 180, 225 );
   g.fillOval( x, y + 80, 15, 15 );

   try {
     Thread.sleep( ( int )( 70 ) );
   }
   catch (InterruptedException e )
   {
     e.printStackTrace( );
   }
   g.setColor( background ); // background
   g.fillRect( x, y - 10, x + 50, y + 100 ); //erase
  }

  g.setColor( Color.DARK_GRAY );
  // Draw a question mark
  g.drawArc( x, y, 20, 20, 0, 180 );
  g.drawLine( x + 20, y + 10, x, y + 60 );
  g.drawArc( x, y + 55, 10, 10, 180, 225 );
  g.fillOval( x, y + 80, 15, 15 );

 }
}
