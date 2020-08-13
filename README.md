# lambda-event-samples
A heap of different lambda samples for event source testing.

## Amazon Connect

AmazonConnectHandler
https://eu-west-2.console.aws.amazon.com/connect/home?region=eu-west-2#
Follow the default getting started steps
Once it's ready go to the instance

routing - Contact flows
Sample Lambda integration
save & publish
update the lambda arn to your lambda
dial the number :)

## Secrets Manager Rotation Event

Store a new secret in Secrets Manager
Configure rotation
Choose your lambda function
Ensure that the function policy grants access to the principal secretsmanager.amazonaws.com.\

$ aws lambda add-permission --function-name lambda-event-samples-SecretsManagerRotationFunctio-G8E9ZKHMBDJB --action lambda:InvokeFunction --statement-id secretsManagerRotation \
--principal secretsmanager.amazonaws.com --output text

Go into the stored secret, select rotate immediately 