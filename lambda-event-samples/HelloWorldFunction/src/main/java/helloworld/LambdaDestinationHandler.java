package helloworld;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.LambdaDestinationEvent;

public class LambdaDestinationHandler implements RequestHandler<LambdaDestinationEvent, String> {

    @Override
    public String handleRequest(LambdaDestinationEvent input, Context context) {
        context.getLogger().log(input.toString());

        return null;
    }
}
