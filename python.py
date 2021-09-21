import boto3

s3 = boto3.client('s3')

print('Original object from the S3 bucket:')
original = s3.get_object(
  Bucket='msailes-example-private-data',
  Key='s3.txt')
print(original['Body'].read().decode('utf-8'))

print('Object processed by S3 Object Lambda:')
transformed = s3.get_object(
  Bucket='arn:aws:s3:eu-west-2:719169216310:accesspoint/private-data-access',
  Key='s3.txt')
print(transformed['Body'].read().decode('utf-8'))