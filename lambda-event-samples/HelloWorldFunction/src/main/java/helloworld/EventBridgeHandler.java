package helloworld;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.EventBridgeEvent;

public class EventBridgeHandler implements RequestHandler<EventBridgeEvent, String> {
    @Override
    public String handleRequest(EventBridgeEvent input, Context context) {
        context.getLogger().log(input.toString());

        return null;
    }
}
