package helloworld;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.S3ObjectLambdaEvent;
import org.apache.http.client.fluent.Request;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.WriteGetObjectResponseRequest;

import java.io.IOException;

import static software.amazon.awssdk.core.sync.RequestBody.fromString;

public class S3ObjectRequestHandler {

    private static final S3Client s3Client = S3Client.create();

    public void handleRequest(S3ObjectLambdaEvent event, Context context) throws IOException {
        String s3Body = Request.Get(event.inputS3Url()).execute().returnContent().asString();

        String responseBody = s3Body.toUpperCase();

        WriteGetObjectResponseRequest request = WriteGetObjectResponseRequest.builder()
                .requestRoute(event.outputRoute())
                .requestToken(event.outputToken())
                .build();
        s3Client.writeGetObjectResponse(request, fromString(responseBody));
    }
}
