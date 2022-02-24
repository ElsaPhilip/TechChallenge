package stepDefinitions;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import utils.TestBase;
import utils.TestContextSetup;

public class APIStepDefinition {
	TestContextSetup testContextSetup;

	public APIStepDefinition(TestContextSetup testContextSetup) throws IOException {
		this.testContextSetup = testContextSetup;
		url = testContextSetup.testBase.getURL();
	}

	public String url;
	public CloseableHttpResponse response;
	CloseableHttpClient client = HttpClients.createDefault();
	public HttpGet request;
	public int code;
	public String bodyPayload;
	public HttpPost postrequest;
	public CloseableHttpResponse postResponse;
	public String bd, gender, name, natid, salary, tax;

	@Given("^I Set request HEADER$")
	public void i_set_request_header() throws Throwable {
		// url = testContextSetup.testBase.getURL();

	}

	@When("^Send a GET HTTP request$")
	public void send_a_get_http_request() throws Throwable {

		request = new HttpGet(url + "calculator/taxRelief");

	}

	@Then("^I receive valid Response$")
	public void i_receive_valid_response() throws Throwable {
		response = testContextSetup.genericUtils.SetTheHeader(request);
		code = response.getStatusLine().getStatusCode();
		System.out.print("Response Code is" + code);

	}

	@And("^Validate the Response$")
	public void validate_the_response() throws Throwable {
		Assert.assertEquals(code, 200);

		String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
		System.out.println(responseString);

	}

	@When("^Send a GET getTaxReliefSummary API HTTP request$")
	public void send_a_get_gettaxreliefsummary_api_http_request() throws Throwable {
		request = new HttpGet(url + "calculator/taxReliefSummary");
	}
/*
	@When("^Send a POST insertPerson API HTTP request with body as (.+) (.+) (.+) (.+) (.+) (.+)$")
	public void send_a_post_insertperson_api_http_request_with_body_as(String natid, String salary, String tax,
			String gender, String dob, String name) throws Throwable {

		this.bd = dob;
		this.gender = gender;
		this.name = name;
		this.natid = natid;
		this.salary = salary;
		this.tax = tax;
		bodyPayload = "{\"birthday\":\"" + bd + "\",\"gender\":\"" + gender + "\",\"name\":\"" + name
				+ "\",\"natid\":\"" + natid + "\",\"salary\":\"" + salary + "\",\"tax\":\"" + tax + "\"}";

		postrequest = new HttpPost(url + "calculator/insert");
		postrequest.setEntity(new StringEntity(bodyPayload));
		postResponse = testContextSetup.genericUtils.SetPOSTHeader(postrequest);
	}
	
	*/
	 @Given("^Set insertPerson request HEADER (.+) (.+) (.+) (.+) (.+) (.+)$")
	    public void set_insertperson_request_header(String natid, String salary, String tax, String gender, String dob, String name) throws Throwable {
	 
		 this.bd = dob;
			this.gender = gender;
			this.name = name;
			this.natid = natid;
			this.salary = salary;
			this.tax = tax;
			bodyPayload = "{\"birthday\":\"" + bd + "\",\"gender\":\"" + gender + "\",\"name\":\"" + name
					+ "\",\"natid\":\"" + natid + "\",\"salary\":\"" + salary + "\",\"tax\":\"" + tax + "\"}";
			postrequest = new HttpPost(url + "calculator/insert");
	 
	 }

	 /*
	@Given("^Set insertPerson request HEADER$")
	public void set_insertperson_request_header() throws Throwable {

		bodyPayload = "{\"birthday\": \"17081982\",\"gender\": \"F\",\"name\": \"Elsa\",\"natid\": \"101101\",\"salary\": \"100000\",\"tax\": \"3000\"}";
		postrequest = new HttpPost(url + "calculator/insert");

	}
	
	*/

	@When("^Send a POST insertPerson API HTTP request$")
	public void send_a_post_insertperson_api_http_request() throws Throwable {

		postrequest.setEntity(new StringEntity(bodyPayload));
		postResponse = testContextSetup.genericUtils.SetPOSTHeader(postrequest);

	}

	@Then("^Receive valid POST Response$")
	public void receive_valid_post_response() throws Throwable {

		code = postResponse.getStatusLine().getStatusCode();

		System.out.print("Response Code is" + code);

		String responseString = EntityUtils.toString(postResponse.getEntity(), "UTF-8");
		System.out.println("responseString" + responseString);
	}

    @Given("^Set insertMultiplePerson request HEADER (.+) (.+) (.+) (.+) (.+) (.+)$")
    public void set_insertmultipleperson_request_header(String natid, String salary, String tax, String gender, String dob, String name) throws Throwable {
    	 this.bd = dob;
			this.gender = gender;
			this.name = name;
			this.natid = natid;
			this.salary = salary;
			this.tax = tax;
			bodyPayload = "[{\"birthday\":\"" + bd + "\",\"gender\":\"" + gender + "\",\"name\":\"" + name
					+ "\",\"natid\":\"" + natid + "\",\"salary\":\"" + salary + "\",\"tax\":\"" + tax + "\"},{\"birthday\":\"" + bd + "\",\"gender\":\"" + gender + "\",\"name\":\"" + name
					+ "\",\"natid\":\"" + natid + "\",\"salary\":\"" + salary + "\",\"tax\":\"" + tax + "\"}]";
			postrequest = new HttpPost(url + "calculator/insertMultiple");
    }
    
    
	/*
    @Given("^Set insertMultiplePerson request HEADER$")
	public void set_insertmultipleperson_request_header() throws Throwable {
		//bodyPayload = "[{\"birthday\": \"17081982\",\"gender\": \"F\",\"name\": \"Elsa\",\"natid\": \"101101\",\"salary\": \"100000\",\"tax\": \"3000\"},{\"birthday\": \"17081982\",\"gender\": \"F\",\"name\": \"Elsa\",\"natid\": \"101101\",\"salary\": \"100000\",\"tax\": \"3000\"}]";

		postrequest = new HttpPost(url + "calculator/insertMultiple");
	}
	*/

}
