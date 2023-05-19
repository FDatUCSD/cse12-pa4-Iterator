
/**
 * Name: Farris Danish
 * Email: fbinsyahrilakmar@ucsd.edu
 * PID: A17401247
 * Sources used: Write-up
 * 
 * This file contains tests custom unit tests for MyLinkedList methods
 */

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.*;

public class MyListIteratorCustomTester {

    private MyLinkedList listLen1, listLen2;
    private MyLinkedList.MyListIterator listLen1Iter, listLen2Iter;

    /**
     * This sets up the test fixture. JUnit invokes this method before
     * every testXXX method. The @Before tag tells JUnit to run this method
     * before each test.
     */
    @Before
    public void setUp() throws Exception {
        listLen1 = new MyLinkedList();
        listLen1.add("Christine");
        listLen1Iter = listLen1.new MyListIterator();

        listLen2 = new MyLinkedList();
        listLen2.add("Paul");
        listLen2.add("Cao");
        listLen2Iter = listLen2.new MyListIterator();
    }

    /**
     * Aims to test the next() method when iterator is at end of the list
     */
    @Test
    public void testNextEnd() {
        listLen1Iter.left = listLen1.head.getNext();
        listLen1Iter.right = listLen1.head.getNext().getNext();
        listLen1Iter.idx = 1;
        listLen1Iter.forward = true;
        listLen1Iter.canRemoveOrSet = true;
        assertThrows("Should throw NoSuchElementException",
                NoSuchElementException.class, () -> listLen1Iter.next());
    }

    /**
     * Aims to test the previous() method when iterator is at the start of the
     * list
     */
    @Test
    public void testPreviousStart() {
        listLen1Iter.left = listLen1.head;
        listLen1Iter.right = listLen1.head.getNext();
        listLen1Iter.idx = 0;
        listLen1Iter.forward = true;
        listLen1Iter.canRemoveOrSet = true;
        assertThrows("Should throw NoSuchElementException",
                NoSuchElementException.class,
                () -> listLen1Iter.previous());
    }

    /**
     * Aims to test the add(E e) method when an invalid element is added
     */
    @Test
    public void testAddInvalid() {
        listLen1Iter.left = listLen1.head;
        listLen1Iter.right = listLen1.head.getNext();
        listLen1Iter.idx = 0;
        listLen1Iter.forward = true;
        listLen1Iter.canRemoveOrSet = false;
        assertThrows("Should throw NullPointerException",
                NullPointerException.class,
                () -> listLen1Iter.add(null));
    }

    /**
     * Aims to test the set(E e) method when canRemoveOrSet is false
     */
    @Test
    public void testCantSet() {
        listLen1Iter.left = listLen1.head;
        listLen1Iter.right = listLen1.head.getNext();
        listLen1Iter.idx = 0;
        listLen1Iter.forward = true;
        listLen1Iter.canRemoveOrSet = false;
        assertThrows("Should throw IllegalStateException",
                IllegalStateException.class,
                () -> listLen1Iter.set("hello"));
    }

    /**
     * Aims to test the set(E e) method when an invalid element is set
     */
    @Test
    public void testSetInvalid() {
        listLen1Iter.left = listLen1.head;
        listLen1Iter.right = listLen1.head.getNext();
        listLen1Iter.idx = 0;
        listLen1Iter.forward = true;
        listLen1Iter.canRemoveOrSet = true;
        assertThrows("Should throw NullPointerException when setting null",
                NullPointerException.class,
                () -> listLen1Iter.set(null));
    }

    /**
     * Aims to test the remove() method when canRemoveOrSet is false
     */
    @Test
    public void testCantRemove() {
        listLen1Iter.left = listLen1.head;
        listLen1Iter.right = listLen1.head.getNext();
        listLen1Iter.idx = 0;
        listLen1Iter.forward = true;
        listLen1Iter.canRemoveOrSet = false;
        assertThrows("Should throw IllegalStateException",
                IllegalStateException.class,
                () -> listLen1Iter.remove());
    }

    /**
     * Aims to tests the hasNext() method at the end of a list
     */
    @Test
    public void testHasNextEnd() {
        listLen1Iter.left = listLen1.head.getNext();
        listLen1Iter.right = listLen1.head.getNext().getNext();
        listLen1Iter.idx = 1;
        listLen1Iter.forward = true;
        listLen1Iter.canRemoveOrSet = true;
        assertFalse("Should return false when at the end of list",
                listLen1Iter.hasNext());
    }

    /**
     * Aims to test the hasPrevious() method at the start of a list
     */
    @Test
    public void testHasPreviousStart() {

        listLen1Iter.left = listLen1.head;
        listLen1Iter.right = listLen1.head.getNext();
        listLen1Iter.idx = 0;
        listLen1Iter.forward = true;
        listLen1Iter.canRemoveOrSet = false;
        assertFalse("Should return false when at the start of list",
                listLen1Iter.hasPrevious());
    }

    /**
     * Aims to test the previousIndex() method at the start of a list
     */
    @Test
    public void testPreviousIndexStart() {

        listLen1Iter.left = listLen1.head;
        listLen1Iter.right = listLen1.head.getNext();
        listLen1Iter.idx = 0;
        listLen1Iter.forward = true;
        listLen1Iter.canRemoveOrSet = false;
        assertEquals("returns -1 if iterator is at the start",
                -1, listLen1Iter.previousIndex());
    }

    /**
     * Aims to test the nextIndex() method at the end of a list
     */
    @Test
    public void testNextIndexEnd() {
        listLen1Iter.left = listLen1.head.getNext();
        listLen1Iter.right = listLen1.head.getNext().getNext();
        listLen1Iter.idx = 1;
        listLen1Iter.forward = true;
        listLen1Iter.canRemoveOrSet = true;
        assertEquals("Should return the size of the list",
                listLen1.size(), listLen1Iter.nextIndex());
    }
}
