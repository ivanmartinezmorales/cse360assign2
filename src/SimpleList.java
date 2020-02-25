/**
 * Program Author: Ivan Martinez Morales
 * Program Author Class ID: 355
 * Class: CSE 360 Spring 2020
 * Assignment 2
 *
 * Program Description: This program demonstrates proficiency with Version 
 * Control Systems (VCS). This program also makes changes to assignment 1 
 * reflected in the add method and remove methods. 
 */

package assign2;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of a simple list. Implements various list operations, and
 * operates by prepending values into the list when adding elements into the
 * list.
 */
public class SimpleList {
    private int count;
    private List<Integer> list;

    /**
     * Constructs an empty Simple List with a index of the number of elements
     * in the list set to zero.
     */
    public SimpleList() {
        this.count = 0;
        this.list = new ArrayList<>(10);
    }

    /**
     * Prepends a given value into list. If the list is empty, make it the head
     * element. Otherwise, prepend the value into the List. If the List is
     * full, then let the last value fall off of the list and prepend the most
     * recent value.
     * @param value an integer value to be prepended into the list.
     */
    public void add(int value) {
        if (count == 0) {
            this.list.add(value);
            this.count += 1;

        } else if (this.count < 10) {
            this.list.add(0, value); // Prepending
            this.count += 1;

        } else {
            int newCapacity = (int) this.list.size() * 1.5;
            this.list.add(0, value);
            this.count += 1;
        }
    }

    /**
     * Removes the value at a given index if the value is in the list. If the
     * value is not in the list, do nothing. Depends on using the `search`
     * method.
     * @param value a value to remove.
     */
    public void remove(int value) {
        int removeIndex = search(value);

        if (removeIndex != -1) {
            this.list.remove(removeIndex);
            this.count -= 1;
        }

        int lowerLimit = (int) this.count * 0.75;
        if (this.list.size() <= lowerLimit) {
            this.list.trimToSize(); // Trims to size of num elements in list.
        }

    }

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list.
     */
    public int count() {
        return this.count;
    }

    /**
     * Returns a string representation of the class, i.e. for a list containing
     * the numbers 1, 2, 3, 4 and 5, returns a space-separated sequence of
     * numbers, i.e. "1 2 3 4" with no trailing whitespace.
     * @return A sequence of space-separated numbers with no trailing white space.
     */
    @Override public String toString() {
        StringBuilder returnString = new StringBuilder();

        for (int i = 0; i < this.count; i++) {
            returnString.append(this.list.get(i));
            if (i != this.count - 1) {
                returnString.append(" ");
            }
        }
        this.list.toString();
        return returnString.toString();
    }


    /**
     * Returns the specific index of a given element if it is in this list.
     * Returns -1 if such an element does not exist.
     * @param value an element whose precense in this list is to be tested.
     * @return returns the index of the first occurence of the specified
     * element in this list, or -1 if the list does not contain the element.
     */
    public int search(int value) {
        return this.list.indexOf(value);
    }

    /**
     * Appends the given parameter to the end of the list. If the list is full,
     * Then increase the size of the list by 50%. 
     */
    public void append(int value) {
        if (value == null) { 
            return; // no-op, fail silently
        }

        // Case 1. If the count is less than the initial size of the array
        if (this.count < this.list.size()) {
            this.list.add(value);
            return;
        }

        int newCapacity = (int) this.list.size() * 1.5;
        this.list.ensureCapacity(newCapacity);
        this.list.add(value);
    }

    /**
     * Returns the first element in the list. 
     * @return returns first value in the list. If the list is empty,
     * then return -1. 
     */
    public int first() {
        if (this.list.isEmpty()) {
            return -1;
        }
        return this.list.get(0);
    }

    /**
     * Return the current number of possible locations in this list.
     * @return current number of possible locations in this list.
     */
    public int size() {
        return this.list.size();
    }
}

