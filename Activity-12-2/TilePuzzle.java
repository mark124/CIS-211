 /* TilePUzzle class
    Anderson, Franceschi
 */

 public class TilePuzzle
 {
  private int side; // grid size for game 1
  private String[][] tiles;
  private int emptyRow;
  private int emptyCol;

  public TilePuzzle( int newSide )
  {
   setUpGame( newSide );
  }

  public void setUpGame( int newSide )
  {
   if ( side > 0 )
     side = newSide;
   else
     side = 3;
   side = newSide;
   tiles = new String[side][side];
   emptyRow = side - 1;
   emptyCol = side - 1;

   for ( int i = 0; i < side; i++ )
   {
    for ( int j = 0; j < side; j++ )
    {
     tiles[i][j] = String.valueOf( ( side * side )
                             - ( side * i + j + 1 ) );
    }
   }
   // set empty tile to blank
   tiles[side - 1][side - 1] = "";
  }

  public int getSide( )
  {
    return side;
  }
/*
  public int getEmptyRow( )
  {
    return emptyRow;
  }

  public int getEmptyCol( )
  {
    return emptyCol;
  }
*/
  public String[][] getTiles( )
  {
    return tiles;
  }

  public boolean tryToPlay( int row, int col )
  {
   if ( possibleToPlay( row, col ) )
   {
    // play: switch empty String and tile label at row, col
    tiles[emptyRow][emptyCol] = tiles[row][col];
    tiles[row][col] = "";

    emptyRow = row;
    emptyCol = col;
    return true;
   }
   else
    return false;
  }

  public boolean possibleToPlay( int row, int col )
  {
   if ( ( col == emptyCol && Math.abs( row - emptyRow ) == 1 )
          || ( row == emptyRow && Math.abs( col - emptyCol ) == 1 ) )
     return true;
   else
     return false;
  }

  public boolean won( )
  {
   for ( int i = 0; i < side ; i++ )
   {
    for ( int j = 0; j < side; j++ )
    {
      if ( !( tiles[i][j].equals(
                        String.valueOf( i * side + j + 1 ) ) )
                        && ( i != side - 1 || j != side - 1 ) )
        return false;
    }
   }
   return true;
  }

 }
