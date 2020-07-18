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

import java.util.Collection;

public abstract class IBContainer<T>
{
  protected IBContainer ()
  {
  }

  // add an array of elements
  public void add (T[] items)
  {
    for (T item : items)
      add (item);
  }
  
  public boolean isEmpty ()
  {
    return getContainer ().isEmpty ();
  }

  protected abstract void add (T item);
  
  protected abstract Collection getContainer ();
}
