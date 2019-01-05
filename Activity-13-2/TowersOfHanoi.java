/* TowersOfHanoi
*  Anderson, Franceschi
*/

   import javax.swing.JFrame;
   import java.awt.Graphics;
   import java.awt.Color;
   import java.util.ArrayList;

    public class TowersOfHanoi
   {
   // constants for Towers' parameters
      private static final int TOWER_LENGTH = 200;
   
   // x coordinates of towers
      private static final int XT1 = 100;
      private static final int XT2 = 250;
      private static final int XT3 = 400;
   
   // y coordinate of the top of the towers
      private static final int YT = 250;
   
   // height of the disks
      private static final int HD = 15;
   
   // coefficient of expansion for the width of the disks
      private static final int WDC = 15;
   
   // int array representing the disks on the tower
      int [][] towers;
   // int array representing the top disk in each tower
      int [] top;
   
   // Number of disks
      private int disks;
   
       public TowersOfHanoi( int d )
      {
         setDisks( d );
      }
   
       public void setTowers( int [][] t )
      {
         towers = t;
      }
   
       public int [][] getTowers( )
      {
         return towers;
      }
   
       public void setTop( int [] t )
      {
         top = t;
      }
   
       public int [] getTop( )
      {
         return top;
      }
   
       public void setDisks( int d )
      {
         if ( d >= 1 && d <= 9 )
            disks = d;
         else
            disks = 4;
      
         towers = new int[3][disks];
      // put all disks inside tower 1 to start
         for ( int i = 0; i < disks; i++ )
            towers[0][i] = disks - i;
         top = new int[3];
         top[0] = disks - 1;  // index of top disk on tower 0
         top[1] = -1;   // index of top disk on tower 1
         top[2] = -1;   // index of top disk on tower 2
      }
   
       public int getDisks( )
      {
         return disks;
      }
   
       public void printMe( )
      {
         System.out.println( "Tower 0" );
         for ( int i = 0 ; i <= top[0]; i++ )
            System.out.print( towers[0][i] + " " );
         System.out.println( "\ttop = " + top[0] );
         System.out.println( "Tower 1" );
         for ( int i = 0 ; i <= top[1]; i++ )
            System.out.print( towers[1][i] + " " );
         System.out.println( "\ttop = " + top[1] );
         System.out.println( "Tower 2" );
         for ( int i = 0 ; i <= top[2]; i++ )
            System.out.print( towers[2][i] + " " );
         System.out.println( "\ttop = " + top[2] );
         System.out.println( );
      }
   
       public void updateTowers( int diskNumber, int fromTower, int toTower )
      {
         if ( enforceRules( diskNumber, fromTower, toTower ) )
         {
         // update toTower
            towers[toTower][top[toTower] + 1] = diskNumber;
            top[toTower] = top[toTower] + 1;
         // update fromTower
            towers[fromTower][top[fromTower]] = 0;
            top[fromTower] = top[fromTower] - 1;
         }
         else
         {
            System.out.println( "Illegal Move:  action cancelled" );
         }
      }
   
       public boolean enforceRules( int diskNumber, int fromTower, int toTower )
      {
         boolean rule = true;
         if ( fromTower < 0 || fromTower > 2 )
            rule = false;
         else if ( toTower < 0 || toTower > 2 )
            rule = false;
         else if ( fromTower == toTower )
         {
            rule = false;
            System.out.println( "Trying to move a disk within one tower" );
         }
         else if ( top[fromTower] == -1 )        // fromTower empty
         {
            rule = false;
            System.out.println( "Trying to move a disk from tower " + fromTower + " which is empty" );
         }
         else if ( top[toTower] == ( disks - 1 ) ) // toTower full
         {
            rule = false;
            System.out.println( "Trying to move a disk to tower " + toTower + " which is full" );
         }
         else if ( top[toTower] != - 1 && diskNumber != towers[fromTower][top[fromTower]] ) // not correct disk
         {
            rule = false;
            System.out.println( "Trying to move a disk which is not at the top of its tower" );
         }
         else if ( top[toTower] != -1 && towers[toTower][top[toTower]] != 0  && diskNumber > towers[toTower][top[toTower]] ) // big disk on top of small disk
         {
            rule = false;
            System.out.println( "Trying to place a disk on top of a smaller disk" );
         }
         else if ( towers[fromTower][top[fromTower]] != diskNumber )
         {
            rule = false;
            System.out.println( "Trying to move a disk not on top of a tower" );
         }
         return rule;
      }
   
       public void draw( Graphics g )
      {
         g.setColor( Color.BLUE );
      // display tower 1
         g.drawLine( XT1, YT + HD, XT1, YT - TOWER_LENGTH );
      // display tower 2
         g.drawLine( XT2, YT + HD, XT2, YT - TOWER_LENGTH );
      // display tower 3
         g.drawLine( XT3, YT + HD, XT3, YT - TOWER_LENGTH );
      
      // display tower numbers
         g.drawString( "0", XT1 - 3, YT + 35 );
         g.drawString( "1", XT2 - 3, YT + 35 );
         g.drawString( "2", XT3 - 3, YT + 35 );
      
      // display disks on tower 1
         for ( int i = 0; i <= top[0]; i++ )
         {
            g.setColor( Color.RED );
            g.fillRoundRect( XT1 - ( WDC * towers[0][i] )/2 ,YT - i * ( HD + 2 ), WDC * towers[0][i], HD, 10, 10 );
            g.setColor( Color.BLACK );
            g.drawString( "" + towers[0][i], XT1 - 3, YT - i * ( HD + 2 ) + 3 * HD / 4 );
         }
      
      // display disks on tower 2
         for ( int i = 0; i <= top[1]; i++ )
         {
            g.setColor( Color.RED );
            g.fillRoundRect( XT2 - ( WDC * towers[1][i] )/2 ,YT - i * ( HD + 2 ), WDC * towers[1][i], HD, 10, 10 );
            g.setColor( Color.BLACK );
            g.drawString( "" + towers[1][i], XT2 - 3, YT - i * ( HD + 2 ) + 3 * HD / 4 );
         }
      
      // display disks on tower 3
         for ( int i = 0; i <= top[2]; i++ )
         {
            g.setColor( Color.RED );
            g.fillRoundRect( XT3 - ( WDC * towers[2][i] )/2 ,YT - i * ( HD + 2 ), WDC * towers[2][i], HD, 10, 10 );
            g.setColor( Color.BLACK );
            g.drawString( "" + towers[2][i], XT3 - 3, YT - i * ( HD + 2 ) + 3 * HD / 4 );
         }
      }
   }