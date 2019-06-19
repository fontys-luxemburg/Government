package government.controller;



import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import government.model.User;


public class mailHelper {

	public static JsonNode sendMailToUserMailGun(User user, String password) throws UnirestException {
		HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + "mg.zwemkampwzv.nl" + "/messages")
				.basicAuth("api",System.getenv("SMTP_PASSWORD") )
				.field("from", "postmaster@mg.zwemkampwzv.nl")
				.field("to", user.getEmail())
				.field("subject", "Account creation")
				.field("text", "username: " + user.getEmail() + " wachtwoord: " + password)
				.asJson();
		return request.getBody();
	}
}
