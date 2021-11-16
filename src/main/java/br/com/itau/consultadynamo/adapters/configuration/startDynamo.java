package br.com.itau.consultadynamo.adapters.configuration;


import br.com.itau.consultadynamo.application.entities.Estudante;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;
import com.google.gson.Gson;

import java.util.Arrays;

public class startDynamo {

    public static void main(String[] args) throws Exception {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "sa-east-1"))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        String tableName = "estudante";

        try {
            /*System.out.println("Attempting to create table; please wait...");
            Table table = dynamoDB.createTable(tableName,
                    Arrays.asList(new KeySchemaElement("id_estudante", KeyType.HASH), // Partition
                            // key
                            new KeySchemaElement("id_codigo", KeyType.RANGE)), // Sort key
                    Arrays.asList(new AttributeDefinition("id_estudante", ScalarAttributeType.S),
                            new AttributeDefinition("id_codigo", ScalarAttributeType.S)),
                    new ProvisionedThroughput(10L, 10L));
            table.waitForActive();
            System.out.println("Success.  Table status: " + table.getDescription().getTableStatus());
*/
            Estudante e = new Estudante();
            Table table = dynamoDB.getTable(tableName);
            e.setEmailEstudante("antonis2004@hotmail.com");
            e.setIdEstudante("00002");
            e.setNomeEstudante("Valéria de Araújo Campos Oliveira");
            Gson gson = new Gson();
            table.putItem(
                    new Item().withPrimaryKey("id_estudante","001")
                            .withString("id_codigo", "002")
                            .withJSON("estudante", gson.toJson(e)));

        }
        catch (Exception e) {
            System.err.println("Unable to create table: ");
            System.err.println(e.getMessage());
        }

    }



}
