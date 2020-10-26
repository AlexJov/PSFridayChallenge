
function getProducts() {
    var allProducts = [
        {"id" : 1, "name" : "Guinea pig grooming spray", "description" : "Keep your guinea pig looking fabulous.", "price" : 199},
        {"id" : 2, "name" : "Parrot reward biscuits", "description" : "Even the pickiest biscuit eaters find it rewarding.", "price" : 19},
        {"id" : 3, "name" : "Fat-Cat diet supplement", "description" : "One per month per cat.", "price" : 2000},
        {"id" : 4, "name" : "Good Boi mini plush toy", "description" : "Irresistible to any puppy.", "price" : 28}
     ];
    return allProducts;
}
 
exports.handler = async (event) => {

    console.log('Received event: ', event);
    var retstr = await getProducts();
     
    const response = {
        statusCode: 200,
        body: retstr,
    };
    return response;

};



