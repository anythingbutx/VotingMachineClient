/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network.util;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hudson
 */
public class RestConnector {

    private static HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private static JsonFactory JSON_FACTORY = new JacksonFactory();
    //TODO: put baseURL in a config file at some point.
    private static String baseURL = "http://localhost:8080";

    public List<BallotDTO> getBallots(String voterID) {
        try {
            HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory((HttpRequest request) -> {
                request.setParser(new JsonObjectParser(JSON_FACTORY));
            });
            GenericUrl url = new GenericUrl(baseURL+"/api/get/ballots/"+voterID);
            Type type = new TypeToken<List<BallotDTO>>() {}.getType();
            HttpRequest request = requestFactory.buildGetRequest(url);
            List<BallotDTO> Ballots = (List<BallotDTO>)request.execute().parseAs(type);
            return Ballots;
        } catch (IOException ex) {
            Logger.getLogger(RestConnector.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<BallotDTO>();
        }
    }
    
    
    
    public boolean postVote(String voterID, Long candidateID) {
        try {
            HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory((HttpRequest request) -> {
                request.setParser(new JsonObjectParser(JSON_FACTORY));
            });
            GenericUrl url = new GenericUrl(baseURL+"/api/post/vote/"+voterID+"/"+candidateID);
            HttpRequest request = requestFactory.buildGetRequest(url);
            request.execute();
        } catch (IOException ex) {
            Logger.getLogger(RestConnector.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
}
