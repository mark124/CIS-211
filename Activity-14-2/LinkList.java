/* LinkList
   Anderson, Franceschi
   Mark Johnson
*/

/**
 * this class is a concrete implementation of the AbstractList.
 *
 * properties of this implementation are such that: - the list is singly linked
 * - data contained in the nodes is limited to integers - nodes are sorted in
 * ascending order of data - duplicate data is allowed - note that duplicate
 * data may cause inconsistent behavior in the Visualizer because the delete
 * method searches for the first instance of data. if a node besides the first
 * one is highlighted, the first one will still be deleted.
 */
public class LinkList extends AbstractList
{
  private Node head = null;

  public LinkList()
  {
    super(500, 400);
    v.drawList(head);
  }

  public LinkList(Node head)
  {
    super(500, 400); // set size for visualizer
    // set up the list
    head = head;
    animate(head);
  }

  public void insert(int i)
  {
    // ***** Student writes the body of this method *****

    // code the insert method of a linked list of ints
    // the int to insert in the linked list is i

    // we call the animate method inside the body of this method
    // as you traverse the list looking for the place to insert,
    // call animate as follows:

    //    animate(head, current);
    // where    head is the instance variable head of the linked list
    //          current is the node that you are visiting

    // you can start coding now

    // in order to improve the animation (this is optional):
    // just before inserting, i.e. connecting the nodes,
    // make the call

    //    animate(head, previous, Visualizer.ACTION_INSERT_AFTER);

    // where    head is the instance variable head of the linked list
    //          previous is the node (not null) after which to insert

    // if you are inserting at the beginning of the list,
    // just before inserting, make the call

    //    animate(head, head, Visualizer.ACTION_INSERT_BEFORE);

    // where    head is the instance variable head of the linked list
    //
    // Part 1 student code starts here:

  Node current = head, previous = null;
  Node newNode = new Node(i);
  
  while(current != null)
  {
    animate(head, current);  
    if(current.getData() < i)
    {
      previous = current;
      current = current.getNext();
    }
    else
    {
      break;
    }
  }
  
  if(current == head) 
  {
    if(current == null)
    {
      head = newNode;
    }
    else
    {
      animate(head, head, Visualizer.ACTION_INSERT_BEFORE);
      newNode.setNext(head);
      head = newNode;
    }
  }
  
  else
  {
    animate(head, previous, Visualizer.ACTION_INSERT_AFTER);
    previous.setNext(newNode);
    newNode.setNext(current);
  }

    // Part 1 student code ends here.

    numberNodes++;
    // call animate again to show the status of the list
    animate(head);
  }

  public boolean delete(int i)
  {
    // ***** Student writes the body of this method *****

    // code the delete method of a linked list of ints
    // the int to delete in the linked list is i
    // if deletion is successful, return true
    // otherwise, return false

    // we call the animate method inside the body of this method
    // as you traverse the list looking for the node to delete,
    // call animate as follows:

    //    animate(head, current);

    // where    head is the instance variable head of the linked list
    //          current is the node that you are visiting

    // you can start coding now

    // in order to improve the animation (this is optional):
    // just before deleting, i.e. connecting the nodes,
    // make the call

    //    animate(head, current, Visualizer.ACTION_DELETE);

    // where    head is the instance variable head of the linked list
    //          current is the node that you are deleting
    //
    // Part 2 student code starts here:
  Node current = head, previous = null;
  while(current != null) //not end of list
  {
    animate(head, current);
    if(current.getData() == i) //found the node
    {
      animate(head, current, Visualizer.ACTION_DELETE);
      if(current == head)
      {
        head = current.getNext();
      }
      else
      {
        previous.setNext(current.getNext());
      }
        break;
    }
    else if(i > current.getData() )
    {
      previous = current;
      current = current.getNext();
    }
    else
    {
      return false;
    }
  }
  if(current == null)
  {
    return false;
  }      

    // Part 2 student code ends here.

    // At this point, the item has been deleted.
    // Decrement the number of nodes:
    numberNodes--;
    // Call animate again to show the status of the list:
    animate(head);
    return true;
  }

  public int count()
  {
    int n = 0;
    Node current = head;
    while (current != null)
    {
      animate(head, current);
      n++;
      current = current.getNext();
    }
    return n;
  }

  public void traverse()
  {
    traversal = "";
    Node current = head;
    while (current != null)
    {
      animate(head, current);
      traversal += (current.getData() + "  ");
      current = current.getNext();
    }
    v.drawList(head);
  }

  public void clear()
  {
    head = null;
    v.drawList(head);
  }

  public void animate(Node h, Node nd)
  {
    v.drawList(h, nd);
    delay(1000);
  }

  public void animate(Node h)
  {
    v.drawList(h);
  }

  public void animate(Node h, Node nd, int mode)
  {
    v.drawList(h, nd, mode);
    delay(1000);
  }
}
