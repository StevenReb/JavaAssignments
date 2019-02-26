package cop2251.fall18.week7.rebelo;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Set;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestNameHelper
{
	static NameHelper h = new NameHelper();
	

	@BeforeClass
	public static void oneTimeSetUp() throws FileNotFoundException  
    {
		System.out.println("loading");
		h.load();
		
    }
	
	@Test
	public void testNameFoundCase()
	{
		assertTrue(h.isNamePresent("Emma", "F"));
		assertTrue(h.isNamePresent("EMMA", "F"));
		assertTrue(h.isNamePresent("emma", "F"));
		assertTrue(h.isNamePresent("EmMa", "F"));
	}	
	
	@Test
	public void testNameFound()
	{
		assertTrue(h.isNamePresent("Zyus", "M"));
		assertTrue(h.isNamePresent("Zymirah", "F"));
		assertTrue(h.isNamePresent("Zyshawn", "M"));
		assertTrue(h.isNamePresent("Zeno", "M"));
	}	
	
	@Test
	public void testNameNOTFound()
	{
		assertFalse(h.isNamePresent("batman", "M"));
	}	

	@Test
	public void testYears()
	{
		TreeSet<String> years = (TreeSet<String>)h.getYears();
		assertEquals("1900", years.first());
		assertEquals("2017", years.last());
		assertEquals(118,years.size());
	}
	
	@Test
	public void testRank()
	{
		assertTrue(h.isNamePresent("noah", "M"));
		assertEquals(19613, h.getRank("2015", "noah", "M"));
		
		
		assertTrue(h.isNamePresent("Zyus", "M"));
		assertEquals(5, h.getRank("2015", "zyus", "M"));
		
		
		assertTrue(h.isNamePresent("margaret", "F"));
		assertEquals(5304, h.getRank("1900", "margaret", "F"));
		
	}
}
