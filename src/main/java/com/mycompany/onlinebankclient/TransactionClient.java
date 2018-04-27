/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinebankclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.util.Date;
import javax.ws.rs.core.MediaType;

/**
 *
 * @authors Eithne O'Sullivan -	17132185, Aaron Pope - 13100106, Kenneth Byrne -
 * 17132410, Jemma McCreesh - 16144457 * 
 * @date 18th April 18
 */
public class TransactionClient {

    public static void main(String[] args) {
        
        // NOTE: Server keeps restarting after theis client is started. It may or may not
        // the following requests in before that happens.
        
        try {
            int port = 49000;
            String apiID = "35c4f3863a0d5efc60708589be6b12c5";
            String customerID = "1";
        
            String getUrl = "http://localhost:" + port + "/api/customers/" + apiID + "/" + customerID + "/accounts";
        
           // String getUrl = "http://localhost:" + port + "/api/customers/1/accounts";
            Client client = Client.create();
            WebResource target = client.resource(getUrl);

// --------------------------------------------------------//
            // inspiration for following line of code taken from:
            // https://jersey.github.io/documentation/latest/client.html
            
            String accountID = "1";
           
            String p1 = "/" + accountID + "/transactions";
            
            WebResource targetAcc1 = target.path(p1);
   
        // lodgement transaction//
            Transaction a1 = new  Transaction(1, 1, "credit", new Date(), 20.00, 0.00, "lodgement");
           

            ClientResponse response1 = targetAcc1
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .accept(MediaType.APPLICATION_JSON)
                    .post(ClientResponse.class, a1);

            System.out.println("\n Customer 1, account 1, lodgement:");
            System.out.println(response1.getEntity(String.class));

            // --------------------------------------------------------//
        // get account 1//
        
            String p2 = "/" + accountID;
            WebResource targetAcc2 = target.path(p2);
            ClientResponse response3 = targetAcc2
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .get(ClientResponse.class);

            System.out.println("\n Customer 1, account 1:");
//             System.out.println(response3.getEntity(String.class));

            Account acc1 = response3.getEntity(Account.class);

            System.out.println(acc1);
            // -----------------------------------------------------//
            // Server keeps restarting so updates get lost.

        // withdrawal transaction // 
        
            double amount = 20.00;

            if (acc1.getCurrentBalance() >= amount) {

            Transaction a3 = new  Transaction(1,3, "debit", new Date(), 20.00, 0.00, "withdrawal");
           

            ClientResponse response5 = targetAcc1
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .accept(MediaType.APPLICATION_JSON)
                    .post(ClientResponse.class, a3);
            
                System.out.println("\n Customer 1, account 1, withdrawal:");
                System.out.println(response5.getEntity(String.class));

                // --------------------------------------------------------//
            }

        // transferal transaction //
            
            Transaction a2 = new  Transaction(1,2, "credit", new Date(), 20.00, 0.00, "transferal");

            ClientResponse response6 = targetAcc1
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .accept(MediaType.APPLICATION_JSON)
                    .post(ClientResponse.class, a2);

            System.out.println("\n Customer 1, account 1, transferal:");
            System.out.println(response6.getEntity(String.class));

             // -----------------------------------------------------//
           
        // transactions list//
             
             ClientResponse response7 = targetAcc1
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .get(ClientResponse.class);
            
            System.out.println("\n Customer 1, account 1, transactions:");
            System.out.println(response7.getEntity(String.class));

//            // -----------------------------------------------------//

            // transaction 1/
            
            String p3 = "/" + "1";
            
            WebResource targetAcc3 = targetAcc1.path(p3);
            
            ClientResponse response8 = targetAcc3
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .get(ClientResponse.class);
            
            System.out.println("\n Customer 1, account 1, transaction 1:");
            System.out.println(response8.getEntity(String.class));

//            // -----------------------------------------------------//
        } catch (Exception e) {
            System.out.println("Client error: " + e);
        }
    }
}
