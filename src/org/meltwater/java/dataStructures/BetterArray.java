package org.meltwater.java.dataStructures;

import java.util.Arrays;

public class BetterArray<E> {
	/**	Array of Generic items of type E
	*	BetterArray, an improved Java array that store an unlimited number of elements.
	*	The operation takes constant amortised time
	**/
	 
	public static void main(String[] args) {
		BetterArray array = new BetterArray();
	    array.add(2);
	    array.add(3);
	    array.insert(0, 1);
	    
	    int[] newElements = {4, 5, 6};
	    array.add(newElements);
	    
	    array.contains(2); // true
	    array.contains(10); // false

	    array.index(2); // 1
	    array.index(10); // -1 

	    array.get(1); // 2
	    array.get(10000); // ???
	    
	    System.out.println(array.contains(2));
		System.out.println("Size: " + array.size());
		System.out.println(array.toString());
	}
	
	  private static final int DEFAULT_SIZE = 10;
	  private E[] array; //An array of E i.e Elements of type E
	  private int size = 0; //Number of elements
	  
	  /**
	   *	Initialise an empty BetterArray 
	   */
	  public BetterArray() {
		// cast needed since no generic array creation in Java
		    array = (E[]) new Object[DEFAULT_SIZE];
		  }
	  
	  	/**
		 * Inserts the specified element in the specified position
		 * Input: Integer, Generic element
		 * Return type: void ; Big-O analysis: O(N)
		 */
		public void insert(int position, E element) {
			if (position < array.length) {
				this.array[position] = element;
				size++;
			} else {
				E[] newArray = (E[]) new Object[array.length * 2];
				for (int i = 0; i < array.length; i++) {
					newArray[i] = array[i];		
				}
				array = newArray;
				this.array[size++] = element;
			}			
		}
//		shift(E element) -> .
		/**
		 * Insert element at the start of the array, usually position 0
		 * and pushes all other elements back.
		 * @param element is the input of Generic type
		 * Big-O Analysis is O(N)
		 */
		public void shift(E element) {
			if (isEmpty()) {
				insert(0, element);
			} else {
				for (int i = size; i >= 0; i--) {
					array[i + 1] = array[i];
				}
				insert(0, element);
			}
		}	  
    
	/**
	 * Resize and assert capacity
	 * @param capacity
	 */
	  private void resize(int capacity) {
	        assert capacity >= size;
	        E[] temp = (E[]) new Object[capacity];
	        for (int i = 0; i < size; i++)
	            temp[i] = array[i];
	        array = temp;
	    }
	  
	  /**
	   * append(E element)->Append element to the end of the array.
	   * accepts @param element
	   */
	  public void add(E element) {
	        if (size == array.length) resize(2*array.length);    // double size of array if necessary
	        array[size++] = element;                            // add item
	    }
	  public void append(E element) {
			if (isEmpty()) {
				shift(element);
			} else {
				for (int i = 1; i <= size; i++) {
					array[i - 1] = array[i];
				}
				size--;
				insert(size, element);
			}
		}
    
	  /**
	   * index(E element)->Return the index of element in the array.
	   * @param element
	   * @return
	   */
	  public int index(E element) {
			for (E i : array) {
				if (i == element) {
					return Arrays.asList(array).indexOf(i);
				}
			}
			return -1;
		}
    
	  /**
	   * contains(E element) -> Returns true if element is in array, false otherwise
	   * contains is defined in terms of index.
	   * @param element
	   * @return
	   */
	  public boolean contains(E element) {
			for(E i: array){
				if(i == element){
					return true;
				}
			}
			return false;
		}
	  
	  /**
	   * get(int index) -> Returns element at position index.
	   * If index is less than 0 or greater than maximum position occupied by an element, 
	   * throw an appropriate exception.
	   * @param index
	   * @return
	   */
	  public E get(int index){
		    if(index > size){throw new RuntimeException("Invalid index");}
		    E element = (E) array[index];
		    return element;
		}
	  
	  /**
	   * size() -> Returns the total number of elements in the array.
	   * size operation takes constant time 
	   * @return
	   */
	  public int size() {
		return size;
	}
	  
	  /**
	   * Is this queue empty?
	   * isEmpty() -> Returns true if array has no elements, false otherwise.
	   * the isEmpty operation takes constant time
	   * @return true if this queue is empty; false otherwise
	   */
	  public boolean isEmpty() {
	        return size == 0;
	    }
	  
	  /**
	   * remove(int index) -> Delete element at position index. 
	   * @param index
	   * @return
	   * Big-O: O(1) i.e takes constant time to execute
	   */
	  public E remove(int index){
		    if(index>=size || index < 0 ){throw new RuntimeException("Invalid index");}
		    E element = (E) array[index];
		    --size;
		    System.arraycopy(array, index + 1, array, index, size - index);
		    array[size] = null;
		    return element;
		}
//	  public E remove(int index) {
//			if (index >= size || index < 0) {
//				throw new RuntimeException("Invalid index");
//			}
//			E element = (E) array[index];
//			array[index] = null;
//			--size;
//			return element;
//		}
	  
    
	  /**
	   * remove(E element)
	   * Remove all occurrences of element from the array. 
	   * @param element
	   * Big-O: O(N)
	   */
	  public void remove(E element) {
			for (E x : array) {
				if (x == element) {
					remove(Arrays.asList(array).indexOf(x));
				}
			}
		}
	  
	  /**
	   * reverse() -> Reverses the array 
	   * Big-O: O(N)
	   */
	  public void reverse() {
			for (int i = 0; i < array.length/2; i++) {
	            E temp = array[i];
	            array[i] = array[array.length-(1+i)];
	            array[array.length-(1+i)] = temp;
	          }
		}

	  /**
	   * toString()
	   * Returns a nice String representation of the elements in the array.
	   * @return
	   */
	  public String dispString() {
		return Arrays.toString(array);
	}
}
