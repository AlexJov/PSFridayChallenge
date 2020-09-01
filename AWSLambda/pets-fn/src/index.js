var AWS = require('aws-sdk')

// Gets fixed list of pets
function getPets() {
    var allPets = [
        {"id" : 1, "name" : "Fluffy", "petType" : "Cat", "age" : 5 },
        {"id" : 2, "name" : "Bubbly", "petType" : "Goldfish", "age" : 1},
        {"id" : 3, "name" : "Sleepy", "petType" : "Dog", "age" : 3},
        {"id" : 4, "name" : "Jumpy", "petType" : "Shark", "age" : 180}
    ];
    return allPets;
}
 
// Invokes lambda using passed parameters
const invokeLambda = async (params) => {
    var lambda = new AWS.Lambda();
    const data = await lambda.invoke(params).promise();
    return data;
}


exports.handler = async (event) => {
    var retstr = [];
    var response = {};
    var input = event.input;
    switch(input) {
        case "pets" :
            retstr = await getPets();
            response = {
                statusCode: 200,
                body: retstr,
                };
            return response;
        case "products" :
            var params = {
                FunctionName : 'FUNCTION_NAME_HERE', // here set another AWS Function Name (just a name, not ARN)
                InvocationType : 'RequestResponse', 
                Payload : '{"input": "products"}'
            };
            retstr = await invokeLambda(params);
            response = {
                statusCode: 200,
                body: retstr,
            };
            return response;
    }
};
