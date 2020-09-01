#!/bin/bash

cd src/

rm -r PetsFn.zip

zip -r PetsFn.zip .

aws lambda update-function-code \
--function-name FUNCTION_NAME_HERE \
--zip-file fileb://PetsFn.zip \
--profile default

exit 0