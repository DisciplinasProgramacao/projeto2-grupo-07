import static org.junit.Assert.*;

import org.junit.Test;


class ListaTest {

	 @Test
	    public void testAdd() {
	        Lista<Integer> li = new Lista<Integer>();
	        assertTrue(li.add(1));
	        assertTrue(li.add(2));
	        assertTrue(li.add(3));
	        assertEquals(3, li.size());
	    }
	    
	    @Test
	    public void testAllElements() {
	        Lista<Integer> li = new Lista<Integer>();
	        li.add(1);
	        li.add(2);
	        li.add(3);
	        Integer[] array = new Integer[3];
	        assertArrayEquals(new Integer[] {1, 2, 3}, li.allElements(array));
	    }
 
	    @Test
	    public void testSize() {
	        Lista<Integer> li = new Lista<Integer>();
	        assertEquals(0, li.size());
	        li.add(1);
	        assertEquals(1, li.size());
	        li.add(2);
	        assertEquals(2, li.size());
	        li.remove(0);
	        assertEquals(1, li.size());
	    }

}
