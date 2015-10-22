package com.mobislet.http;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import javax.ws.rs.core.Response.Status;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

public class HttpManager {

	public HttpManager() {
	}

	public static int httpPost(String urlStr,
			Map<String, String> paramNameTypeMap,
			Map<String, String> paramNameValueMap,
			String targetPhoneNo) {
		URL url = null;
		HttpURLConnection conn = null;
		BufferedWriter out = null;

		try {
			url = new URL(urlStr);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setAllowUserInteraction(false);
			conn.setRequestProperty("Content-type", "application/json");
			conn.setRequestProperty("Authorization", "key="
					+ "");

			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			JSONObject jsonPayload = new JSONObject();
			String name;
			String type;
			String value;
			for (Map.Entry<String, String> entry : paramNameTypeMap.entrySet()) {
				name = entry.getKey();
				type = entry.getValue();
				value = paramNameValueMap.get(name);

				if ("header".equals(type)) {
					if (name.startsWith("registration_id")) {
						jsonArray.put(value);
					} else {
						jsonObject.accumulate(name, value);
					}
				} else if ("payload".equals(type)) {
					jsonPayload.accumulate(name, value);
				}
			}

			jsonObject.accumulate("registration_ids", jsonArray);
			jsonObject.accumulate("data", jsonPayload);

			out = new BufferedWriter(new OutputStreamWriter(
					conn.getOutputStream()));
			out.write(jsonObject.toString());
			out.flush();
			out.close();

			//Canonical ID Process
			try{
				JSONObject responseJson = getResponseJSON(conn.getInputStream());
				JSONArray resultsArray = responseJson.getJSONArray("results");
				
				String newRegistrationId = null;
				if(resultsArray != null){
					for(int i = 0; i<resultsArray.length(); i++){
						JSONObject obj = (JSONObject) resultsArray.get(i);
						
						if(obj.has("registration_id")){
							newRegistrationId = obj.getString("registration_id");//Birden fazlaysa ilkini alir
							break;
						}
					}
				}
				
//				if(newRegistrationId != null && newRegistrationId.length() > 0)
//					BrandManager.registerPhone(targetPhoneNo, newRegistrationId);	
			}catch(Exception e){
				e.printStackTrace();
			}
			//Canonical ID Process
			
			int responseCode = conn.getResponseCode();
			String responseMessage = conn.getResponseMessage();
			System.out.println("URL:" + urlStr + "\nJSON:" + jsonObject.toString() + "\nRESPONSE CODE:" + conn.getResponseCode() + "\nRESPONSE MESSAGE:" + responseMessage);
			
			return responseCode;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				conn.disconnect();
			} catch (IOException e) {}
		}

		return Status.INTERNAL_SERVER_ERROR.getStatusCode();
	}

	private static JSONObject getResponseJSON(InputStream inputStream) {
		JSONObject responseJSON = null;
		try {
			InputStreamReader responseReader = new InputStreamReader(inputStream);
			StringBuffer responseBuffer = new StringBuffer();
			// Read incoming character-by-character
			int responseChar = responseReader.read();
			
			while (responseChar != -1) {
				responseBuffer.append(Character.toChars(responseChar));
				responseChar = responseReader.read(); // Read next character
			}
			responseReader.close();
			
			String responseStr = "";
			if(responseBuffer != null)
				responseStr = responseBuffer.toString();
			
			if(responseStr.length() > 0){
				try{
					responseJSON = new JSONObject(responseStr);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return responseJSON;
	}
}
