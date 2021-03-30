function validateResult() {
    var result = document.getElementById('result').value;
     if (JSON.stringify(result).length - 2 === 0) {
         document.getElementById('error-incorrect-result').innerHTML = "";
         document.getElementById('empty-error-result').innerHTML = " * Result must not be empty";
         return false;
     }
     else {
         document.getElementById('empty-error-result').innerHTML = "";
     }
}