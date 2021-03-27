function validateLoginForm() {
    var username = document.forms["loginForm"]["username"].value,
        password = document.forms["loginForm"]["password"].value;

    if(!validateUsername(username)){
        document.getElementById('empty-error-username').innerHTML = " * Username must not be empty";
    }
    else {
        document.getElementById('empty-error-username').innerHTML = "";
    }

    if(!validatePassword(password)) {
        document.getElementById('error-password').innerHTML = " * Password must not be empty";
    }
    else {
        document.getElementById('error-password').innerHTML = "";
    }

    if(!validateUsername(username) || !validatePassword(password)) {
        return false;
    }

    function validateUsername(username) {
        return JSON.stringify(username).length - 2 > 0;

    }

    function validatePassword(password) {
        return JSON.stringify(password).length - 2 > 0;

    }
}