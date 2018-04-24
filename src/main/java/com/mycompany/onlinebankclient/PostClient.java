/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinebankclient;

/**
 *
 * @author eithn
 */
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class PostClient {

    public static void main(String[] args) {
        try {
            Client client = Client.create();
            int port = 49000;
            String url = "http://localhost:" + port + "/api/mortgagecalc/echo";
            WebResource webResource = client.resource(url);
            String input = "{\"band\":\"Metallica\",\"title\":\"Fade To Black\"}";
            ClientResponse response = webResource.type("application/json")
                    .post(ClientResponse.class, input);
            String output = response.getEntity(String.class);
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
