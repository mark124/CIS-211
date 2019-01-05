/* Auto class
   Anderson, Franceschi
*/
import java.text.DecimalFormat;
import java.awt.Graphics;

public class Auto
{
    // Static instance variable - number of Auto objects references created
    private static int numberAutos = 0;
    // Instance variables
    private String model;           //  model of auto
    private int milesDriven;       //  number of miles driven
    private double gallonsOfGas;   //  number of gallons of gas
    private int index;        //  car number

    // Default constructor:
    //  Initializes model to a blank String
    //  milesDriven are autoinitialized to 0, gallonsOfGas to 0.0
    public Auto( )
    {
      model = "";
      index = numberAutos;
      numberAutos++;
    }

    // Overloaded constructor:
    // Allows client to set beginning values for
    //   model, milesDriven, and gallonsOfGas.
    //   Calls mutator methods to validate new values.
    public Auto( String startModel,
                 int startMilesDriven,
                 double startGallonsOfGas )
    {
      model = startModel;
      setMilesDriven( startMilesDriven );
      setGallonsOfGas( startGallonsOfGas );
      index = numberAutos;
      numberAutos++;
    }

    // Accessor method:
    // Returns current value of index
    public int getIndex( )
    {
      return index;
    }

    // Accessor method:
    // Returns current value of model
    public String getModel( )
    {
      return model;
    }

    // Accessor method:
    // Returns current value of milesDriven
    public int getMilesDriven( )
    {
      return milesDriven;
    }

    // Accessor method:
    //  Returns current value of gallonsOfGas
    public double getGallonsOfGas( )
    {
      return gallonsOfGas;
    }

    // Mutator method:
    // Allows client to set model
    public void setModel( String newModel )
    {
      model = newModel;
    }

    // Mutator method:
    // Allows client to set value of milesDriven
    // prints an error message if new value is less than 0
    public void setMilesDriven( int newMilesDriven )
    {
      if ( newMilesDriven >= 0 )
         milesDriven = newMilesDriven;
      else
      {
         System.err.println( "Miles driven must be at least 0." );
         System.err.println( "Value not changed." );
      }
    }

    // Mutator method:
    // Allows client to set value of gallonsOfGas;
    // prints an error message if new value is less than 0.0
    public void setGallonsOfGas( double newGallonsOfGas )
    {
      if ( newGallonsOfGas >= 0.0 )
         gallonsOfGas = newGallonsOfGas;
      else
      {
         System.err.println( "Gallons of gas must be at least 0." );
         System.err.println( "Value not changed." );
      }
    }

    // Mutator method
    // Allows client to add miles driven and gallons of gas used
    //  to current values;
    // prints error messages if new values are less than 0
    public void addMileage( int newMilesDriven,
                            double newGallonsOfGas )
    {
      if ( newMilesDriven < 0 )
      {
         System.err.println( "Miles driven must be at least 0." );
         System.err.println( "Value not changed" );
         return;   // do not continue executing method
      }

      if ( newGallonsOfGas < 0.0 )
      {
         System.err.println( "Gallons of gas must positive." );
         System.err.println( "Value not changed" );
         return;  // do not continue executing method
      }

      // ok to change values
      milesDriven += newMilesDriven;  // add newMilesDriven
      gallonsOfGas += newGallonsOfGas; // add newGallonsOfGas
    }

    // Calculates mileage as miles per gallon.
    //  If no gallons of gas have been used, returns 0.0;
    //  Otherwise, returns miles per gallon
    //        as milesDriven / gallonsOfGas
    public double calculateMilesPerGallon( )
    {
      if ( gallonsOfGas != 0.0 )
         return milesDriven / gallonsOfGas;
      else
         return 0.0;
    }

    public static void clearNumberAutos( )
    {
        numberAutos = 0;
    }

    public String toString( )
    {
      DecimalFormat gallonsFormat = new DecimalFormat( "##.0" );
      return "Model: " + model
           + " Miles driven: " + milesDriven
           + " Gallons of gas: "
           + gallonsFormat.format( gallonsOfGas );
    }

    public void draw( Graphics g, int startX, int endX, int y)
    {}

  void getMilesDriven(int maximum)
  {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

 } // end Auto class definition
