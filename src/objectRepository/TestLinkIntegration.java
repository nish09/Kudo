package objectRepository;
import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
import testngFiles.KudoBase;

public class TestLinkIntegration extends KudoBase{
	
	public static String TESTLINK_KEY = "093761522789af265049d9ce2b55c323";
	public static String TESTLINK_URL = "http://localhost/testlink-1.9.16//lib/api/xmlrpc/v1/xmlrpc.php";
	public static String TEST_PROJECT_NAME = "XENON";
	public static String TEST_CASE_NAME = "Loginpage_Functionality";
	public static String TEST_PLAN_NAME = "Fluorine";
	public static String BUILD_NAME = "Fluorine_Builds";
	
		
		public void updateTestLinkResult(String testCase, String exception, String result)  throws TestLinkAPIException
		{
		     TestLinkAPIClient testlinkAPIClient = new TestLinkAPIClient(TESTLINK_KEY, TESTLINK_URL);
		     testlinkAPIClient.reportTestCaseResult(TEST_PROJECT_NAME, TEST_PLAN_NAME, testCase, BUILD_NAME, exception, result);
		}


}
