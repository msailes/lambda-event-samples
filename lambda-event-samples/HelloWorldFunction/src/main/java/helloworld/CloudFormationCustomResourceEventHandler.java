package helloworld;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.CloudFormationCustomResourceEvent;

public class CloudFormationCustomResourceEventHandler implements RequestHandler<CloudFormationCustomResourceEvent, String> {

    @Override
    public String handleRequest(CloudFormationCustomResourceEvent input, Context context) {
        context.getLogger().log(input.toString());

        return null;
    }
}
