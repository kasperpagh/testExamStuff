let junit = require("junit");
let triangle = require("./triangle.js")
let it = junit();

    (async () => {
        let arr = [[3, 3, 3, 1], [3, 3, 2, 2], [4, 5, 6, 3], [0, 1, 2, 0], [0, 0, 0, 0], [0, 0, 1, 0], [2, 2, 4, 0], ["2", 1, 2, 0]]
        let arr_res = ["not a triangle", "Equilateral triangle", "Isosceles triangle", "Scalene triangle"];
        for (let i = 0; i < arr.length; i++) {
            it(arr_res[arr[i][3]]+" test ", () => triangle.func_tri(arr[i][0], arr[i][1], arr[i][2], (ele) => {
            it.eq(ele, arr[i][3]);
            }))}
            // Get the result of the test. 
            let { total, tested, passed, failed } = await it.run();
        })();