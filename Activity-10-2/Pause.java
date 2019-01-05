/* Pause class to pause applications
   Anderson, Franceschi
   Mark Johnson
*/

public class Pause
{
	public static void wait( double time )
	{
	   try {
			Thread.sleep(  ( int ) ( time * 1000 ) );
	   }
	   catch ( InterruptedException e )
	   {
			e.printStackTrace();
	   }
	}
}
