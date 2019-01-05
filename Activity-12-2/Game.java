/* Using GridLayout to organize our window
   Anderson, Franceschi
   Mark Johnson
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel
{
 private JButton [][] squares;
 private TilePuzzle game;

 public Game( int newSide )
 {
  game = new TilePuzzle( newSide );
  setUpGameGUI( );
 }

 public void setUpGame( int newSide )
 {
  game.setUpGame( newSide );
  setUpGameGUI( );
 }

 public void setUpGameGUI( )
 {
   removeAll( ); // remove all components
   setLayout( new GridLayout( game.getSide( ),
              game.getSide( ) ) );

   squares = new JButton[game.getSide( )][game.getSide( )];

   ButtonHandler bh = new ButtonHandler( );

   // for each button: generate button label,
   // instantiate button, add to container,
   // and register listener
   for ( int i = 0; i < game.getSide( ); i++ )
   {
    for ( int j = 0; j < game.getSide( ); j++ )
    {
     squares[i][j] = new JButton( game.getTiles( )[i][j] );
     add( squares[i][j] );
     squares[i][j].addActionListener( bh );
    }
   }

   setSize( 300, 300 );
   setVisible( true );
 }

 private void update( int row, int col )
 {
   for ( int i = 0; i < game.getSide( ); i++ )
   {
    for ( int j = 0; j < game.getSide( ); j++ )
    {
     squares[i][j].setText( game.getTiles( )[i][j] );
    }
   }

   if ( game.won( ) )
   {
    JOptionPane.showMessageDialog( Game.this,
              "Congratulations! You won!\nSetting up new game" );
    // int sideOfPuzzle = 3 + (int) ( 4 * Math.random( ) );
    // setUpGameGUI( );
   }
 }

 private class ButtonHandler implements ActionListener
 {
  public void actionPerformed( ActionEvent ae )
  {
   for( int i = 0; i < game.getSide( ); i++ )
   {
    for( int j = 0; j < game.getSide( ); j++ )
    {
     if ( ae.getSource( ) == squares[i][j] )
     {
       if ( game.tryToPlay( i, j ) )
          update( i, j );
       return;
     } // end if 
    } // end inner for loop
   } // outer for loop
  } // end actionPerformed method
 } // end ButtonHandler class
} // end Game class
