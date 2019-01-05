/* AutoDisplay
*  Anderson, Franceschi
*/

import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Color;
import java.util.ArrayList;

public class AutoDisplay
{
 private ArrayList<Auto> data;

 private int xStart = 100;
 private int xEnd = 300;
 private int yStart = 200;
 private int activity = 0;
 private int count = 0;

 private Auto currentAuto;
 private int currentIndex;
 private String searchModel;
 private int studentResult;

 private int currentCountModelFound;
 private int currentMaximumMilesDriven;
 private boolean currentModelValuesSet;

 private Color eraseColor;

 public AutoDisplay( )
 { }

 public AutoDisplay( ArrayList<Auto> al )
 {
  data = new ArrayList<Auto>( );
  data = al;
 }

 public void setCarList( ArrayList<Auto> al )
 {
  data = al;
 }

 public void setActivity( int a )
 {
  activity = a;
 }
 public int getActivity( )
 {
  return activity;
 }

 public void setCurrentAuto( Auto car )
 {
  currentAuto = car;
 }

 public Auto getCurrentAuto( )
 {
  return currentAuto;
 }

 public void setCurrentIndex( int newCurrentIndex )
 {
  currentIndex = newCurrentIndex;
 }

 public void setSearchModel( String newSearchModel )
 {
  searchModel = newSearchModel;
 }

 public void setStudentResult( int sr )
 {
  studentResult = sr;
 }

 public void setEraseColor( Color c )
 {
  eraseColor = c;
 }

 public int getCurrentCountModelFound( )
 {
  return currentCountModelFound;
 }

 public int getCurrentMaximumMilesDriven( )
 {
  return currentMaximumMilesDriven;
 }

 public boolean getCurrentModelValuesSet( )
 {
  return currentModelValuesSet;
 }

 public void findCurrentMaximumMilesDriven( )
 {
  currentMaximumMilesDriven = currentAuto.getMilesDriven( );
  for(int i = 0; i < currentIndex; i++)
  {
   if ( data.get( i ).getMilesDriven( ) > currentMaximumMilesDriven )
     currentMaximumMilesDriven = data.get( i ).getMilesDriven( );
  }
 }

 public void findCurrentCountFound( )
 {
  currentCountModelFound = 0;
  for(int i = 0; i <= currentIndex; i++)
  {
   if ( data.get( i ).getModel( ).equals(searchModel) )
     currentCountModelFound++;
  }
 }

 public void checkCurrentModelValuesSet( )
 {
  currentModelValuesSet = true;
  for(int i = 0; i <= currentIndex; i++)
  {
   if (!( data.get( i ).getModel( ).equals(searchModel) ))
     currentModelValuesSet = false;
  }
 }

 public void updateAutoDisplay( Graphics g )
 {
  // called for new ArrayList values
  // Displays new data
  int i = 0;
  for ( Auto car : data )
  {
   if ( car.getModel( ).equals( "BMW" ) )
       g.setColor( Color.blue );
   else if ( car.getModel( ).equals( "Jeep" ) )
       g.setColor( Color.black );
   else if ( car.getModel( ).equals( "Ferrari" ) )
       g.setColor( Color.red );
   else
       g.setColor( Color.green );

   g.drawString( car.toString( ) , xStart, yStart + 25* i );
   i = i + 1;
   try {
        Thread.sleep(  100 );
   }
   catch ( InterruptedException e )
   {
      e.printStackTrace();
   }
  }
 }

 public void updateAutoDisplay( Auto car, Graphics g )
 {
  draw( g );
  switch( activity )
  {
   case  0:   // create new ArrayList values
     break;
   case  1:   // print out the ArrayList
     break;
   case  2:   // set all Auto models
    checkCurrentModelValuesSet( );
    drawValuesSet( g );
    break;
   case  3:   // find the maximum mumber of miles
    findCurrentMaximumMilesDriven( );
    drawMaxMiles( g );
    break;
   case  4:   // find the frequency of a model
    findCurrentCountFound( );
    drawFrequency( g );
    break;
  }

  if ( ( currentAuto.getModel( ) ).equals( "BMW" ) )
     drawBMW( g, xStart, xEnd, yStart );
  else if ( ( currentAuto.getModel( ) ).equals( "Jeep" ) )
     drawJeep( g, xStart, xEnd, yStart );
  else if ( ( currentAuto.getModel( ) ).equals( "Ferrari" ) )
     drawFerrari( g, xStart, xEnd, yStart );
  else
     drawOtherCar( g, xStart, xEnd, yStart );
 }

 public void draw( Graphics g )
 {
  // Set color first then Draw the miles and gallons of currentAuto
  if ( currentAuto != null )
  {
   if ( currentAuto.getModel( ).equals( "BMW" ) )
    g.setColor( Color.BLUE );
   else if ( currentAuto.getModel( ).equals( "Jeep" ) )
    g.setColor( Color.BLACK );
   else if ( currentAuto.getModel( ).equals( "Ferrari" ) )
    g.setColor( Color.RED );
   else
    g.setColor( new Color( 20, 200, 110 ) );
   g.drawString( "Miles = " + currentAuto.getMilesDriven( ) , xStart + 100, yStart + 40 );
   g.drawString( "Gallons = " + currentAuto.getGallonsOfGas( ) , xStart + 100, yStart + 70 );
  }
 }

 public void drawBMW( Graphics g, int startX, int endX, int y )
 {
  int wx1 = 0;
  int wy1 = 0;
  int wx2 = 0;
  int wy2 = 0;
  for ( int x = startX; x < endX; x += 1 )
  {
   // draw the BMW
   g.setColor( Color.BLUE );
   // Bottom
   g.drawLine( x, y, x + 100, y );
   // Back
   g.drawLine( x, y, x, y - 20 );
   // trunk
   g.drawLine( x, y - 20, x + 20, y - 20 );
   // back windshield
   g.drawLine( x + 20, y - 20, x + 20, y - 40 );
   // Roof
   g.drawLine( x + 20, y - 40, x + 60, y - 40 );
   // Windshield
   g.drawLine( x + 60, y - 40, x + 70, y - 20 );
   // Hood
   g.drawLine( x + 70, y - 20, x + 100, y - 20 );
   // Front
   g.drawLine( x + 100, y - 20, x + 100, y );

   // Back wheel
   g.drawOval( x + 15, y, 14, 14 );
   // Make backwheel animate
   wx1 = x + 22 - ( (int) ( 3 * Math.cos( 3 * x ) ) );
   wy1 = y + 7 - ( (int) ( 3 * Math.sin( -3 * x ) ) );
   wx2 = x + 22 + ( (int) ( 3 * Math.cos( 3 * x ) ) );
   wy2 = y + 7 + ( (int) ( 3 * Math.sin( -3 * x ) ) );
   g.drawLine( wx1, wy1, wx2, wy2 );

   // Front wheel
   g.drawOval( x + 70, y, 14, 14 );
   // Make frontwheel animate
   wx1 = x + 77 - ( (int) ( 3 * Math.cos( 3 * x ) ) );
   wy1 = y + 7 - ( (int) ( 3 * Math.sin( -3 * x ) ) );
   wx2 = x + 77 + ( (int) ( 3 * Math.cos( 3 * x ) ) );
   wy2 = y + 7 + ( (int) ( 3 * Math.sin( -3 * x ) ) );
   g.drawLine( wx1, wy1, wx2, wy2 );

   // draw BMW name
   g.drawString("BMW", x + 30, y - 20 );
   try {
      Thread.sleep( ( int )( 15 ) );
   }
   catch ( InterruptedException e )
   {
      e.printStackTrace( );
   }
   g.setColor( eraseColor );
   if ( x != ( endX - 1 ) )
    g.fillRect( x, y - 60, 101, 81 ); //erase
  }
 }

 public void drawFerrari( Graphics g, int startX, int endX, int y )
 {
  int wx1 = 0;
  int wy1 = 0;
  int wx2 = 0;
  int wy2 = 0;
  for ( int x = startX; x < endX; x += 1 )
  {
   // draw the BMW
   g.setColor( Color.RED );
   // Bottom
   g.drawLine( x, y, x + 100, y );
   // Back
   g.drawLine( x, y, x, y - 10 );
   // trunk
   g.drawLine( x, y - 10, x + 10, y - 15 );
   // back windshield
   g.drawLine( x + 10, y - 15, x + 20, y - 30 );
   // Roof
   g.drawLine( x + 20, y - 30, x + 50, y - 30 );
   // Windshield
   g.drawLine( x + 50, y - 30, x + 80, y - 15 );
   // Hood
   g.drawLine( x + 80, y - 15, x + 100, y - 10 );
   // Front
   g.drawLine( x + 100, y - 10, x + 100, y );

   // Back wheel
   g.drawOval( x + 15, y, 14, 14 );
   // Make backwheel animate
   wx1 = x + 22 - ( (int) ( 3 * Math.cos( 3 * x ) ) );
   wy1 = y + 7 - ( (int) ( 3 * Math.sin( -3 * x ) ) );
   wx2 = x + 22 + ( (int) ( 3 * Math.cos( 3 * x ) ) );
   wy2 = y + 7 + ( (int) ( 3 * Math.sin( -3 * x ) ) );
   g.drawLine( wx1, wy1, wx2, wy2 );

   // Front wheel
   g.drawOval( x + 70, y, 14, 14 );
   // Make frontwheel animate
   wx1 = x + 77 - ( (int) ( 3 * Math.cos( 3 * x ) ) );
   wy1 = y + 7 - ( (int) ( 3 * Math.sin( -3 * x ) ) );
   wx2 = x + 77 + ( (int) ( 3 * Math.cos( 3 * x ) ) );
   wy2 = y + 7 + ( (int) ( 3 * Math.sin( -3 * x ) ) );
   g.drawLine( wx1, wy1, wx2, wy2 );

   // draw BMW name
   g.drawString("Ferrari", x + 25, y - 10 );
   try {
     Thread.sleep( ( int )( 10 ) );
   }
   catch ( InterruptedException e )
   {
      e.printStackTrace( );
   }
   g.setColor( eraseColor );
   if ( x != ( endX - 1 ) )
    g.fillRect( x, y - 60, 101, 81 ); //erase
  }
 }

 public void drawJeep( Graphics g, int startX, int endX, int y )
 {
  int wx1 = 0;
  int wy1 = 0;
  int wx2 = 0;
  int wy2 = 0;
  for ( int x = startX; x < endX; x += 1 )
  {
   // draw the Jeep
   g.setColor( Color.BLACK );
   // Bottom
   g.drawLine( x, y, x + 100, y );
   // Back
   g.drawLine( x, y, x, y - 60 );
   // Roof
   g.drawLine( x, y - 60, x + 60, y - 60 );
   // Windshield
   g.drawLine( x + 60, y - 60, x + 70, y - 20 );
   // Hood
   g.drawLine( x + 70, y - 20, x + 100, y - 20 );
   // Front
   g.drawLine( x + 100, y - 20, x + 100, y );
   // Back wheel
   g.drawOval( x + 15, y, 15, 15 );

   // Make backwheel animate
   wx1 = x + 22 - ( (int) ( 3 * Math.cos( 3 * x ) ) );
   wy1 = y + 7 - ( (int) ( 3 * Math.sin( -3 * x ) ) );
   wx2 = x + 22 + ( (int) ( 3 * Math.cos( 3 * x ) ) );
   wy2 = y + 7 + ( (int) ( 3 * Math.sin( -3 * x ) ) );
   g.drawLine( wx1, wy1, wx2, wy2 );

   // Front wheel
   g.drawOval( x + 70, y, 15, 15 );
   // Make frontwheel animate
   wx1 = x + 77 - ( (int) ( 3 * Math.cos( 3 * x ) ) );
   wy1 = y + 7 - ( (int) ( 3 * Math.sin( -3 * x ) ) );
   wx2 = x + 77 + ( (int) ( 3 * Math.cos( 3 * x ) ) );
   wy2 = y + 7 + ( (int) ( 3 * Math.sin( -3 * x ) ) );
   g.drawLine( wx1, wy1, wx2, wy2 );

   // draw Jeep name
   g.drawString("Jeep", x + 20, y - 30 );
   try {
     Thread.sleep( ( int )( 18 ) );
   }
   catch ( InterruptedException e )
   {
     e.printStackTrace( );
   }
   g.setColor( eraseColor );
   if ( x != ( endX - 1 ) )
    g.fillRect( x, y - 60, 101, 81 ); //erase
  }
 }

 public void drawOtherCar( Graphics g, int startX, int endX, int y )
 {
  int wx1 = 0;
  int wy1 = 0;
  int wx2 = 0;
  int wy2 = 0;
  for ( int x = startX; x < endX; x += 1 )
  {
   // draw the other car
   g.setColor( new Color( 20, 200, 110 ) );
   // Bottom
   g.drawLine( x, y, x + 100, y );
   // Back
   g.drawLine( x, y, x, y - 20 );
   // trunk
   g.drawLine( x, y - 20, x + 20, y - 20 );
   // back windshield
   g.drawLine( x + 20, y - 20, x + 20, y - 40 );
   // Roof
   g.drawLine( x + 20, y - 40, x + 60, y - 40 );
   // Windshield
   g.drawLine( x + 60, y - 40, x + 70, y - 20 );
   // Hood
   g.drawLine( x + 70, y - 20, x + 100, y - 20 );
   // Front
   g.drawLine( x + 100, y - 20, x + 100, y );
   // Back wheel
   g.drawOval( x + 15, y, 14, 14 );
   // Make backwheel animate
   wx1 = x + 22 - ( (int) ( 3 * Math.cos( 3 * x ) ) );
   wy1 = y + 7 - ( (int) ( 3 * Math.sin( -3 * x ) ) );
   wx2 = x + 22 + ( (int) ( 3 * Math.cos( 3 * x ) ) );
   wy2 = y + 7 + ( (int) ( 3 * Math.sin( -3 * x ) ) );
   g.drawLine( wx1, wy1, wx2, wy2 );

   // Front wheel
   g.drawOval( x + 70, y, 14, 14 );
   // Make frontwheel animate
   wx1 = x + 77 - ( (int) ( 3 * Math.cos( 3 * x ) ) );
   wy1 = y + 7 - ( (int) ( 3 * Math.sin( -3 * x ) ) );
   wx2 = x + 77 + ( (int) ( 3 * Math.cos( 3 * x ) ) );
   wy2 = y + 7 + ( (int) ( 3 * Math.sin( -3 * x ) ) );
   g.drawLine( wx1, wy1, wx2, wy2 );

   // draw Auto name
   // g.drawString("???", x + 30, y - 20 );
   String autoName = currentAuto.getModel( );
   if ( autoName.length( ) > 5 )
      autoName = autoName.substring( 0, 3 ) + "..";
   g.drawString( autoName, x + 30, y - 20 ); // NEW ADDED
   try {
     Thread.sleep( ( int )( 18 ) );
   }
   catch ( InterruptedException e )
   {
     e.printStackTrace( );
   }
   g.setColor( eraseColor );
   if ( x != ( endX - 1 ) )
    g.fillRect( x, y - 60, 101, 81 ); //erase
  }
 }

 public void drawValuesSet( Graphics g )
 {
  g.setColor( Color.BLACK );
  String message = "";
  if ( currentModelValuesSet )
    message = "correctly";
  else
    message = "incorrectly";
  g.drawString( "To this point, the models have been set " + message, xStart + 100, yStart + 125 );
 }

 public void drawMaxMiles( Graphics g )
 {
  g.setColor( Color.BLACK );
  g.drawString( "Student's current maximum is " + studentResult, xStart + 100, yStart + 100 );
  g.drawString( "Correct current maximum is " + currentMaximumMilesDriven, xStart + 100, yStart + 125 );
 }

 public void drawFrequency( Graphics g )
 {
  g.setColor( Color.BLACK );
  g.drawString( "Student's current count is " + studentResult, xStart + 100, yStart + 100 );
  g.drawString( "Correct current count is " + currentCountModelFound, xStart + 100, yStart + 125 );
 }
}
