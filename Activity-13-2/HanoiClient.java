/* HanoiClient
 *  Anderson, Franceschi
 */

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.Graphics;

public class HanoiClient extends JFrame
{
  private TowersOfHanoi tOfH;
  boolean started = false;

  public HanoiClient()
  {
    tOfH = new TowersOfHanoi(4);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 300);
    setVisible(true);
  }

  public TowersOfHanoi getTOfH()
  {
    return tOfH;
  }

  public void setStarted(boolean b)
  {
    started = b;
  }

  public void recursiveTOfH(int numDisks, int fromTower, int toTower, int useTower)
  {
    // ***** Student writes the body of this method *****
    //
    // Using recursion, transfer numDisks disks from the tower
    // fromTower to the tower toTower using the tower
    // useTower

    // The disks are numbered as follows: if we started with n disks,
    // the disk at the top is disk # 1
    // and the disk at the bottom is disk # n
    // We call the moveDisk method inside the body of this method
    // The moveDisk method moves one disk and takes 3 arguments:
    // an int, representing the disk number to be moved
    // an int, representing the tower to move the disk from
    // an int, representing the tower to move the disk to
    // So if these three variables are:
    // diskNumber, fromTower, and toTower
    // then the call to moveDisks will be:
    // moveDisk(diskNumber, fromTower, toTower);
    if (numDisks > 0)
    {
      // Student code starts here:

      // 1. Move (numDisks - 1) disks  from fromTower
      //   to useTower using toTower

      recursiveTOfH(numDisks - 1, fromTower, useTower, toTower);

      // 2. Move one disk from fromTower to toTower
      //   Print a message to the screen, then
      //   call moveDisk in order to animate.
      
      String moveMessage =
          "Move disk " + numDisks +
          " from tower " + fromTower +
          " to tower " + toTower;
        System.out.println(moveMessage);
        
        moveDisk(numDisks, fromTower, toTower);

      // 3. Move (numDisks - 1) disks from useTower to toTower
      //   using fromTower

      recursiveTOfH(numDisks - 1, useTower, toTower, fromTower);

    }

    // Base case:  0 disks to move ==> do nothing
    //
    // Student code ends here.
  }

  public void moveDisk(int diskNumber, int fromTower, int toTower)
  {
    repaint();
    try
    {
      Thread.sleep(1000);      // wait for the animation to finish
    }
    catch (Exception e)
    {
    }
    // update parameters
    tOfH.updateTowers(diskNumber, fromTower, toTower);
  }

  public void paint(Graphics g)
  {
    if (started)
    {
      super.paint(g);
      tOfH.draw(g);
    }
  }

  public int getNumberOfDisks()
  {
    boolean goodInput = false;
    int numberDisks = 4;  // will be reassigned - default is 4
    while (!goodInput)
    {
      try
      {
        String answer = JOptionPane.showInputDialog(null, "Enter number of disks between 1 and 9");
        if (answer != null)
        {
          numberDisks = Integer.parseInt(answer);
          goodInput = true;
        }
        else
        {
          System.exit(0);
        }
      }
      catch (Exception e)
      {
      }
    }
    return numberDisks;
  }

  public static void main(String[] args)
  {
    HanoiClient app = new HanoiClient();
    // ask user for number of disks
    while (true)
    {
      int numDisks = app.getNumberOfDisks();
      (app.getTOfH()).setDisks(numDisks);
      app.setStarted(true);
      // start
      app.recursiveTOfH((app.getTOfH()).getDisks(), 0, 2, 1);
      // finish last step in animation
      app.repaint();
      System.out.println("Done\n");
      // done

      try
      {
        Thread.sleep(5000);      // wait for the animation to finish
      }
      catch (Exception e)
      {
      }
      JOptionPane.showMessageDialog(null, "Done");
    }
  }
}
