// Copyright (C) 2020-2021 Jarmo Hurri

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

public class BinaryTree<T extends Comparable<T>>
{
  public BinaryTree ()
  {
    node = null;
    leftTree = null;
    rightTree = null;
  }

  public void add (T value)
  {
    size++;
    addTo (this, value);
  }
  
  public int getSize ()
  {
    return size;
  }

  public boolean isEmpty ()
  {
    return size == 0;
  }

  public Queue<T> preorder ()
  {
    Queue<T> queue = new Queue<> ();
    preorder (this, queue);
    return queue;
  }

  protected void preorder (BinaryTree<T> tree, Queue<T> queue)
  {
    if (tree.leftTree != null)
      preorder (tree.leftTree, queue);

    if (node != null)
      queue.enqueue (tree.node);

    if (tree.rightTree != null)
      preorder (tree.rightTree, queue);
  }
  
  protected BinaryTree<T> addTo (BinaryTree<T> tree, T value)
  {
    if (tree == null)
    {
      BinaryTree<T> newTree = new BinaryTree<> ();
      newTree.node = value;
      return newTree;
    }
    else
    {
      if (tree.node == null)
        tree.node = value;
      else if (value.compareTo (tree.node) < 0)
        tree.leftTree = addTo (tree.leftTree, value);
      else
        tree.rightTree = addTo (tree.rightTree, value);

      return tree;
    }
  }

  private T node;
  private BinaryTree<T> leftTree;
  private BinaryTree<T> rightTree;
  private int size = 0;
}
