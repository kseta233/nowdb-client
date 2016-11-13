package com.eworkbandung.nowdb.example.constant;

/**
 * Created by Seta on 9/3/16.
 */
public class RestAPI {
    private RestAPI(){
    }

    public static final String BASE_API_URL = "http://io.nowdb.net";
    public static final String BASE_API_VERSION = "v2";
    public static final String API_URL = BASE_API_URL + "/" + BASE_API_VERSION + "/";

    //SPECIAL FOR NOWDB
    public static final String NOWDB_TOKEN = "538d67698d909eca7dfb20a3";
    public static final String NOWDB_APPID = "57ca510c1f6d04fe523f718a";
    public static final String NOWDB_PROJECT= "testnowdb";
    public static final String DUMMY_ID = "57ca77851f6d0401533f71a8";

    //FOR COLLECTIONS
    public class Collection{
        public static final String TODO = "todo";
    }
}
