/* Reverse File Stack
   Mark Johnson
*/

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

public class ReverseFileViaStack extends JFrame
  implements ActionListener
{
  // Everything in your class (see below).

// Fonts:
private final Font fontBold = new Font(Font.DIALOG, Font.BOLD, 14);
private final Font fontPlain = new Font(Font.DIALOG, Font.PLAIN, 14);

// Lists:
private JList<String>list1;
private JList<String>list2;

// List models:
private DefaultListModel<String> listModel1 = new DefaultListModel<>();
private DefaultListModel<String> listModel2 = new DefaultListModel<>();


private JLabel lblList1;
private JLabel lblList2;

private JButton btnRead;
private JButton btnReverse;
private JButton btnWrite;

private JPanel contents;
private Box boxList1 = Box.createVerticalBox();
private Box boxList2 = Box.createVerticalBox();
private JPanel panelCenter;
private JPanel panelSouth;

private Border borderCenter = BorderFactory.createEmptyBorder(10, 10, 10, 10);
private Border borderContents = BorderFactory.createEmptyBorder(0, 10, 10, 10);
private Border borderList = BorderFactory.createLineBorder(Color.BLUE, 1);

private Stack<String> stack = new Stack<>();

// Constructor.
public ReverseFileViaStack()
{
  // It should setup the entire UI.
//------------------------------------------------------------------------------
  super("Reverse Text File via Stack");
  setFonts();
  
  // Here are a few tricky parts:
  listModel1 = new DefaultListModel();
  list1 = new JList<>(listModel1);

  listModel2 = new DefaultListModel();
  list2 = new JList<>(listModel2);

  
  contents = new JPanel();
  contents.setBorder(borderContents);
  contents.setLayout(new BorderLayout());
  setContentPane(contents);

  // North region:
  JLabel lblTitle = new JLabel("Reverse Text File via Stack", SwingConstants.CENTER);
  lblTitle.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
  contents.add(lblTitle, BorderLayout.NORTH);

  // Center region:
  panelCenter = new JPanel();
  panelCenter.setBorder(borderCenter);

  lblList1 = new JLabel("Original order:");
  lblList1.setAlignmentX(LEFT_ALIGNMENT);

  JScrollPane scrollList1 = new JScrollPane(list1);
  scrollList1.setAlignmentX(LEFT_ALIGNMENT);
  scrollList1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
  setSpecificSize(scrollList1, new Dimension(250, 300));

  boxList1.add(lblList1);
  boxList1.add(scrollList1);
  panelCenter.add(boxList1);

  panelCenter.add(Box.createRigidArea(new Dimension(70, 1)));

  lblList2 = new JLabel("Reversed order:");
  lblList2.setAlignmentX(LEFT_ALIGNMENT);

  JScrollPane scrollList2 = new JScrollPane(list2);
  scrollList2.setAlignmentX(LEFT_ALIGNMENT);
  scrollList2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
  setSpecificSize(scrollList2, new Dimension(250, 300));

  boxList2.add(lblList2);
  boxList2.add(scrollList2);
  panelCenter.add(boxList2);

  contents.add(panelCenter, BorderLayout.CENTER);

  // South region:
  panelSouth = new JPanel();
  btnRead = new JButton("Read");
  btnReverse = new JButton("Reverse");
  btnReverse.setEnabled(false);
  btnWrite = new JButton("Write");
  btnWrite.setEnabled(false);
  panelSouth.add(btnRead);
  panelSouth.add(Box.createRigidArea(new Dimension(70, 1)));
  panelSouth.add(btnReverse);
  panelSouth.add(Box.createRigidArea(new Dimension(70, 1)));
  panelSouth.add(btnWrite);
  contents.add(panelSouth, BorderLayout.SOUTH);

  btnRead.addActionListener(this);
  btnReverse.addActionListener(this);
  btnWrite.addActionListener(this);

  setSize(700, 450);
  setVisible(true);
  
}
//------------------------------------------------------------------------------


// Button handler.
// Calls the appropriate function based on which button was clicked.

public void actionPerformed(ActionEvent e)
{
  Object source = e.getSource();
  if (source == btnRead)
  {
    readFile();
    return;
  }
  if (source == btnReverse)
  {
    reverseFile();
    return;
  }
  if (source == btnWrite)
  {
    writeFile();
    return;
  }
}

// Reads the input text file line-by-line.
// Adds each line it gets to the left list box.
// To add each item (line) to the left list box, use its list model
// addElement function.
private void readFile()
{
  String fileName = "input.txt";
  File file = new File(fileName);
  Scanner fileScanner;
  try
  {
    fileScanner = new Scanner(file);
  }
  catch(FileNotFoundException fnfe)
  {
    System.out.println("Unable to find the text file.");
    return;
  }
  
  while(fileScanner.hasNextLine())
    {
      String string = fileScanner.nextLine();
      listModel1.addElement(string);
      //listModel1.addItem();    
    }
   //comboBox.addItem();
   fileScanner.close();
   btnRead.setEnabled(false);
   btnReverse.setEnabled(true);
}
// Pushes each item from the left list onto the stack.
// This uses the stack's push function.
// To read each item in the left list box, use its list model
// elementAt function (with a loop index).
// Then pops the items from the stack one-by-one and adds each of them
// to the right list.
// This uses the stack's pop function.
// To add each item (line) to the right list box, use its list model
// addElement function.
// This results in the right list being in reverse order of the left.
private void reverseFile()
{
  if (!stack.isEmpty())
  {
    stack.empty();
  }
  for (int i = 0; i < listModel1.size(); i++)
  {
   stack.push(listModel1.getElementAt(i));
  }

  if (!stack.isEmpty())
  {
    for (int i = listModel1.size() - 1; i >= 0; i--)
    {
      listModel2.addElement(stack.get(i));
    }
  btnReverse.setEnabled(false);
  btnWrite.setEnabled(true);
  }
}

// See the video.
private void setFonts()
{
  UIManager.put("Button.font", fontBold);
  UIManager.put("ComboBox.font", fontBold);
  UIManager.put("Label.font", fontBold);
  UIManager.put("List.font", fontPlain);
}

// See the video.
private void setSpecificSize(JComponent component,
                             Dimension dimension)
{
  component.setMinimumSize(dimension);
  component.setPreferredSize(dimension);
  component.setMaximumSize(dimension);
}

// Reads through the right list item-by-item.
// Uses a PrintWriter to write these items to the output file.
// Be sure to close the PrintWriter.
private void writeFile()
{
   String fileName = "output.txt";
   File file = new File(fileName);
   PrintWriter writer;

   try
   {
     writer = new PrintWriter(file);
   }
   catch (FileNotFoundException fnfe)
   {
     System.out.println("Unable to create output file: " + fileName);
     return;
   }

   int size = listModel2.getSize();

   for (int i = 0; i < size; i++)
   {
     writer.println(listModel2.elementAt(i));
   }
   writer.close();
   btnWrite.setEnabled(false);
}

// The main function.
public static void main(String[] args)
{
  ReverseFileViaStack gui = new ReverseFileViaStack();
  gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

}
