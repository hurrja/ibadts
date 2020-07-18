package ibadts;

public class IBCollection <T>
{
  public IBCollection ()
  {
    collection = new java.util.ArrayList <T> ();
  }
      
  // initialize the collection from an array of elements
  public void initialize (T[] values)
  {
    for (T value : values)
      addItem (value);
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
  
  private java.util.Collection collection;
  private java.util.Iterator <T> iterator;
}
