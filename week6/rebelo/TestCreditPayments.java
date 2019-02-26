package cop2251.fall18.week6.rebelo;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestCreditPayments
{
	CreditPayments payments = new CreditPayments();
	SimpleDateFormat formatter = new SimpleDateFormat("MM/yy");
	
	@Before
	public void before() throws ParseException  
    {
        payments.add( new CreditCard("bob", "smith", "1234567890", "03/17") );
		payments.add( new CreditCard("bill", "smith", "9999999999", "04/18") );
		payments.add( new CreditCard("bob", "smyth", "1111111111", "05/19") );	
    }
	
	@After
	public void after()
	{
		payments.reset();
	}
	
//	protected void tearDown() throws Exception
//	{
//		payments
//	}
	
	@Test
	public void testPAN()
	{
		System.out.println("Tests PAN Sort");
		ArrayList<CreditCard> list = payments.printByPAN();
		
		assertEquals("1111111111",list.get(0).getPAN());
		assertEquals("1234567890",list.get(1).getPAN());
		assertEquals("9999999999",list.get(2).getPAN());
	}	
	
	@Test
	public void testNames()
	{
		System.out.println("Tests Name Sort");
		ArrayList<CreditCard> list = payments.printByName();
		
		assertEquals("smith",list.get(0).getLastName());
		assertEquals("bill",list.get(0).getFirstName());

		assertEquals("smyth",list.get(2).getLastName());
		assertEquals("bob",list.get(2).getFirstName());
	}
	
	@Test
	public void testDates()
	{
		System.out.println("Tests Date Sort");
		ArrayList<CreditCard> list = payments.printByDate();
		assertEquals("03/17",formatter.format(list.get(0).getExpDate()));
		assertEquals("05/19",formatter.format(list.get(2).getExpDate()));

	}
}
