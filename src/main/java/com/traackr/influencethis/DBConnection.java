package com.traackr.influencethis;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.MongoURI;

public class DBConnection {
//	private final Mongo _mongoServer;
	private final DB _influenceDB;
	private final DBCollection _coll;
	// connecect to the mongoDB server and open a collection for writing 
	private DBConnection(final String uri) throws MongoException, UnknownHostException {
//	    String mongoURIString = "mongodb://localhost:27017";
	    final MongoURI mongoURI = new MongoURI(uri);
	    final Mongo mongoServer = new Mongo(mongoURI);
	    _influenceDB = mongoServer.getDB("influence-this");
	    _coll = _influenceDB.getCollection("coltest");
	}
	private static DBConnection _cnx = null;
	// creation process: mongoDB connection
	public static final void Init(final String uri) throws MongoException, UnknownHostException {
		if (null == _cnx) _cnx = new DBConnection(uri);
	}
	
	public static final DBConnection GetInstance() {
		if (null == _cnx) throw new IllegalStateException("You have to call DBConnection::Init() first");
		return _cnx;
	}
	/*
	public static final boolean Store() {
		
	}
	*/
}
