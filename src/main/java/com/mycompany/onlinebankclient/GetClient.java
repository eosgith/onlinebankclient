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
import java.io.IOException;
import javax.ws.rs.core.MediaType;

public class GetClient {

    public static void main(String[] args) {
        int port = 49000;
        String getUrl = "http://localhost:" + port + "/api/customers/1";
        Client client = Client.create();
        WebResource target = client.resource(getUrl);
        ClientResponse response = target
                .type(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);

        System.out.println("\n Customer 1 details:");
        System.out.println(response.getEntity(String.class));

        // --------------------------------------------------------//
        // inspiration for following line of code taken from:
        // https://jersey.github.io/documentation/latest/client.html
        WebResource targetAccs = target.path("accounts");

        ClientResponse response2 = targetAccs
                .type(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);
        
        System.out.println("\n Customer 1, accounts:");
        System.out.println(response2.getEntity(String.class));

        // --------------------------------------------------------//
        // inspiration for following line of code taken from:
        // https://jersey.github.io/documentation/latest/client.html
        WebResource targetAccX = targetAccs.path("/1");

        ClientResponse response3 = targetAccX
                .type(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);

        System.out.println("\n Customer 1, account 1:");
        System.out.println(response3.getEntity(String.class));

        // --------------------------------------------------------//
        // For how to post object in client request, found examples here, and did trial
        // error to get success:
        // https://stackoverflow.com/questions/10335483/how-do-i-post-a-pojo-with-jersey-client-without-manually-convert-to-json
        
        Account a1 = new Account(1, 708091, 1234550, "current");
        
        ClientResponse response4 = targetAccs
                .type(MediaType.APPLICATION_JSON_TYPE)
                .accept(MediaType.APPLICATION_JSON)
                .post(ClientResponse.class, a1);

        System.out.println("\n Customer 1, new account :");
        System.out.println(response4.getEntity(String.class));

        // --------------------------------------------------------//
        // inspiration for following line of code taken from:
        // https://jersey.github.io/documentation/latest/client.html
        WebResource targetAcc2 = targetAccs.path("/2");

        ClientResponse response5 = targetAcc2
                .type(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);

        System.out.println("\n Customer 1, account 2:");
        System.out.println(response5.getEntity(String.class));

        // --------------------------------------------------------//
        
        ClientResponse response6 = targetAccs
                .type(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);
        
        System.out.println("\n Customer 1, accounts:");
        System.out.println(response6.getEntity(String.class));

        // --------------------------------------------------------//


        

    }
}
