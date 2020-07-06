package fr.maevelaouf.discordwebhooksposter;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HTTPRequest {

	public HTTPRequest(String link, String title, String description, String footer, String color) throws IOException {
		OkHttpClient client = new OkHttpClient().newBuilder().build();
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "{\r\n  \"embeds\": [\r\n    {\r\n    \"footer\": {\r\n      \"text\": \"" + footer + "\"},\r\n    \"title\": \"" + title + "\",\r\n    \"description\": \"" + description + "\",\r\n    \"color\": " + color + "\r\n  }\r\n ]\r\n}");
		Request request = new Request.Builder()
			.url(link)
			.method("POST", body)
			.addHeader("Content-Type", "application/json")
			.addHeader("Cookie", "__cfduid=d7ded28eb75264b846e0f7ca2845d08891594058036; __cfruid=be58a72fa8db449a339963ea15535aad82bf9cdd-1594058036")
			.build();
		Response response = client.newCall(request).execute();
		response.close();
	
	}
	
	
	
}