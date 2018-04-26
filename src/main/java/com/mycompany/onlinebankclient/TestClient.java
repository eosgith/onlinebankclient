/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinebankclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author eithn
 */
public class TestClient {
    
    public static void main(String[] args) {
        try {
            int port = 49000;
            String getUrl = "http://localhost:" + port + "/api/customers/1/accounts";
            Client client = Client.create();
            WebResource target = client.resource(getUrl);
            
            WebResource targetAcc1 = target.path("/1");
            
            ClientResponse response1 = targetAcc1
                    .queryParam("transaction", "1")
                    .queryParam("amount", "20.00")
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .post(ClientResponse.class);

            System.out.println("\n Customer 1, account 1, lodgement:");
            System.out.println(response1.getEntity(String.class));
            // -----------------------------------------------------//
        } catch (Exception e) {
            System.out.println("Client error: " + e);
        }
    }
}
