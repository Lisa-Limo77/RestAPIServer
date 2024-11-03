package com.studyopedia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings("deprecation")
			URL url = new URL("http://localhost:8080/api/client2");
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			
			int responseCode = conn.getResponseCode();
			System.out.println("Response Code: " + responseCode);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();
			
			while ((inputLine = in.readLine()) != null)
			{ response.append(inputLine); }
			in.close();
			
		System.out.println("Response from Client 2: " + response.toString());
		} catch (IOException e) { e.printStackTrace();}

	}

}
