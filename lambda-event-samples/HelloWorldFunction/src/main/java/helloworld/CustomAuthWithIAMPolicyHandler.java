package helloworld;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayCustomAuthorizerEvent;
import com.amazonaws.services.lambda.runtime.events.IamPolicyResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.amazonaws.services.lambda.runtime.events.IamPolicyResponse.VERSION_2012_10_17;
import static com.amazonaws.services.lambda.runtime.events.IamPolicyResponse.denyStatement;
import static java.util.Collections.singletonList;

public class CustomAuthWithIAMPolicyHandler implements RequestHandler<APIGatewayCustomAuthorizerEvent, IamPolicyResponse> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public IamPolicyResponse handleRequest(APIGatewayCustomAuthorizerEvent input, Context context) {
        context.getLogger().log(input.getMethodArn());

        IamPolicyResponse iamPolicyResponse = IamPolicyResponse.builder()
                .withPrincipalId("me")
                .withPolicyDocument(IamPolicyResponse.PolicyDocument.builder()
                        .withVersion(VERSION_2012_10_17)
                        .withStatement(singletonList(denyStatement(input.getMethodArn())))
                        .build())
                .build();

        try {
            context.getLogger().log(objectMapper.writeValueAsString(iamPolicyResponse));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return iamPolicyResponse;
    }
}
