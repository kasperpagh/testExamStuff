
exports.func_tri = function(a, b, c, callback) {
    if(typeof(a) != "number"  || typeof(b) != "number"||typeof(c) != "number"){
        callback(0)
    }
    else if( a+b==c || a+c==b || b+c==a){
        callback(0)
    }
    else if(a <= 0 || b <= 0 || c <= 0){
        callback(0)
    }
    else if (a === b && b === c) {
        callback(1)
    }
    else if (a === b || b === c || c === a) {
        callback(2)
    }
    else if (a !== b && b !== c && c !== a) {
        callback(3)
    }
    else {
        callback(0)
    }
}
/*
let arr = [[3,3,3,1], [3,3,2,2], [4,5,6,3],[0,1,2,0],[0,0,0,0],[0,0,1,0],[2,2,4,0],["2",1,2,0],["&",2,2,0]]
let arr_res = ["not a triangle", "Equilateral triangle", "Isosceles triangle", "Scalene triangle"];
for (let i = 0; i < arr.length; i++) {
    func_tri(arr[i][0], arr[i][1], arr[i][2], (ele) => {
        console.log("expected: " + arr_res[arr[i][3]], "     got: " + arr_res[ele], "              test accepted: " + (ele == arr[i][3]));
    })
}*/


