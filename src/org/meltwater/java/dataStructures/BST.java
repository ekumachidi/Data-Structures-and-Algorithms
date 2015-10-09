package org.meltwater.java.dataStructures;
import java.util.*;

public class BST <E extends Comparable<E>> implements Iterable<E>
{
   private Node<E> root;
   private Comparator<E> comparator;

   public BST()
   {
      root = null;
      comparator = null;
   }

   public BST(Comparator<E> comp)
   {
      root = null;
      comparator = comp;
   }

   private int compare(E x, E y)
   {
      if(comparator == null) return x.compareTo(y);
      else
      return comparator.compare(x,y);
   }

   /**
	 * add(E element) -> Adds element to the tree.
	 * the operation takes constant time O(1) 
	 * @param id
	 */
   public void add(E element)
   {
      root = insert(root, element);
   }
   private Node<E> insert(Node<E> p, E toInsert)
   {
      if (p == null)
         return new Node<E>(toInsert);

      if (compare(toInsert, p.data) == 0)
      	return p;

      if (compare(toInsert, p.data) < 0)
         p.left = insert(p.left, toInsert);
      else
         p.right = insert(p.right, toInsert);

      return p;
   }

   /**
	 * size() -> Returns the total number of nodes in the tree. 
	 * @return
	 */
	public int size() {
		return size();
	}
	
   
	/**
	 * contains(E element) -> Returns true if element is in tree, false otherwise. 
	 * @param id
	 * @return
	 * the operation takes constant time O(1)
	 */
	public boolean contains(int id){
		Node current = root;
		while(current!=null){
//			if(current.data==id){
//				return true;
//			}else if(current.data>id){
//				current = current.left;
//			}else{
//				current = current.right;
//			}
		}
		return false;
	}
	
   /**
	 * rcontains(E element)
	 * Recursively searches for element in tree.
	 * Returns true if found, false otherwise.
	 * @param element
	 * @return
	 */
   public boolean search(E element)
   {
      return search(root, element);
   }
   private boolean search(Node<E> p, E toSearch)
   {
      if (p == null)
         return false;
      else
      if (compare(toSearch, p.data) == 0)
      	return true;
      else
      if (compare(toSearch, p.data) < 0)
         return search(p.left, toSearch);
      else
         return search(p.right, toSearch);
   }
   /**
	 * remove(E element) -> Removes element from the tree. 
	 * @param id
	 * @return
	 * the operation takes constant time O(1)
	 */
   public void delete(E element)
   {
      root = delete(root, element);
   }
   private Node<E> delete(Node<E> p, E toDelete)
   {
      if (p == null)  throw new RuntimeException("cannot delete.");
      else
      if (compare(toDelete, p.data) < 0)
      p.left = delete (p.left, toDelete);
      else
      if (compare(toDelete, p.data)  > 0)
      p.right = delete (p.right, toDelete);
      else
      {
         if (p.left == null) return p.right;
         else
         if (p.right == null) return p.left;
         else
         {
         // get data from the rightmost node in the left subtree
            p.data = retrieveData(p.left);
         // delete the rightmost node in the left subtree
            p.left =  delete(p.left, p.data) ;
         }
      }
      return p;
   }
   private E retrieveData(Node<E> p)
   {
      while (p.right != null) p = p.right;

      return p.data;
   }

   /**
    * toString()
    * Returns a nice String representation of the node values, sorted in ascending order.
    */
   public String toString()
   {
      StringBuffer sb = new StringBuffer();
      for(E data : this) sb.append(data.toString());

      return sb.toString();
   }

   /**
    * Tree Iterator
    */
   public Iterator<E> iterator()
   {
      return new MyIterator();
   }
   //pre-order
   /**
    * MyIterator class, implements java iterator
    * @author mest
    *
    */
   private class MyIterator implements Iterator<E>
   {
      Stack<Node<E>> stk = new Stack<Node<E>>();

      public MyIterator()
      {
         if(root != null) stk.push(root);
      }
      public boolean hasNext()
      {
         return !stk.isEmpty();
      }

      public E next()
      {
         Node<E> cur = stk.peek();
         if(cur.left != null)
         {
            stk.push(cur.left);
         }
         else
         {
            Node<E> tmp = stk.pop();
            while( tmp.right == null )
            {
               if(stk.isEmpty()) return cur.data;
               tmp = stk.pop();
            }
            stk.push(tmp.right);
         }

         return cur.data;
      }//end of next()

      public void remove()
      {

      }
   }//end of MyIterator

   /**
    * The Node Class
    * @author mest
    * @param <T>
    */
   private class Node<T>
   {
      private T data;
      private Node<T> left, right;

      public Node(T data, Node<T> l, Node<T> r)
      {
         left = l; right = r;
         this.data = data;
      }

      public Node(T data)
      {
         this(data, null, null);
      }

      public String toString()
      {
         return data.toString();
      }
   } //end of Node
}//end of BST