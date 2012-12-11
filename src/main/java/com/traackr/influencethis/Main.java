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
    APIDelegate delegate = new APIDelegate();
    delegate.getInfluencers(args[0]);
  }
}