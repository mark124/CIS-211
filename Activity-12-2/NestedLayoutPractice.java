/*  Practice using layouts
 Anderson, Franceschi
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NestedLayoutPractice extends JFrame
{
  private Container contents;
  private Game game;

  private BorderLayout bl;

  private JLabel bottom;
  // ***** Task 1: declare a JPanel named top
  // also declare three JButton instance variables
  // that will be added to the JPanel top
  // these buttons will determine the grid size of the game:
  //  3-by-3, 4-by-4, or 5-by-5
  // Part 1 student code starts here:
   
   JPanel top;
        
   JButton three;
   JButton four;
   JButton five;


  // Part 1 student code ends here.

  public NestedLayoutPractice()
  {
    super("Practicing layout managers");
    this.top = new JPanel();
    contents = getContentPane();

    // ***** Task 2:
    // instantiate the BorderLayout manager bl
    // Part 2 student code starts here:
    BorderLayout b1 = new BorderLayout( );        
    // set the layout manager of the content pane contents to bl:

    contents.setLayout( new BorderLayout( ) );

    game = new Game(3); // instantiating the GamePanel object


    // add panel (game) to the center of the content pane

    contents.add( game, BorderLayout.CENTER );

    // Part 2 student code ends here.

    bottom = new JLabel("Have fun playing this Tile Puzzle game",
      SwingConstants.CENTER);

    // ***** Task 3:
    // instantiate the JPanel component named top
    // Part 3 student code starts here:
    top = new JPanel(new BorderLayout());
    // set the layout of top to a 1-by-3 grid

    top.setLayout( new GridLayout(1,3));

    // instantiate the JButtons that determine the grid size

    three = new JButton("3 x 3");
    four = new JButton("4 x 4");
    five = new JButton("5 x 5");

    // add the buttons to JPanel top

    top.add( three );
    top.add( four );
    top.add( five );

    // add JPanel top to the content pane as its north component

    contents.add( top, BorderLayout.NORTH );

    // Part 3 student code ends here.

    // ***** Task 5:
    // Note: search for and complete Task 4 before performing this task
    // Part 5 student code starts here:

    // declare and instantiate an ActionListener

    ButtonHandler bh = new ButtonHandler( );

    // register the listener on the 3 buttons
    // that you declared in Task 1

    three.addActionListener( bh );
    four.addActionListener( bh );
    five.addActionListener( bh );
    
    // Part 5 student code ends here.

    contents.add(bottom, BorderLayout.SOUTH);

    setSize(325, 325);
    setVisible(true);
  }

  // ***** Task 4:
  // create a private inner class that implements ActionListener
  // your method should identify which of the 3 buttons
  //    was the source of the event
  // depending on which button was pressed,
  //    call the setUpGame method of the Game class
  //    with arguments 3, 4, or 5
  // the API of that method is:
  //   public void setUpGame(int nSides)
  // At the end of the method call validate()
  // Part 4 student code starts here:

  private class ButtonHandler implements ActionListener
  {
    public void actionPerformed(ActionEvent ae)
    {
      Object source = ae.getSource();
      if (source.equals(three))
      {
        game.setUpGame( 3 );
        validate();
        return;
      }
      if (source.equals(four))
      {
        game.setUpGame( 4 );
        validate();
        return;
      }
      if (source.equals(five))
      {
        game.setUpGame( 5 );
        validate();
        return;
      }
    }
  }


  // Part 4 student code ends here.

  public static void main(String[] args)
  {
    NestedLayoutPractice nl = new NestedLayoutPractice();
    nl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
