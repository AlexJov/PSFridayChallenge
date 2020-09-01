#!/bin/bash

cd src/

rm -r ProductsFn.zip

zip -r ProductsFn.zip .

aws lambda update-function-code \
--function-name FUNTION_NAME_HERE \
--zip-file fileb://ProductsFn.zip \
--profile default

exit 0