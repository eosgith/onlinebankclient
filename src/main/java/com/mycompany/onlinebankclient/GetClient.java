/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinebankclient;

/**
 * Client program to test out the api of the onlinebank server from aspect of
 * customer and account display and add new account requests..
 * @authors Eithne O'Sullivan -	17132185, Aaron Pope - 13100106, Kenneth Byrne -
 * 17132410, Jemma McCreesh - 16144457 * 
 * @date 18th April 18
 */
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;

public class GetClient {

    public static void main(String[] args) {
        int port = 49000;
        String apiID = "35c4f3863a0d5efc60708589be6b12c5";
        String customerID = "1";
        
        String getUrl = "http://localhost:" + port + "/api/customers/" + apiID + "/" + customerID;
        
        // NOTE: Server keeps restarting after theis client is started. It may or may not
        // the following requests in before that happens. Aim was to add in code 
        // accept input from user to select customer number and accoun , but this gave 
        // the server time to auto-restart so have stuch with fixed number inputs
        // for the tests.

//        System.out.println("\nEnter customer number as 1 or 2,3,4,5");
//        
//        Scanner keyboard;
//        keyboard = new Scanner(System.in);
//        
//        String input = keyboard.nextLine();
//        getUrl = getUrl + "/" + input;
        
        
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
        String accountID = "1";
        String p1 = "/" + accountID;
        WebResource targetAccX = targetAccs.path(p1);

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
        
        String accountID2 = "2";
        String p2 = "/" + accountID2;
        WebResource targetAcc2 = targetAccs.path(p2);

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
