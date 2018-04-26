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
public class DeleteClient {

    public static void main(String[] args) {
        try {
            
            int port = 49000;
            String apiID = "35c4f3863a0d5efc60708589be6b12c5";
            String customerID = "1";

            String getUrl = "http://localhost:" + port + "/api/customers/" + apiID + "/" 
                    + customerID +"/accounts";
                    
            Client client = Client.create();
            WebResource target = client.resource(getUrl);
     
            String accountID = "1";
            String p1 = "/" + accountID;

            WebResource targetAcc1 = target.path(p1);
            
            ClientResponse response4 = targetAcc1
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .delete(ClientResponse.class);

            System.out.println(response4.getStatus() + "");
            System.out.println("\n Customer 1, deleted account 1:");
                   
            if (response4.getStatus() == 200) {
                System.out.println("deleted: " + response4.getEntity(String.class));

            } else if (response4.getStatus() == 304) {
                System.out.println("balance not 0 : not deleted");
            } else {
                System.out.println("not deleted");
            }
            
               // -----------------------------------------------------//
//            ClientResponse response1 = targetAcc1
//                    .queryParam("transaction", "1")
//                    .queryParam("amount", "20.00")
//                    .type(MediaType.APPLICATION_JSON_TYPE)
//                    .post(ClientResponse.class);
//
//            System.out.println("\n Customer 1, account 1, lodgement:");
//            System.out.println(response1.getEntity(String.class));
//
//            // -----------------------------------------------------//
//            ClientResponse response2 = targetAcc1
//                    .type(MediaType.APPLICATION_JSON_TYPE)
//                    .delete(ClientResponse.class);
//
//            System.out.println(response2.getStatus() + "");
//            System.out.println("\n Customer 1, deleted account 1:");
//
//            if (response2.getStatus() == 200) {
//                System.out.println("deleted: " + response1.getEntity(String.class));
//
//            } else if (response2.getStatus() == 304) {
//                System.out.println("balance not 0 : not deleted");
//            } else {
//                System.out.println("not deleted");
//            }
//            // -----------------------------------------------------//
//
//            ClientResponse response3 = targetAcc1
//                    .queryParam("transaction", "3")
//                    .queryParam("amount", "20.00")
//                    .type(MediaType.APPLICATION_JSON_TYPE)
//                    .post(ClientResponse.class);
//
//            System.out.println("\n Customer 1, account 1, withdrawal:");
//            System.out.println(response3.getEntity(String.class));

                        // -----------------------------------------------------//

            
        } catch (Exception e) {
            System.out.println("Client error: " + e);
        }
    }
}
