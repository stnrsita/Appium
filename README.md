# **Appium Demo Project**

---

## **Overview**

This project demonstrates the basic operations of Appium on an Android device using Java. It includes setting up the Appium environment, configuring capabilities, and performing various automated interactions with an Android application. The project consists of two main files: `base.java` for setting up the driver and capabilities, and `basic.java` for implementing test automation scripts.

---

## **Project Structure**

- **base.java**: 
  - Initializes the `AndroidDriver` with desired capabilities.
  - Sets up the device and application for testing.
  - Configures Appium with UIAutomator2 for automation.

- **basic.java**:
  - Demonstrates various Appium operations such as clicking buttons, scrolling, and swiping.
  - Utilizes `WebDriverWait` and `ExpectedConditions` for robust element handling.
  - Handles `StaleElementReferenceException` to ensure reliability of element interactions.

---

## **Setup and Requirements**

1. **Environment Setup**:
   - Java Development Kit (JDK) 17 or later.
   - Eclipse IDE for Java Developers.
   - Android Studio for building the APK.
   - Appium Server and Appium Inspector.

2. **Dependencies**:
   - Appium Java client library.
   - Selenium WebDriver.

---

## **Instructions**

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/appium-demo.git
   ```

2. **Open the Project in Eclipse**:
   - Import the cloned repository as a Java project.

3. **Build the APK in Android Studio**:
   - Open the project in Android Studio.
   - Build the APK: `Build > Build Bundle(s) / APK(s) > Build APK(s)`.

4. **Configure Appium Inspector**:
   - Set up capabilities in Appium Inspector:
     ```json
     {
       "deviceName": "Medium Phone API 33",
       "app": "path/to/app-debug.apk",
       "automationName": "uiautomator2"
     }
     ```
   - Start the Appium server and initiate the session.

5. **Run the Test Script**:
   - In Eclipse, run `basic.java` as a Java application.
   - Observe the automated interactions on the connected Android device.

---
