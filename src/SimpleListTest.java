/**
 * Program Name: SimpleListTest
 * Program Author: Ivan Martinez Morales
 * Program Author ID: 355
 * Program Description: Tests methods and constructors used in SimpleList for 
 * assignment 2. 
 */
package assign2;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 * Test cases for class SimpleList. Includes two test frames for fleshing out
 * test cases. Includes all methods used in SimpleList and tests constructor.
 */
public class SimpleListTest {

    /**
     * Tests constructor for both nullity and ensures that SimpleList's counter
     * begins at 0.
     */
    @Test void testConstructor() {
        // Testing empty constructor
        SimpleList testList = new SimpleList();
        assertNotNull("Performing null check on SimpleList", testList);
        assertEquals("Testing if testList's count initializes to 0...",
                0, testList.count());
    }

    /**
     * Tests add method. Set up with three distinct test cases to ensure
     * complete coverage. Tests empty simpleList, simpleList with less than
     * ten elements, and then tests overflow feature. Depends on fullTestFrame
     */
    @Test void add() {
        // 1. Create SimpleList and check if first if condition passes
        SimpleList testList = new SimpleList();
        testList.add(1);
        assertEquals(
                "Testing if element was added to the empty list..",
                0, testList.search(1));

        // 2. Use same SimpleList and check if count increments and if values match
        testList.add(2);
        assertEquals("Testing if List length increases with new element...",
                2, testList.count());
        assertEquals("Testing if 0 is the index of array element value 2.",
                0, testList.search(2));

        // 3. Testing overflow feature
        // Adding in the last element into the list
        testList.add(3);
        testList.add(4);
        testList.add(5);
        testList.add(6);
        testList.add(7);
        testList.add(8);
        testList.add(9);
        testList.add(10);
        assertEquals("Testing that simplelist has ten elements...",
                10, testList.count());

        testList.add(11);
        assertEquals("Testing index of new value with overflow",
                0, testList.search(11));
    }

    /**
     * Tests remove method. Sets up test with an instance of testList, then
     * removes an element from test list. Verifies success by utilizing count
     * method. Depends on a properly functioning add method.
     */
    @Test void remove() {
        SimpleList testList = new SimpleList();

        // 1. Test remove where only one element exists
        testList.add(1);
        assertEquals("Testing if element has been added to list...",
                1, testList.count());
        testList.remove(1);
        assertEquals("Testing if element has been removed from list...",
                0, testList.count());

        // 2. Test remove method with multiple elements.
        testList.add(3);
        testList.add(2);
        testList.add(1);
        testList.remove(1);
        assertEquals("Testing if element has been properly removed...",
                2, testList.count());
    }

    /**
     * Tests count method. Verifies that count increments when new values are
     * added and subtracted from SimpleList. Sets up instance of SimpleList
     * and depends on a properly functioning add method.
     */
    @Test void count() {
        SimpleList testList = new SimpleList();
        assertEquals("Testing count value for empty list...",
                0, testList.count());

        testList.add(1);
        assertEquals("Testing count method with one element...",
                1, testList.count());

        testList.add(2);
        assertEquals("Testing count method with two elements...",
                2, testList.count());

        // Testing instances where elements are removed
        testList.remove(2);
        assertEquals("Testing count method where an element has been removed...",
                1, testList.count());

        testList.remove(1);
        assertEquals("Testing count method where another element was removed...",
                0, testList.count());
    }

    /**
     * Tests toString method. Verifies that toString method omits trailing
     * white-space when creating String. Sets up instance of SimpleList and
     * depends on properly functioning add method.
     */
    @Test void testToString() {
        SimpleList testList = new SimpleList();
        assertEquals("Testing toString with empty array...",
                "", testList.toString());

        testList.add(1);
        assertEquals("Testing toString with single element...",
                "1", testList.toString());

        testList.add(2);
        assertEquals("Testing toString with two elements...",
                "2 1", testList.toString());

        testList.add(3);
        assertEquals("Testing toString with three elements...",
                "3 2 1", testList.toString());

    }

    /**
     * Tests search method. Verifies that search method returns index of a
     * given element in the SimpleList. Sets up instance of SimpleList and
     * depends on properly functioning add method.
     */
    @Test void search() {
        SimpleList testList = new SimpleList();
        assertEquals("Testing searching on an empty list...",
                -1, testList.search(1));

        testList.add(1);
        assertEquals("Testing on searching for an element with array length 1.",
                0, testList.search(1));

        testList.add(2);
        assertEquals("Testing on searching for an elent where array length > 1.",
                1, testList.search(1));

    }

    /**
     * Tests append method. Verifies that elements may be append into 
     * SimpleList. In this case, append an element to a list with only
     * one element.
     */
    @Test void append() {
        int expectedIndex = 1;
        SimpleList testList = new SimpleList();
        testList.append(1);
        testList.append(2);
        int actualIndex = testList.search(2);

        assertEquals(expectedIndex, actualIndex);
    }

    /**
     * Tests append method for bad case. Testing the case where the element
     * is not in the place its supposed to be. Testing unexpected behavior. 
     */
    @Test void testAppendBad() {
        int badExpectedIndex = 1;
        SimpleList testList = new SimpleList();
        testList.append(1);
        testList.append(2);
        int badActualIndex = testList.searh
    }
}
