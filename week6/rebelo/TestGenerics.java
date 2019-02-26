package cop2251.fall18.week6.rebelo;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class TestGenerics
{

	@Test
	public void testProcessorAsCheck()
	{
		PaymentBatchProcessor<Check> checkProcessor = new PaymentBatchProcessor<>();
		
		checkProcessor.add( new Check(5.00) );
		checkProcessor.add (new Check(10.00) );
		
		assertEquals(15, checkProcessor.getTotal(), 2);
		assertEquals(10, checkProcessor.getMax().getAmount(), 2);
	}

	@Test
	public void testProcessorAsIOU()
	{
		PaymentBatchProcessor<IOU> processor = new PaymentBatchProcessor<>();
		
		processor.add( new IOU(22.54) );
		processor.add( new IOU(22.55) );
		
		assertEquals(45.09, processor.getTotal(), 2);
		assertEquals(22.55, processor.getMax().getAmount(), 2);
	}

	@Test
	public void testProcessorAsPayment()
	{
		Payment iou = new IOU(11.22);
		Payment iou2 = new Check(22.11);

		PaymentBatchProcessor<Payment> processor = new PaymentBatchProcessor<>();
		
		processor.add(iou);
		processor.add(iou2);
		
		assertEquals(33.33, processor.getTotal(), 2);
		assertEquals(22.11, processor.getMax().getAmount(), 2);
	}
	
	@Test
	public void testProcessorAsPaymentWithEmptyList()
	{
		PaymentBatchProcessor<Payment> processor = new PaymentBatchProcessor<>();

		assertEquals(0, processor.getTotal(), 2);
		assertNull(null, processor.getMax());
	}

	@Test
	public void testProcessorHelperAsPayment()
	{
		ArrayList<Payment> list = new ArrayList<Payment>();
		
		list.add( new Check(10.00) );
		list.add( new Check(5.00) );
		list.add( new IOU(1.00) );

		assertEquals(10, PaymentProcessorHelper.<Payment> getMax(list).getAmount(), 2);
		assertEquals(16, PaymentProcessorHelper.<Payment> getSum(list), 2);
	}
	
	@Test
	public void testProcessorHelperAsPaymentEmptyList()
	{
		ArrayList<Payment> list = new ArrayList<Payment>();
		
		assertNull(PaymentProcessorHelper.<Payment> getMax(list));
		assertEquals(0, PaymentProcessorHelper.<Payment> getSum(list), 2);
	}
	
	@Test
	public void testProcessorHelperAsCheck()
	{
		ArrayList<Check> list = new ArrayList<Check>();
		
		list.add( new Check(10.00) );
		list.add( new Check(5.00) );

		assertEquals(10, PaymentProcessorHelper.<Check> getMax(list).getAmount(), 2);
		assertEquals(15, PaymentProcessorHelper.<Check> getSum(list), 2);
	}
	
	@Test
	public void testProcessorHelperAsIOU()
	{
		ArrayList<IOU> list = new ArrayList<IOU>();
		
		list.add( new IOU(11.22) );
		list.add( new IOU(22.11) );

		assertEquals(22.11, PaymentProcessorHelper.<IOU> getMax(list).getAmount(), 2);
		assertEquals(33.11, PaymentProcessorHelper.<IOU> getSum(list), 2);
	}

}
