package controller.thirdpartypayment;
public class ThirdPartyPaymentBridge {
	public static boolean validatePaymentInformation(String p)
	{
		return ThirdPartyPaymentSystemDummy.checkPaymentInformation(p);
	}
	public static boolean chargePayment(double a)
	{
		return ThirdPartyPaymentSystemDummy.makePayment(a);
	}
}
