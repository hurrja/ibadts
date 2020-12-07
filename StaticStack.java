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

import ibadts.StaticContainer;

public class StaticStack<T> extends StaticContainer<T>
{
  public StaticStack (int capacity)
  {
    super (capacity);
    stack = new Stack<T> ();
  }

  public void push (T item)
  {
    preIncreaseCheckCapacity ();

    stack.push (item);
    size++;
  }

  public T pop ()
  {
    size--;
    return stack.pop ();
  }

  protected void add (T item)
  {
    push (item);
  }

  protected java.util.Collection<T> getContainer ()
  {
    return stack.getContainer ();
  }

  private Stack<T> stack;
}
