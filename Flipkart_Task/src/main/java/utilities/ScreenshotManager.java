package utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;

public class ScreenshotManager {
	
	public static void saveScreenshots(WebDriver driver, Scenario scenario) {
		String screenshotName = scenario.getName().replaceAll(" ", "_") + 
				LocalDateTime.now().format(DateTimeFormatter.ofPattern("d_MMM_YY_HH_mm_ss"));
		String folderForScreenshots = System.getProperty("user.dir") + 
				"\\screenshots\\" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("d_MMM_YY_HH_mm"));
		
		try {
			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String destinationPath = folderForScreenshots + "\\" + screenshotName + ".png";
			File target = new File(destinationPath);
			FileUtils.copyFile(sourcePath, target);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void attachScreenshot(WebDriver driver, Scenario scenario) {
		try {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
