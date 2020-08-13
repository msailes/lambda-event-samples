package helloworld;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.ConnectEvent;

/**
 * Handler for requests to Lambda function.
 */
public class AmazonConnectHandler implements RequestHandler<ConnectEvent, String> {

    public String handleRequest(ConnectEvent event, final Context context) {
        context.getLogger().log(event.toString());

        return "OK";
    }
}
