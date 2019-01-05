/** ArrayListPractice
    Anderson, Franceschi
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListPractice extends JFrame
{
   // GUI components
   private JButton fillValues;
   private JButton printAutoList;
   private JButton setValues;
   private JButton findMaximum;
   private JButton countFrequency;

   private ButtonHandler bh;

   private static ArrayList<Auto> carList;
   private static Auto current = null;
   private AutoDisplay ad;

   private static ArrayListPractice app;
   private boolean firstTime = true;

   public ArrayListPractice( )
   {
      super( "Choose your activity" );
      Container c = getContentPane( );
      c.setLayout( new FlowLayout( ) );

      fillValues = new JButton( "Fill Cars" );
      c.add( fillValues );
      printAutoList = new JButton( "Print Auto List" );
      c.add( printAutoList );
      setValues = new JButton( "Set Models" );
      c.add( setValues );
      findMaximum = new JButton( "Find Maximum Miles" );
      c.add( findMaximum );
      countFrequency = new JButton( "Count Model Frequency" );
      c.add( countFrequency );

      bh = new ButtonHandler( );
      fillValues.addActionListener( bh );
      printAutoList.addActionListener( bh );
      setValues.addActionListener( bh );
      findMaximum.addActionListener( bh );
      countFrequency.addActionListener( bh );

      setSize( 500,400 );

      carList = new ArrayList<Auto>( );

      ad = new AutoDisplay( carList );
      setVisible( true );
      ad.setEraseColor( getBackground( ) );
      // fill carList with several cars
      fillWithCars( );
   }

   // ***** 1.  This method has been coded as an example
   /** Fills the carList with hard-coded Auto objects
   *    The instance variable carList is the ArrayList
   *    to be filled with Auto objects
   */
   public void fillWithCars()
   {
     // clear carList before adding cars
     carList.clear();
     // Reset the number of Autos to 0
     // This is needed so that the animation feedback works correctly
     Auto.clearNumberAutos();

     Auto car1 = new Auto("BMW", 0, 0.0);
     Auto car2 = new Auto("Ferrari", 100, 500.0);
     Auto car3 = new Auto("Jeep", 1000, 90.0);
     Auto car4 = new Auto("Ferrari", 10, 3.0);
     Auto car5 = new Auto("BMW", 4000, 200.0);
     Auto car6 = new Auto("Ferrari", 1000, 50.0);

     carList.add(car1);
     carList.add(car2);
     carList.add(car3);
     carList.add(car4);
     carList.add(car5);
     carList.add(car6);
     animate();
   }

   // ***** 2.  Student writes this method
   /**  Prints carList to console, elements are separated by a space
   *    The instance variable carList is the ArrayList to be printed
   */
   public void printAutoList()
   {
     // Note:  To animate the algorithm, put this method call as the
     // last element in your for loop
     //    animate(car);
     //  where car is the variable name for the current Auto object
     //  as you loop through the ArrayList object
     // Part 2 student code starts here:

      for (Auto currentAuto : carList)
      {
        System.out.println( currentAuto.toString() );
        // Do something with auto
        animate( currentAuto );
      }

     // Part 2 student code ends here.
   }

   // ***** 3.  Student writes this method
   /** Sets the model of all the elements in carList to parameter value
   *    The instance variable carList is the ArrayList to be modified
   *  @param model the model to assign to all Auto objects in carList
   */
   public void setModelValues(String model)
   {
     // Note:  To animate the algorithm, put this method call as the
     // last statement in your for loop
     //    animate(car);
     //  where car is the variable name for the current Auto object
     //  as you loop through the ArrayList object
     // Part 3 student code starts here:

      for (Auto currentAuto : carList)
      {
        currentAuto.setModel(model);
        animate( currentAuto );
      }

     // Part 3 student code ends here.
   }

   // ***** 4.  Student writes this method
   /** Finds maximum number of miles driven
   *   Instance variable carList is the ArrayList to search
   *  @return the maximum miles driven by all the Auto objects
   */
   public int findMaximumMilesDriven()
   {
     // Note:  To animate the algorithm, put this method call as the
     // last statement in your for loop
     //    animate(car, maximum);
     //  where car is the variable name for the current Auto object
     //  and maximum is the int variable storing the current maximum
     //  number of miles for all Auto elements you have already tested
     //  as you loop through the ArrayList object
     // Part 4 student code starts here:

      int maximum = 0;
      for (Auto currentAuto : carList)
      {
        // You figure out what code goes here:
        if (currentAuto.getMilesDriven() > maximum)
        {
          maximum = currentAuto.getMilesDriven();
          animate(currentAuto, maximum);
        }
      }
      return maximum; // replace this statement with your return statement

     // Part 4 student code ends here.
   }


   // ***** 5.  Student writes this method
   /** Finds number of times parameter model is found in the carList
   *   Instance variable carList is the ArrayList in which we search
   *  @param model  the model to count
   *  @return   the number of times model was found
   */
   public int countFound(String model)
   {
     // Note:  To animate the algorithm, put this method call as the
     // last statement in your for loop
     //    animate(car, num);
     //  where car is the variable name for the current Auto object
     //  and num is the int variable storing the current number of
     //  Auto elements whose model is equal to the method's parameter
     //  as you loop through the ArrayList object
     // Part 5 student code starts here:
      
      int num = 0;
      for (Auto currentAuto : carList)
      {
        if(currentAuto.getModel().equals(model))
        {
          num += 1;
          animate(currentAuto, num);
        }
      }

     return num; // replace this statement with your return statement

     // Part 5 student code ends here.
   }

   public void startActivity( int act )
   {
      ad.setActivity( act );
      boolean goodInput = false;
      String answer = "";
      String message = "";
      switch( act )
      {
       case  0:
        fillWithCars( );
          JOptionPane.showMessageDialog( null, "carList filled with new values" );
          break;

       case  1:
        printAutoList( );
          JOptionPane.showMessageDialog( null, "carList printed" );
          break;

       case  2:
        answer = JOptionPane.showInputDialog( null, "Enter a car model" );
          if (answer != null )
          {
           ad.setSearchModel( answer );
           setModelValues( answer );
           if ( ad.getCurrentModelValuesSet( ) )
             message = "\nYour result is correct";
           else
             message = "\nYour result is not correct";
           JOptionPane.showMessageDialog( null, "car models set to " + answer + message );
          }
          break;

      case 3:
       int a = findMaximumMilesDriven( );
         if ( a == ad.getCurrentMaximumMilesDriven( ) )
          message = "\nYour result is correct";
         else
          message = "\nYour result is not correct";
         JOptionPane.showMessageDialog( null, "The maximum number of miles driven is " + a + message );
         break;

      case  4:
       answer = JOptionPane.showInputDialog( null, "Enter a car model" );
         if ( answer != null )
         {
          ad.setSearchModel( answer );
          int frequency = countFound( answer );
          if ( frequency == ad.getCurrentCountModelFound( ) )
           message = "\nYour result is correct";
          else
           message = "\nYour result is not correct";
          if ( frequency > 1 )
            JOptionPane.showMessageDialog( null, answer + " found " + frequency + " times" + message );
          else if ( frequency == 1 )
            JOptionPane.showMessageDialog( null, answer + " found " + frequency + " time" + message );
          else
            JOptionPane.showMessageDialog( null, answer + " not found" + message );
        }
        break;
      }
      enableButtons( );
   }

   public static Auto getCurrent( )
   {
    return current;
   }

   public static ArrayList getCarList( )
   {
    return carList;
   }

   private void animate( Auto au )
   {
    if ( ad.getActivity( ) == 1 || ad.getActivity( ) == 2 )
    {
     try
     {
      current = au;
      ad.setCarList( carList );
      ad.setCurrentAuto( au );
      ad.setCurrentIndex( au.getIndex( ) );
      repaint( );
      Thread.sleep( 4000 );
     }
     catch ( InterruptedException e )
     {
      System.out.println( "IE Exception " + e.getMessage( ) );
      System.out.println( e.toString( ) );
     }
    }
    else
    {
      // call to animate has wrong number of arguments
      JOptionPane.showMessageDialog( null, "Wrong number of arguments to animate method" );
      System.exit( 1 );
    }
   }

   private void animate( Auto au, int studentResult )
   {
    if ( ad.getActivity( ) == 3 || ad.getActivity( ) == 4 )
    {
     try
     {
      current = au;
      ad.setCarList( carList );
      ad.setCurrentAuto( au );
      ad.setCurrentIndex( au.getIndex( ) );
      ad.setStudentResult( studentResult );
      repaint( );
      Thread.sleep( 4000 );
     }
     catch ( InterruptedException e )
     {
      System.out.println( "IE Exception " + e.getMessage( ) );
      System.out.println( e.toString( ) );
     }
    }
    else
    {
      // call to animate has wrong number of arguments
      JOptionPane.showMessageDialog( null, "Wrong number of arguments to animate method" );
      System.exit( 1 );
    }
   }

   private void animate( )
   {
    if ( ad.getActivity( ) == 0 )
    {
     try
     {
      ad.setCarList( carList );
      repaint( );
      Thread.sleep( 4000 );
     }
     catch ( InterruptedException e )
     {
      System.out.println( "IE Exception " + e.getMessage( ) );
      System.out.println( e.toString( ) );
     }
    }
    else
    {
      // call to animate has wrong number of arguments
      JOptionPane.showMessageDialog( null, "Wrong number of arguments to animate method" );
      System.exit( 1 );
    }
   }

   public void paint( Graphics g )
   {
     if ( ( ( current != null ) || firstTime ) && ( ad.getActivity( ) != 0 ) )
     {
       super.paint( g );
       if ( ad.getCurrentAuto( ) != null )
           ad.updateAutoDisplay( current, g );
       firstTime = false;
     }
     else if ( ad.getActivity( ) == 0 )
     {
       super.paint( g );
       ad.updateAutoDisplay( g );
     }
   }

   public static void main( String [] args )
   {
      app = new ArrayListPractice( );
      app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

   public void disableButtons( )
   {
     fillValues.setEnabled( false );
     printAutoList.setEnabled( false );
     setValues.setEnabled( false );
     countFrequency.setEnabled( false );
     findMaximum.setEnabled( false );
   }

   public void enableButtons( )
   {
     fillValues.setEnabled( true );
     printAutoList.setEnabled( true );
     setValues.setEnabled( true );
     countFrequency.setEnabled( true );
     findMaximum.setEnabled( true );
   }

   private class ButtonHandler implements ActionListener
   {
    private boolean on = true;
    public void actionPerformed( ActionEvent e )
    {
      printAutoListT t = new printAutoListT( app );

      if ( e.getSource( ) == fillValues )
      {
        disableButtons( );
        fillValues.requestFocus( );
        ad.setActivity( 0 );
        t.start( );
      }
      else if ( e.getSource( ) == printAutoList )
      {
        disableButtons( );
        printAutoList.requestFocus( );
        ad.setActivity( 1 );
        t.start( );
      }
      else if ( e.getSource( ) == setValues )
      {
        disableButtons( );
        setValues.requestFocus( );
        ad.setActivity( 2 );
        t.start( );
      }
      else if ( e.getSource( ) == findMaximum )
      {
        disableButtons( );
        findMaximum.requestFocus( );
        ad.setActivity( 3 );
        t.start( );
      }
      else if ( e.getSource( ) == countFrequency )
      {
        disableButtons( );
        countFrequency.requestFocus( );
        ad.setActivity( 4 );
        t.start( );
      }
    }
  }

  private class printAutoListT extends Thread
  {
     ArrayList<Auto> arr;
     ArrayListPractice s1;
     public printAutoListT ( ArrayListPractice s )
     {
      arr = ArrayListPractice.carList;
      s1 = s;
     }
     public void run( )
     {
      startActivity( ad.getActivity( ) );
     }
  }
}
