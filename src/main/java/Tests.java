import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class Tests {

    @Test
    void insertNewNote() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5559");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "it.feio.android.omninotes.alpha");
        dc.setCapability("appActivity", "it.feio.android.omninotes.MainActivity");

        AndroidDriver<AndroidElement> driver =
                new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);

        MobileElement el1 = (MobileElement) driver
                .findElement(By.id("it.feio.android.omninotes.alpha:id/fab_expand_menu_button"));
        el1.click();

        MobileElement el2 = (MobileElement) driver
                .findElement(By.id("it.feio.android.omninotes.alpha:id/fab_note"));
        el2.click();

        MobileElement el3 = (MobileElement) driver
                .findElement(By.id("it.feio.android.omninotes.alpha:id/detail_title"));
        el3.click();
        el3.sendKeys("New Note");

        MobileElement el4 = (MobileElement) driver
                .findElement(MobileBy.AccessibilityId("drawer open"));
        el4.click();

        Assert.assertEquals(
                driver.findElement(By.id("it.feio.android.omninotes.alpha:id/note_title"))
                        .getText(),
                "New Note"
        );
    }

    @Test
    void archiveANote() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5559");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "it.feio.android.omninotes.alpha");
        dc.setCapability("appActivity", "it.feio.android.omninotes.MainActivity");

        AndroidDriver<AndroidElement> driver =
                new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);

        MobileElement el1 = (MobileElement) driver
                .findElement(By.id("it.feio.android.omninotes.alpha:id/fab_expand_menu_button"));
        el1.click();

        MobileElement el2 = (MobileElement) driver
                .findElement(By.id("it.feio.android.omninotes.alpha:id/fab_note"));
        el2.click();

        MobileElement el3 = (MobileElement) driver
                .findElement(By.id("it.feio.android.omninotes.alpha:id/detail_title"));
        el3.click();
        el3.sendKeys("New Note");

        MobileElement el4 = (MobileElement) driver.findElement(MobileBy.AccessibilityId("drawer open"));
        el4.click();

        //swipe left note to archive it
        int screenWidth = (int) driver.manage().window().getSize().width;
        int screenWidth90 = (int) (.9 * screenWidth);
        int screenWidth65 = (int) (.65 * screenWidth);
        int screenWidth10 = (int) (.1 * screenWidth);

        MobileElement newNote = driver.findElement(By.id("it.feio.android.omninotes.alpha:id/note_title"));

        TouchAction touchAction = new TouchAction(driver);
        int elementY = newNote.getLocation().getY();

        touchAction.press(PointOption.point(screenWidth90, elementY))
                .moveTo(PointOption.point(screenWidth65, elementY))
                .moveTo(PointOption.point(screenWidth10, elementY))
                .release()
                .perform();

        MobileElement el6 = (MobileElement) driver
                .findElement(MobileBy.AccessibilityId("drawer open"));
        el6.click();

        MobileElement el7 = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ListView[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout"));
        el7.click();

        Assert.assertEquals(driver.findElement(By.id("it.feio.android.omninotes.alpha:id/note_title")).getText(), "New Note");
    }

    @Test
    void searchNote() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5559");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "it.feio.android.omninotes.alpha");
        dc.setCapability("appActivity", "it.feio.android.omninotes.MainActivity");

        AndroidDriver<AndroidElement> driver =
                new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);

        MobileElement el1 = (MobileElement) driver
                .findElement(By.id("it.feio.android.omninotes.alpha:id/fab_expand_menu_button"));
        el1.click();
        MobileElement el2 = (MobileElement) driver
                .findElement(By.id("it.feio.android.omninotes.alpha:id/fab_note"));
        el2.click();
        MobileElement el3 = (MobileElement) driver
                .findElement(By.id("it.feio.android.omninotes.alpha:id/detail_title"));
        el3.click();
        el3.sendKeys("X");
        MobileElement el4 = (MobileElement) driver
                .findElement(MobileBy.AccessibilityId("drawer open"));
        el4.click();
        MobileElement el5 = (MobileElement) driver
                .findElement(By.id("it.feio.android.omninotes.alpha:id/fab_expand_menu_button"));
        el5.click();
        MobileElement el6 = (MobileElement) driver
                .findElement(By.id("it.feio.android.omninotes.alpha:id/fab_note"));
        el6.click();
        MobileElement el7 = (MobileElement) driver
                .findElement(By.id("it.feio.android.omninotes.alpha:id/detail_title"));
        el7.click();
        MobileElement el8 = (MobileElement) driver
                .findElement(By.id("it.feio.android.omninotes.alpha:id/detail_title"));
        el8.sendKeys("Y");
        MobileElement el9 = (MobileElement) driver
                .findElement(MobileBy.AccessibilityId("drawer open"));
        el9.click();
        MobileElement el10 = (MobileElement) driver
                .findElement(By.id("it.feio.android.omninotes.alpha:id/fab_expand_menu_button"));
        el10.click();
        MobileElement el11 = (MobileElement) driver
                .findElement(By.id("it.feio.android.omninotes.alpha:id/fab_note"));
        el11.click();
        MobileElement el12 = (MobileElement) driver
                .findElement(By.id("it.feio.android.omninotes.alpha:id/detail_title"));
        el12.click();
        el12.sendKeys("Z");
        MobileElement el13 = (MobileElement) driver
                .findElement(MobileBy.AccessibilityId("drawer open"));
        el13.click();
        MobileElement el14 = (MobileElement) driver
                .findElement(MobileBy.AccessibilityId("Search"));
        el14.click();
        MobileElement el15 = (MobileElement) driver
                .findElement(By.id("it.feio.android.omninotes.alpha:id/search_plate"));
        el15.click();
        MobileElement el16 = (MobileElement) driver
                .findElement(By.id("it.feio.android.omninotes.alpha:id/search_src_text"));
        el16.sendKeys("X");

        ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.ENTER));

        Assert.assertEquals(
                driver.findElement(
                        By.id("it.feio.android.omninotes.alpha:id/note_title")
                ).getText(),
                "X"
        );
    }

    @Test
    void deleteNoteAndEmptyTrash() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5559");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "it.feio.android.omninotes.alpha");
        dc.setCapability("appActivity", "it.feio.android.omninotes.MainActivity");

        AndroidDriver<AndroidElement> driver =
                new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);

        WebDriverWait wait = new WebDriverWait(driver, 10);

        MobileElement el1 = (MobileElement) driver
                .findElement(By.id("it.feio.android.omninotes.alpha:id/fab_expand_menu_button"));
        el1.click();

        MobileElement el2 = (MobileElement) driver
                .findElement(By.id("it.feio.android.omninotes.alpha:id/fab_note"));
        el2.click();

        MobileElement el3 = (MobileElement) driver
                .findElement(By.id("it.feio.android.omninotes.alpha:id/detail_title"));
        el3.click();
        el3.sendKeys("New Note");

        MobileElement el4 = (MobileElement) driver
                .findElement(MobileBy.AccessibilityId("drawer open"));
        el4.click();

        MobileElement el5 = (MobileElement) driver
                .findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout"));
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElement(MobileBy.AccessibilityId("More options"));
        el6.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[6]/android.widget.LinearLayout"))).click();

        MobileElement el8 = (MobileElement) driver
                .findElement(MobileBy.AccessibilityId("drawer open"));
        el8.click();

        MobileElement el9 = (MobileElement) driver
                .findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ListView[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView"));
        el9.click();

        Assert.assertEquals(driver.findElement(By.id("it.feio.android.omninotes.alpha:id/note_title")).getText(), "New Note");

        MobileElement el10 = (MobileElement) driver
                .findElement(MobileBy.AccessibilityId("More options"));
        el10.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout"))).click();

        MobileElement el12 = (MobileElement) driver.findElement(By.id("it.feio.android.omninotes.alpha:id/md_buttonDefaultPositive"));
        el12.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("it.feio.android.omninotes.alpha:id/note_title")));

        Assert.assertEquals(driver.findElements(By.id("it.feio.android.omninotes.alpha:id/note_title")).size(), 0);

    }

    @Test
    void infoMenu() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5559");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "it.feio.android.omninotes.alpha");
        dc.setCapability("appActivity", "it.feio.android.omninotes.MainActivity");

        AndroidDriver<AndroidElement> driver =
                new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);

        WebDriverWait wait = new WebDriverWait(driver, 10);

        MobileElement el1 = (MobileElement) driver
                .findElement(MobileBy.AccessibilityId("drawer open"));
        el1.click();

        MobileElement el2 = (MobileElement) driver
                .findElement(By.id("it.feio.android.omninotes.alpha:id/settings"));
        el2.click();

        int screenH = (int) driver.manage().window().getSize().height;
        int screenW = (int) driver.manage().window().getSize().width/2;
        TouchAction touchAction = new TouchAction(driver);

        touchAction.press(PointOption.point(screenW, (int) (screenH * 0.9)))
                .moveTo(PointOption.point(screenW, (int) (screenH * 0.7)))
                .moveTo(PointOption.point(screenW, (int) (screenH * 0.3)))
                .release()
                .perform();

        MobileElement el3 = (MobileElement) driver
                .findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[13]"));
        el3.click();

        Assert.assertEquals(
                driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView")).getText(),
                "Info"
        );
    }
}

