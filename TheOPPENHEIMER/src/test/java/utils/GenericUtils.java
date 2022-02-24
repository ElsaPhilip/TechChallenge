package utils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.openqa.selenium.WebDriver;

public class GenericUtils {
	public WebDriver driver;

	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	public CloseableHttpResponse response;
	CloseableHttpClient client = HttpClients.createDefault();
	public HttpGet request;
	public void SwitchWindowToChild() {
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		String parentWindow = i1.next();
		String childWindow = i1.next();
		driver.switchTo().window(childWindow);
	}

	public void SelectFileFromWindows(String strArg1) throws IOException {
		// TODO Auto-generated method stub
		if (strArg1.equalsIgnoreCase("valid"))
			Runtime.getRuntime().exec(System.getProperty("user.dir") + "//src//test//resources//fileupload.exe");
		else
			Runtime.getRuntime().exec(System.getProperty("user.dir") + "//src//test//resources//fileuploadinvalid.exe");
	}

	public long getage(String dob) throws ParseException {
		String today = "01022022";

		// SimpleDateFormat converts the
		// string format to date object
		SimpleDateFormat sdf = new SimpleDateFormat("DDMMYYYY");

		// parse method is used to parse
		// the text from a string to
		// produce the date
		Date d1 = sdf.parse(dob);
		Date d2 = sdf.parse(today);

		// Calucalte time difference
		// in milliseconds
		long difference_In_Time = d2.getTime() - d1.getTime();

		// Calucalte time difference in
		// seconds, minutes, hours, years,
		// and days
		long difference_In_Seconds = (difference_In_Time / 1000) % 60;

		long difference_In_Minutes = (difference_In_Time / (1000 * 60)) % 60;

		long difference_In_Hours = (difference_In_Time / (1000 * 60 * 60)) % 24;

		long difference_In_Years = (difference_In_Time / (1000l * 60 * 60 * 24 * 365));

		long difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;

		// Print the date difference in
		// years, in days, in hours, in
		// minutes, and in seconds

		return difference_In_Years;
	}

	public CloseableHttpResponse SetTheHeader(HttpGet request) throws ClientProtocolException, IOException{
	request.addHeader("Content-Type", "application/json");
	response = client.execute(request);
	return response;
	}
	
	public  CloseableHttpResponse SetPOSTHeader(HttpPost request) throws ClientProtocolException, IOException {
		request.addHeader("Content-Type", "application/json");
		response = client.execute(request);
		return response;
		}
}
