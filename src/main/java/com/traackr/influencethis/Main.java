/**
 * Main.java - Traackr, Inc.
 * 
 * This document set is the property of Traackr, Inc., a Massachusetts
 * Corporation, and contains confidential and trade secret information. It
 * cannot be transferred from the custody or control of Traackr except as
 * authorized in writing by an officer of Traackr. Neither this item nor the
 * information it contains can be used, transferred, reproduced, published,
 * or disclosed, in whole or in part, directly or indirectly, except as
 * expressly authorized by an officer of Traackr, pursuant to written
 * agreement.
 * 
 * Copyright 2012-2013 Traackr, Inc. All Rights Reserved.
 */
package com.traackr.influencethis;

import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author gstathis
 *         Created on: 12/10/12
 */
public class Main {
	
  private static Logger LOG = LoggerFactory.getLogger(Main.class);
  
  public static void main(String[] args) {
    LOG.info("Entering Main");
    if (args.length != 1) {
    	System.err.println("Expected exactly one argument, a comma-delimited keyword string! Goodbye!");
    }
    HttpClient httpclient = new DefaultHttpClient();
    URIBuilder builder = new URIBuilder();
    builder.setScheme("https").setHost("api-qa.traackr.com").setPath("/1.0/search/influencers")
    	.setParameter("keywords",args[0])
    	.setParameter("key", "ac03630f937f9c0ed27cfca2e6380a5a409234db");
    try {
    	URI uri = builder.build();
        HttpGet httpget = new HttpGet(uri);
        System.out.println("URI is" + httpget.getURI());
        HttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
    	String responseString = EntityUtils.toString(entity);
    	
    	System.out.println(responseString);
    	
    } catch(Exception e) {
    	System.out.println(e);
    }
  }
}