/* StackPractice
*  Anderson, Franceschi
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class StackPractice extends JFrame
{
 Container contents;
 // GUI components
 private JButton push;
 private JButton pop;

 private ButtonHandler bh;

 private StackArrayDrawing sad;

 private static StackPractice app;
 private boolean firstTime = true;

 public StackPractice( )
 {
  super( "Push or pop" );
  contents = getContentPane( );
  contents.setLayout( new FlowLayout( ) );

  sad = new StackArrayDrawing( );

  push = new JButton( "push" );
  contents.add( push );
  pop = new JButton( "pop" );
  contents.add( pop );

  bh = new ButtonHandler( );
  push.addActionListener( bh );
  pop.addActionListener( bh );

  setSize( 500,400 );
  setVisible( true );
 }

 private void animate( boolean pushSuccess, int pushedValue )
 {
  sad.setPushSuccess( pushSuccess );
  sad.setPushedValue( pushedValue );
  try
  {
   repaint( );
   Thread.sleep( 200 );
  }
  catch ( InterruptedException e )
  {
   System.out.println( "IE Exception " + e.getMessage( ) );
   System.out.println( e.toString( ) );
  }
 }

 private void animate( int poppedValue )
 {
  sad.setPopSuccess( true );
  sad.setPoppedValue( poppedValue );
  try
  {
   repaint( );
   Thread.sleep( 200 );
  }
  catch ( InterruptedException e )
  {
   System.out.println( "IE Exception " + e.getMessage( ) );
   System.out.println( e.toString( ) );
  }
 }

 private void animate( )
 {
  sad.setPopSuccess( false );
  try
  {
   repaint( );
   Thread.sleep( 200 );
  }
  catch ( InterruptedException e )
  {
   System.out.println( "IE Exception " + e.getMessage( ) );
   System.out.println( e.toString( ) );
  }
 }

 public void paint( Graphics g )
 {
  if ( firstTime )
    firstTime = false;
  super.paint( g );
  sad.draw( g );
 }

 public static void main( String [] args )
 {
  app = new StackPractice( );
  app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 }

 private class ButtonHandler implements ActionListener
 {
  private boolean success = false;

  public void actionPerformed( ActionEvent e )
  {
   sad.setStarted( true );
   if ( e.getSource( ) == push )
   {
    sad.setOperation( true );
    int insertValue = getValue( );
    success = sad.push( insertValue );
    animate( success, insertValue );
   }
   else // ( e.getSource( ) == pop )
   {
    sad.setOperation( false );
    try
    {
     int popped = sad.pop( );
     animate( popped );
    }
    catch( DataStructureException dse )
    {
     System.out.println( dse.getMessage( ) );
     animate( );
    }
   }
  }
 }

 public int getValue( )
 {
  int value = 0;
  boolean goodInput = false;
  while ( !goodInput )
  {
   try
   {
     String answer = JOptionPane.showInputDialog
      ( null, "Enter an integer value" );
     value = Integer.parseInt( answer );
     goodInput = true;
   }
   catch( Exception e )
   {
   }
  }
  return value;
 }
}