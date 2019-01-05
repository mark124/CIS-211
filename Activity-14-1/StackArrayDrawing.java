/* StackArrayDrawing
*  Anderson, Franceschi
*/

import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Color;

public class StackArrayDrawing
{
 public static final int XSTART = 200;
 public static final int YSTART = 300;
 public static final int WIDTH = 100;
 public static final int HEIGHT = 25;

 private StackArray sa;

 private boolean pushSuccess;
 private boolean popSuccess;
 private int pushedValue;
 private int poppedValue;

 private boolean operation; // true for push, false for pop
 private String description = "";
 private boolean started;

 public StackArrayDrawing( )
 {
  sa = new StackArray( );
 }

 public void setPushSuccess( boolean newPushSuccess )
 {
  started = true;
  pushSuccess = newPushSuccess;
 }

 public void setPopSuccess( boolean newPopSuccess )
 {
  popSuccess = newPopSuccess;
 }

 public void setPushedValue( int newPushedValue )
 {
  pushedValue = newPushedValue;
 }

 public void setPoppedValue( int newPoppedValue )
 {
  poppedValue = newPoppedValue;
 }

 public void setOperation( boolean newOperation )
 {
  operation = newOperation;
 }

 public void setStarted( boolean newStarted )
 {
  started = newStarted;
 }

 public boolean push( int value )
 {
  return ( sa.push( value ) );
 }

 public int pop( ) throws DataStructureException
 {
  return( sa.pop( ) );
 }

 public void draw( Graphics g )
 {
  // draw the empty stack and indices
  g.setColor( Color.BLUE );
  drawEmptyStack( g );

  // draw the stack contents
  g.setColor( Color.RED );
  drawStackContents( g );

  // draw top
  g.setColor( Color.BLACK );
  drawTop( g );

  // determine operation
  if ( operation ) // push
  {
   if ( pushSuccess )
   {
    description = "successfully pushed " + pushedValue;
   }
   else
   {
    description = "failed to push " + pushedValue;
   }
  }
  else      // pop
  {
   if ( popSuccess )
   {
    description = "successfully popped " + poppedValue;
   }
   else
   {
    description = "failed to pop";
   }
  }
  if ( !started )
    description = "";
  drawDescription( g );
 }

 public void drawEmptyStack( Graphics g )
 {
  for ( int i = 0; i < StackArray.CAPACITY; i++ )
  {
   g.drawRect( XSTART, YSTART - i * HEIGHT, WIDTH, HEIGHT );
   g.drawString( "" + i,
        XSTART - WIDTH / 4, (int) ( YSTART - ( i - 0.7 ) * HEIGHT ) );
  }
 }

 public void drawStackContents( Graphics g )
 {
  int i = 0;
  g.setColor( Color.BLACK );
  for ( i = 0; i <= sa.getTop( ); i++ )
  {
   g.drawString( "" + sa.get( i ),
        XSTART + WIDTH / 2 - 5, (int) ( YSTART - ( i - 0.7 ) * HEIGHT ) );
  }
  g.setColor( Color.RED );
  for ( i = sa.getTop( ) + 1; i < StackArray.CAPACITY; i++ )
  {
   g.drawString( "" + sa.get( i ),
        XSTART + WIDTH / 2 - 5, (int) ( YSTART - ( i - 0.7 ) * HEIGHT ) );
  }
 }

 public void drawTop( Graphics g )
 {
  g.drawString( "top",
  XSTART - WIDTH / 2, (int) ( YSTART - ( sa.getTop( ) - 0.7 ) * HEIGHT ) );
 }

 public void drawDescription( Graphics g )
 {
  g.drawString( description, XSTART + WIDTH + 20, YSTART / 2 );
 }
}
