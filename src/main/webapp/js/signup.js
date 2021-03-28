function validateSigninForm() {
    var username = document.forms["signinForm"]["username"].value,
        password = document.forms["signinForm"]["password"].value,
        firstName = document.forms["signinForm"]["firstName"].value,
        lastName = document.forms["signinForm"]["lastName"].value,
        email = document.forms["signinForm"]["email"].value,
        phone = document.forms["signinForm"]["phone"].value,
        province = document.forms["signinForm"]["province"].value,
        continuationAddress = document.getElementById("continuationAddress").value;

    // var city = document.forms["signinForm"]["city"].value;
    // console.log(province + " " + provincesAndCities[province][city]);

    if(!validateUsername(username)){
        document.getElementById('empty-error-username').innerHTML = " * Username must not be empty";
    }
    else {
        document.getElementById('empty-error-username').innerHTML = "";
    }

    if(!validatePassword(password)) {
        document.getElementById('error-password').innerHTML = " * Password must be at least 8 digits and a combination of letters and numbers";
    }
    else {
        document.getElementById('error-password').innerHTML = "";
    }

    if(!validateName(firstName)){
        document.getElementById('error-firstName').innerHTML = " * First name must be made up of letters";
    }
    else {
        document.getElementById('error-firstName').innerHTML = "";
    }

    if(!validateName(lastName)){
        document.getElementById('error-lastName').innerHTML = " * Last name must be made up of letters";
    }
    else {
        document.getElementById('error-lastName').innerHTML = "";
    }

    if (!validatePhone(phone)) {
        document.getElementById('error-phone').innerHTML = " * Phone number must be 11 digits and start with 09";
    }
    else {
        document.getElementById('error-phone').innerHTML = "";
    }

    if (!validateEmail(email)) {
        document.getElementById('error-email').innerHTML = " * Email format must be as example@example.example";
    }
    else {
        document.getElementById('error-email').innerHTML = "";
    }

    if (!validateProvince(province)) {
        document.getElementById('error-province').innerHTML = " * Select province from the list";
    }
    else {
        document.getElementById('error-province').innerHTML = "";
    }

    if (!validationContinuationAddress(continuationAddress)) {
        document.getElementById('error-continuationAddress').innerHTML = " * Continuation address must not be empty";
    }
    else {
        document.getElementById('error-continuationAddress').innerHTML = "";
    }

    if(!validateUsername(username) || !validatePassword(password) || !validateName(firstName) ||
        !validateName(lastName) || !validatePhone(phone) || !validateEmail(email) ||
        !validateProvince(province) || !validationContinuationAddress(continuationAddress)) {
        return false;
    }
}

function validateUsername(username) {
    return JSON.stringify(username).length - 2 > 0;
}

function validatePassword(password) {
    var passwordRGEX = /^([a-zA-Z0-9!@#$%^&*]*(?=.*[0-9])[a-zA-Z0-9!@#$%^&*]*){8,}$/;
    return passwordRGEX.test(password);

}

function validateName(name) {
    var nameRGEX = /^([a-z]|[A-Z])+$/;
    return nameRGEX.test(name);

}

function validatePhone(phone) {
    var phoneRGEX = /^09\d{9}$/;
    return phoneRGEX.test(phone);

}

function validateEmail(email) {
    var emailRGEX = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    return emailRGEX.test(email);

}

function validateProvince(province) {
    return province.length > 0;

}

function validationContinuationAddress(continuationAddress) {
    return JSON.stringify(continuationAddress).length - 2 > 0;
}

function changeProvinceCities() {
    var provincesAndCities = {};
    provincesAndCities['alborz'] = ['Karaj', 'Asara', 'Taleghan'];
    provincesAndCities['tehran'] = ['Malard', 'Varamin', 'Firouzkouh', 'Parand'];
    provincesAndCities['kermanshah'] = ['Kangavar', 'Sahneh', 'Bistoun'];

    var provinceList = document.getElementById("province"),
        cityList = document.getElementById("city"),
        selProvince = provinceList.options[provinceList.selectedIndex].value;

    while(cityList.options.length) {
        cityList.remove(0);
    }

    var provinces = provincesAndCities[selProvince];

    if(provinces) {
        var i;
        for(i = 0; i < provinces.length; i++) {
            var province = new Option(provinces[i], i);
            cityList.options.add(province);
        }
    }
}
