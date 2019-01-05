/* Check class
   Anderson, Franceschi
*/

import java.awt.Graphics;
import java.awt.Color;
import java.text.DecimalFormat;

public class Check extends Transaction
{
 public Check( double p )
 {
  super( p );
 }

 public void draw( Graphics g, int startX, int endX, int y, Color background )
 {
  String display1 = "Check:  Amount = " + money.format( amount );
  // set color to red
  g.setColor( Color.RED );
  g.drawString( display1, 20, 50 );
  // set color to black
  g.setColor( Color.BLACK );
  g.drawString( display2, 20, 75 );

  // set color to blue
  g.setColor( Color.BLUE );
  g.drawString( "Check", startX + 3, y - 44 );

  // draw check
  g.drawRect( startX, y, 200, 100 );
  g.drawString( "ABC Bank", startX + 20, y + 20 );

  for ( int x = startX + 100; x < endX + 20; x += 1 )
  {
   // sign the check
   g.setColor( Color.BLACK );
   g.drawLine( x, ( int ) ( y + 60 + 10 * Math.sin( x ) ),
               x + 1, ( int ) ( y + 60 + 10 * Math.sin( x + 1 ) ) );

   try {
     Thread.sleep( ( int )( 30 ) );
   }
   catch ( InterruptedException e )
   {
      e.printStackTrace( );
   }
  }
 }
}
