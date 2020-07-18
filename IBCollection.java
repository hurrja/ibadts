package ibadts;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

public class IBCollection <T>
{
  public IBCollection ()
  {
    collection = new ArrayList <T> ();
  }
      
  public void addItem (T item)
  {
    collection.add (item);
  }
  
  public T getNext ()
  {
    ensureIteratorInit ();
    return iterator.next ();
  }
  
  public void resetNext ()
  {
    iterator = collection.iterator ();
  }
  
  public boolean hasNext ()
  {
    ensureIteratorInit ();
    return iterator.hasNext ();
  }
  
  public boolean isEmpty ()
  {
    return collection.size () == 0;
  }

  private void ensureIteratorInit ()
  {
    if (iterator == null)
      resetNext ();
  }
  
  private Collection collection;
  private Iterator <T> iterator;
}
