package macaca.asiainfo.HunClientTest;

import static org.hamcrest.CoreMatchers.containsString;

import java.io.File;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import macaca.client.MacacaClient;
import macaca.client.common.ElementSelector;
import macaca.client.common.MacacaDriver;

public class AndroidTest {

	MacacaClient driver = new MacacaClient();

	@Before
	public void setUp() throws Exception {
		// platform: android or ios
		String platform = "android";
		/*
		 * Desired Capabilities are used to configure webdriver when initiating
		 * the session. Document URL:
		 * https://macacajs.github.io/macaca/desired-caps.html
		 */
		JSONObject porps = new JSONObject();
		porps.put("platformName", platform);
		File directory = new File("");
		String courseFile = directory.getCanonicalPath();
		porps.put("app", courseFile + "/app/" + "hunclient.apk");
		// porps.put("app", courseFile+"/app/" + "android-app-bootstrap.apk");

		porps.put("reuse", 1);
		JSONObject desiredCapabilities = new JSONObject();
		desiredCapabilities.put("desiredCapabilities", porps);
		driver.initDriver(desiredCapabilities);
	}

	@Test
	public void test_case_1() throws Exception  {
		// set screenshot save path
		File directory = new File("");
		String courseFile = directory.getCanonicalPath();

		System.out.println("------------#1 update test-------------------");
//		boolean isUpdate = driver.isElementExist(
//				"//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.Button[1]",
//				"//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.Button[1]");
//		if (isUpdate) {
//			driver.elementByXPath(
//					"//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.Button[1]")
//			.click();
//			
//		}
//		driver.elementById("cancel_button").click().sleep(1000);
//		
		driver.elementByXPath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.Button[1]").click().sleep(1000);
		
		System.out.println("------------#2 permission test-------------------");
//		
//		 isUpdate = driver.isElementExist(
//				"//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.Button[1]",
//				"//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.Button[1]");
//		if (isUpdate) {
//			driver.elementByXPath(
//					"//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.Button[1]")
//			.click();
//			
//		}
		driver.elementByXPath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.Button[1]").click().sleep(1000);
//		driver.elementById("cancel_button").click().sleep(1000);

		System.out.println("------------#3 login test-------------------");

		driver.elementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText[1]")
				.sendKeys("13874979696");

		driver.elementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.EditText[1]")
				.sendKeys("820521");
		
//		driver.elementById("et_email_phone").sendKeys("13874979696");
//		driver.elementById("password").sendKeys("820521");
		driver.elementById("com.asiainfo.CMCHN:id/btn_login").click().sleep(1000);
		
		
		
	}

	// switch to the context of the last pushed webview
	public MacacaClient switchToWebView(MacacaClient driver) throws Exception {
		JSONArray contexts = driver.contexts();
		return driver.context(contexts.get(contexts.size() - 1).toString());
	}

	// switch to the context of native
	public MacacaClient switchToNative(MacacaClient driver) throws Exception {
		JSONArray contexts = driver.contexts();
		return driver.context(contexts.get(0).toString());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
