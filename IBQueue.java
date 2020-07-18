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

import ibadts.IBContainer;

public class IBQueue<T> extends IBContainer<T>
{
  public IBQueue ()
  {
    queue = new java.util.LinkedList<T> ();
  }

  public void enqueue (T item)
  {
    queue.add (item);
  }

  public T dequeue ()
  {
    return queue.remove ();
  }

  // ---------------------------------------------------------------
  // implementation details

  protected void add (T item)
  {
    enqueue (item);
  }

  protected java.util.Collection getContainer ()
  {
    return queue;
  }

  private java.util.Queue<T> queue;
}
