package stepDefinitions;

import java.io.IOException;

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

	@Given("^I Set request HEADER$")
	public void i_set_request_header() throws Throwable {
		//url = testContextSetup.testBase.getURL();

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

	@Given("^Set insertPerson request HEADER$")
	public void set_insertperson_request_header() throws Throwable {

		// HttpPost request=new HttpPost(url + "calculator/insert");
		 bodyPayload = "{\"birthday\": \"17081982\",\"gender\": \"F\",\"name\": \"Elsa\",\"natid\": \"101101\",\"salary\": \"100000\",\"tax\": \"3000\"}";
		postrequest = new HttpPost(url + "calculator/insert");

	}

	@When("^Send a POST insertPerson API HTTP request$")
	public void send_a_post_insertperson_api_http_request() throws Throwable {
		//url = testContextSetup.testBase.getURL();
		
		
		postrequest.setEntity(new StringEntity(bodyPayload));
		 postResponse = testContextSetup.genericUtils.SetPOSTHeader(postrequest);

	}
	
	 @Then("^Receive valid POST Response$")
	    public void receive_valid_post_response() throws Throwable {
		 //response = testContextSetup.genericUtils.SetPOSTHeader(request);
			code = postResponse.getStatusLine().getStatusCode();
			 
			System.out.print("Response Code is" + code);
			
			String responseString = EntityUtils.toString(postResponse.getEntity(), "UTF-8");
			System.out.println("responseString"+responseString);
	    }

	 @Given("^Set insertMultiplePerson request HEADER$")
	    public void set_insertmultipleperson_request_header() throws Throwable {
		 bodyPayload = "[{\"birthday\": \"17081982\",\"gender\": \"F\",\"name\": \"Elsa\",\"natid\": \"101101\",\"salary\": \"100000\",\"tax\": \"3000\"},{\"birthday\": \"17081982\",\"gender\": \"F\",\"name\": \"Elsa\",\"natid\": \"101101\",\"salary\": \"100000\",\"tax\": \"3000\"}]";
			
		 postrequest = new HttpPost(url + "calculator/insertMultiple");
	    }

	 

	 
	@Given("^User submit the Post request$")
	public void user_submit_the_get_request() throws Throwable {

		// JsonPath jsXpath=new JsonPath(responseString);
		// int id=jsXpath.getInt("natid");
		// System.out.println("ID is"+id);
		// Assert.assertEquals(320, id);

	}

}
