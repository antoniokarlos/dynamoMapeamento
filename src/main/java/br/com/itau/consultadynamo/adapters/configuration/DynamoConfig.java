package br.com.itau.consultadynamo.adapters.configuration;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
@Component
public class DynamoConfig {

    private static AmazonDynamoDB amazonDynamoDB;

    @Bean
    private static AmazonDynamoDB getAmazonDynamoDB(){

        BasicAWSCredentials credentials =
                new BasicAWSCredentials(
                        "1","dev2021");

        AWSCredentialsProvider awsCredentialsProvider =
                new AWSStaticCredentialsProvider(credentials);

        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "sa-east-1"))
                .withCredentials(awsCredentialsProvider)
                .build();
    }
    @Bean
    public static DynamoDBMapper dynamoDBMapper(){
        if(amazonDynamoDB == null){
            amazonDynamoDB = getAmazonDynamoDB();
        }
        return new DynamoDBMapper(amazonDynamoDB);
    }
}
