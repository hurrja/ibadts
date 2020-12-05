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

import ibadts.Container;

public class Stack<T> extends Container<T>
{
  public Stack ()
  {
    stack = new java.util.Stack<T> ();
  }

  public void push (T item)
  {
    stack.push (item);
  }

  public T pop ()
  {
    return stack.pop ();
  }

  // ---------------------------------------------------------------
  // implementation details

  protected void add (T item)
  {
    push (item);
  }

  protected java.util.Collection getContainer ()
  {
    return stack;
  }

  private java.util.Stack<T> stack;
}
