#!/bin/bash

# create role 
aws iam create-role --role-name lambda-invoke-role \
--assume-role-policy-document file://lambda-invoke-role.json \
--profile default

# create policy
aws iam create-policy --policy-name lambda-invoke-policy \
--policy-document file://lambda-invoke-policy.json \
--profile default

# attach policy to role
aws iam attach-role-policy --policy-arn arn:aws:iam::ACCOUNT_ID_HERE:policy/lambda-invoke-policy \
--role-name lambda-invoke-role \
--profile default

exit 0




