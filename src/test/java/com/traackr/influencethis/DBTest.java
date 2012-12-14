package com.traackr.influencethis;

import java.net.UnknownHostException;

import com.mongodb.MongoException;

public class DBTest {
	public static final boolean CanConnect(final String uri){
		try {
			DBConnection.Init(uri);
		} catch (MongoException e) {
			return false;
		} catch (UnknownHostException e) {
			return false;
		}
		return true;
	}
}
