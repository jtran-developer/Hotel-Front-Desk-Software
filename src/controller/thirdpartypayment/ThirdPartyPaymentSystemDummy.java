package controller.thirdpartypayment;

public class ThirdPartyPaymentSystemDummy {
	public static boolean checkPaymentInformation(String p)
	{
		try
		{
			Double.parseDouble(p.replace("-", ""));
			if (p.length() == 16) {
				return true;
			}
		}
		catch (Exception e) { }
		return false;

	}
	
	public static boolean makePayment(double a)
	{
		return true;
	}
	
	
	
	
	
}
