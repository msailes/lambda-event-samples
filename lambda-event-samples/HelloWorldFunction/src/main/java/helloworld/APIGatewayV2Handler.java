package helloworld;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPResponse;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

public class APIGatewayV2Handler implements RequestHandler<APIGatewayV2HTTPEvent, APIGatewayV2HTTPResponse> {

    private static final S3Client client = S3Client.builder()
            .region(Region.EU_WEST_2)
            .credentialsProvider(EnvironmentVariableCredentialsProvider.create())
            .httpClient(UrlConnectionHttpClient.builder().build())
            .build();

    @Override
    public APIGatewayV2HTTPResponse handleRequest(APIGatewayV2HTTPEvent input, Context context) {
        context.getLogger().log(input.getRequestContext().getRequestId());

        client.putObject(PutObjectRequest.builder()
                .bucket("mark-sailes-demo-bucket-ldn")
                .key(input.getRequestContext().getRequestId())
                .build(),
                RequestBody.fromBytes(input.getBody().getBytes()));

        return APIGatewayV2HTTPResponse.builder()
                .withBody("Hello World")
                .withStatusCode(200)
                .build();
    }
}
