package com.traackr.influencethis;

import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

public class APIDelegate {
	
	public Influencer[] getInfluencers(String commaSeparatedKeywords) {
		
		Influencer[] influencers = new Influencer[0];

	    HttpClient httpclient = new DefaultHttpClient();
	    URIBuilder builder = new URIBuilder();
	    builder.setScheme("https").setHost("api-qa.traackr.com").setPath("/1.0/search/influencers")
	    	.setParameter("keywords", commaSeparatedKeywords)
	    	.setParameter("key", "ac03630f937f9c0ed27cfca2e6380a5a409234db");
	    try {
	    	URI uri = builder.build();
	        HttpGet httpget = new HttpGet(uri);
	        System.out.println("URI is" + httpget.getURI());
	        HttpResponse response = httpclient.execute(httpget);
	        HttpEntity entity = response.getEntity();
	    	String responseJson = EntityUtils.toString(entity);
	    	
	    	Gson gson = new Gson();
	    	InfluencerJsonContainer influencerContainer = gson.fromJson(responseJson, InfluencerJsonContainer.class);
	    	influencers = influencerContainer.getInfluencers();
	    } catch(Exception e) {
	    	System.out.println(e);
	    }
    	return influencers;
	}

}
