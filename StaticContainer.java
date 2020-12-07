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

public abstract class StaticContainer<T> extends Container<T>
{
  public boolean isFull ()
  {
    return size == capacity;
  }
  
  protected StaticContainer (int capacity)
  {
    this.capacity = capacity;
    size = 0;
  }

  protected void preIncreaseCheckCapacity ()
  {
    if (isFull ())
      throw new StaticCapacityExceededError ("stack capacity exceeded");
  }
  
  protected int capacity;
  protected int size;
}
