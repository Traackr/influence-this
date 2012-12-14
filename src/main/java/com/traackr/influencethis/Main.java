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

import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoException;

/**
 * @author gstathis
 *         Created on: 12/10/12
 */
public class Main {

  private static Logger LOG = LoggerFactory.getLogger(Main.class);
  
  static {
	try {
		DBConnection.Init("mongodb://localhost:27017");
	} catch (MongoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  public static void main(String[] args) {
    LOG.info("Entering Main");
    if (args.length != 1) {
    	System.err.println("Expected exactly one argument, a comma-delimited keyword string! Goodbye!");
    }
    APIDelegate delegate = new APIDelegate();
    Influencer[] influencers = delegate.getInfluencers(args[0]);

	for (Influencer influencer : influencers) {
		System.out.println(influencer.toString());
	}
  }
}