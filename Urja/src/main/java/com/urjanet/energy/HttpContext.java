package com.urjanet.energy;

import java.lang.reflect.Type;
import java.util.Date;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

@Configuration
public class HttpContext {

	@Bean
	public CloseableHttpClient httpClient() {
//		return HttpClients.createDefault();
		return HttpClientBuilder.create().build();
	}

	/**
	 * instantiate Gson object
	 * 
	 * @return
	 */
//	@Bean
//	public Gson getGson() {
//		return new Gson();
//	}

	@Bean
	public Gson customDateGson() {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
			String pattern = "yyyy-MM-dd'T'HH:mm:ssZ";
			DateTimeFormatter dtf = DateTimeFormat.forPattern(pattern);

			@Override
			public Date deserialize(JsonElement json, Type arg1,
					JsonDeserializationContext arg2) throws JsonParseException {
				return dtf.parseDateTime(json.getAsString()).toDate();
			}
		});
		return builder.create();
	}
}