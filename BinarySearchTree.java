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
import java.util.List;
import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>>
{
  public BinarySearchTree ()
  {
    node = null;
    left = null;
    right = null;
  }

  public void add (T value)
  {
    addTo (this, value);
  }

  public void add (T[] values)
  {
    for (T v : values)
      add (v);
  }
  
  protected BinarySearchTree<T> addTo (BinarySearchTree<T> tree, T value)
  {
    if (tree == null)
    {
      tree = new BinarySearchTree<> ();
      tree.node = value;
    }
    else
    {
      if (tree.node == null)
        tree.node = value;
      else
      {
        int cmpResult = value.compareTo (tree.node);
        if (cmpResult == 0)
          return tree; // special case: value already in tree, no change to tree
        else if (cmpResult < 0)
          tree.left = addTo (tree.left, value);
        else
          tree.right = addTo (tree.right, value);
      }
    }

    tree.size++;
    return tree;
  }

  public int getSize ()
  {
    return size;
  }

  public boolean isEmpty ()
  {
    return size == 0;
  }

  public boolean find (T value)
  {
    BinarySearchTree<T> tree = this;
    boolean found = false;
    
    while (!found && tree != null && tree.node != null)
    {
      int cmpResult = value.compareTo (tree.node);
      if (cmpResult == 0)
        found = true;
      else if (cmpResult < 0)
        tree = tree.left;
      else
        tree = tree.right;
    }

    return found;
  }

  public Iterable<T> inorder ()
  {
    List<T> list = new ArrayList<> (size);
    inorder (this, list);
    return list;
  }

  protected void inorder (BinarySearchTree<T> tree, List<T> list)
  {
    if (tree.left != null)
      inorder (tree.left, list);

    if (node != null)
      list.add (tree.node);

    if (tree.right != null)
      inorder (tree.right, list);
  }
  
  public Iterable<T> postorder ()
  {
    List<T> list = new ArrayList<> (size);
    postorder (this, list);
    return list;
  }

  protected void postorder (BinarySearchTree<T> tree, List<T> list)
  {
    if (tree.left != null)
      postorder (tree.left, list);

    if (tree.right != null)
      postorder (tree.right, list);

    if (node != null)
      list.add (tree.node);
  }
  
  public Iterable<T> preorder ()
  {
    List<T> list = new ArrayList<> (size);
    preorder (this, list);
    return list;
  }

  protected void preorder (BinarySearchTree<T> tree, List<T> list)
  {
    if (node != null)
      list.add (tree.node);

    if (tree.left != null)
      preorder (tree.left, list);

    if (tree.right != null)
      preorder (tree.right, list);
  }
  
  private T node;
  private BinarySearchTree<T> left;
  private BinarySearchTree<T> right;
  private int size = 0;
}
