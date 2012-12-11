/**
 * MainTest.java - Traackr, Inc.
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

import junit.framework.Assert;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main Test placeholder
 * 
 * @author gstathis
 *         Created on: 12/10/12
 */
public class MainTest {
  
  private static Logger LOG = LoggerFactory.getLogger(MainTest.class);
  
  @Test
  public void sampleTest() {
    LOG.debug("This is a sample test");
    String actualValue = "expected value";
    Assert.assertEquals("A sample test assertion failure message", "expected value", actualValue);
  }
}
