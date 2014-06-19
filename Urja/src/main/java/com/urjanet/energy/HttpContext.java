package com.urjanet.energy;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

@Configuration
public class HttpContext {
	
	@Bean
	public CloseableHttpClient httpClient() {
	    return HttpClients.createDefault();
	}
	/**
	 * instantiate Gson object
	 * @return
	 */
	@Bean
	public Gson getGson(){
		return new Gson();
	}
}