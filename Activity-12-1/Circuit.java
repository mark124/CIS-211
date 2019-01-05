/* Circuit - animates the circuit
   Anderson, Franceschi
*/

import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Color;

public class Circuit
{
 private int xStart = 100;
 private int yStart = 100;

 private boolean switch1;

 private Color circuitColor;

 public Circuit( )
 {
  switch1 = false;
  circuitColor = Color.BLUE;
 }

 public void open( )
 {
  switch1 = false;
 }

 public void close( )
 {
  switch1 = true;
 }

 public void draw( Graphics g )
 {
  // draw Circuit but not the switch
  // set color to blue
  drawSwitchAndBulb( g );
  g.setColor( Color.BLUE );

  g.drawLine( xStart, yStart, xStart, yStart + 205 );

  g.drawLine( xStart, yStart + 205, xStart + 100, yStart + 205 );
  g.drawLine( xStart + 160, yStart + 205, xStart + 300, yStart + 205 );
  g.drawString( "Switch", xStart + 115, yStart + 230 );

  g.drawLine( xStart + 300, yStart + 205, xStart + 300, yStart + 120 );
  g.drawLine( xStart + 300, yStart + 80, xStart + 300, yStart );

  g.drawLine( xStart + 300, yStart, xStart + 150, yStart );
  g.drawLine( xStart + 140, yStart, xStart, yStart );

  g.drawLine( xStart + 140, yStart - 10, xStart + 140, yStart + 10 );
  g.drawLine( xStart + 150, yStart - 5, xStart + 150, yStart + 5 );
  g.drawString( "Power source", xStart + 120, yStart - 20 );

  // Draw the switch
  g.drawOval( xStart + 280, yStart + 80, 40, 40 );
  g.drawString( "Light bulb", xStart + 330, yStart + 100 );
 }

 public void drawSwitchAndBulb( Graphics g )
 {
  if ( switch1 )
    g.setColor( Color.GREEN.darker( ) );
  else
    g.setColor( Color.RED );
  g.drawOval( xStart + 100, yStart + 200, 10, 10);
  g.drawOval( xStart + 150, yStart + 200, 10, 10);
  if ( switch1 )
  {
   g.drawLine( xStart + 105, yStart + 200, xStart + 155, yStart + 200 );
   g.setColor( Color.YELLOW );
   g.fillOval( xStart + 280, yStart + 80, 40, 40 );
  }
  else
  {
   g.drawLine( xStart + 105, yStart + 200, xStart + 155, yStart + 180 );
  }
 }
}
