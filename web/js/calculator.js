function checkNum() {
    var n1 = document.getElementById("num1").value;
    var n2 = document.getElementById("num2").value;
    //注意这里的空是指空串，不是null
    if (n1 == ""|| n2 == "") {
        window.alert("输入不能为空");
        return false;
    }
  //  var reg = /^[1-9]\d*(\.[0-9]+)?$|^0$/gi;
    if (isNaN(n1) || isNaN(n2)) {
        window.alert("不是数");
        return false;
    }
}