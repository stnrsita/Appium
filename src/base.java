import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {

	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
		// TODO Auto-generated method stub
		
		//define basic test requirements such ad device name, app/apk location
		DesiredCapabilities cap = new DesiredCapabilities();
		
		File appDir = new File("src");
		
		File app = new File(appDir, "app-debug.apk");
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Medium Phone API 33");
	
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");//new step	
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723"), cap);
		
		return driver;
	}
}