function validateLoginForm() {
    var username = document.forms["loginForm"]["username"].value,
        password = document.forms["loginForm"]["password"].value;

    if(!validateUsername(username)){
        document.getElementById('empty-error-username').innerHTML = " * Username must not be empty";
        document.getElementById('incorrect-username-or-password').innerHTML = "";
    }
    else {
        document.getElementById('empty-error-username').innerHTML = "";
        document.getElementById('incorrect-username-or-password').innerHTML = "";
    }

    if(!validatePassword(password)) {
        document.getElementById('error-password').innerHTML = " * Password must not be empty";
        document.getElementById('incorrect-username-or-password').innerHTML = "";
    }
    else {
        document.getElementById('error-password').innerHTML = "";
        document.getElementById('incorrect-username-or-password').innerHTML = "";
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