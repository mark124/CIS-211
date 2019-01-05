/* Withdrawal class
   Anderson, Franceschi
   Mark Johnson
*/
import java.awt.Graphics;
import java.awt.Color;
import java.text.DecimalFormat;

public class Withdrawal extends Transaction
{
 public Withdrawal( double p )
 {
  super( p );
 }

 public void draw( Graphics g, int startX, int endX, int begY, Color background )
 {
  String display1 = "Withdrawal:  Amount = " + money.format( amount );
  // set color to red
  g.setColor( Color.RED );
  g.drawString( display1, 20, 50 );
  // set color to black
  g.setColor( Color.BLACK );
  g.drawString( display2, 20, 75 );
  // set color to blue
  g.setColor( Color.BLUE );
  g.drawString( "Withdrawal", startX + 5, begY - 45 );

  // draw an automated teller machine
  g.drawRect( startX, begY, 200, 100 );

  g.drawRect( startX + 10, begY + 10, 20, 20 );
  g.drawRect( startX + 40, begY + 10, 20, 20 );
  g.drawRect( startX + 70, begY + 10, 20, 20 );

  g.drawRect( startX + 10, begY + 40, 20, 20 );
  g.drawRect( startX + 40, begY + 40, 20, 20 );
  g.drawRect( startX + 70, begY + 40, 20, 20 );

  g.drawRect( startX + 10, begY + 70, 20, 20 );
  g.drawRect( startX + 40, begY + 70, 20, 20 );
  g.drawRect( startX + 70, begY + 70, 20, 20 );

  g.drawString( "1",startX + 17, begY + 25 );
  g.drawString( "2",startX + 47, begY + 25 );
  g.drawString( "3",startX + 77, begY + 25 );

  g.drawString( "4",startX + 17, begY + 55 );
  g.drawString( "5",startX + 47, begY + 55 );
  g.drawString( "6",startX + 77, begY + 55 );

  g.drawString( "7",startX + 17, begY + 85 );
  g.drawString( "8",startX + 47, begY + 85 );
  g.drawString( "9",startX + 77, begY + 85 );

  // Animate a dollar bill
  int y;
  for ( y = begY + 5; y < begY + 75; y += 5 )
  {
   g.setColor ( new Color( 0, 255, 0 ) ); // green
   g.fillRect( startX + 120, y, 60, 20 );
   g.setColor ( new Color( 0, 0, 0 ) );
   g.drawString( "$$$", startX + 140, y + 15 );

   try {
     Thread.sleep( ( int )( 100 ) );
   }
   catch ( InterruptedException e )
   {
     e.printStackTrace( );
   }
   g.setColor( background ); // background
   g.fillRect( startX + 120, y, 60, 20 ); //erase
  }
   g.setColor( new Color( 0, 255, 0 ) ); // green
   g.fillRect( startX + 120, y, 60, 20 );
   g.setColor( new Color( 0, 0, 0 ) );
   g.drawString( "$$$", startX + 140, y + 15 );
 }

}
