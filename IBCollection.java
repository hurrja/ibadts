// Copyright (C) 2020 Jarmo Hurri

// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.

// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <https://www.gnu.org/licenses/>.

package ibadts;

public class IBCollection <T>
{
  public IBCollection ()
  {
    collection = new java.util.ArrayList <T> ();
  }
      
  // initialize the collection from an array of elements
  public void addItems (T[] items)
  {
    for (T item : items)
      addItem (item);
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
    return collection.isEmpty ();
  }

  private void ensureIteratorInit ()
  {
    if (iterator == null)
      resetNext ();
  }
  
  private java.util.Collection collection;
  private java.util.Iterator <T> iterator;
}
