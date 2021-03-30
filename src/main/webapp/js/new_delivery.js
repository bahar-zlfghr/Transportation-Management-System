function validateNewDeliveryForm() {
    var originProvince = document.forms["newDeliveryForm"]["originProvince"].value,
        originContinuationAddress = document.getElementById("originContinuationAddress").value,
        destinationProvince = document.forms["newDeliveryForm"]["destinationProvince"].value,
        destinationContinuationAddress = document.getElementById("destinationContinuationAddress").value,
        recipientFirstName = document.forms["newDeliveryForm"]["recipientFirstName"].value,
        recipientLastName = document.forms["newDeliveryForm"]["recipientLastName"].value,
        recipientPhone = document.forms["newDeliveryForm"]["recipientPhone"].value,
        transportType = document.forms["newDeliveryForm"]["transportType"].value,
        parcelPostWeight = document.forms["newDeliveryForm"]["parcelPostWeight"].value;

    document.getElementById('error-parcel-post-content').innerHTML = "";
    document.getElementById('error-parcel-post-length').innerHTML = "";
    document.getElementById('error-parcel-post-width').innerHTML = "";
    document.getElementById('error-parcel-post-height').innerHTML = "";

    // origin
    if(!validateProvince(originProvince)){
        document.getElementById('error-origin-province').innerHTML = " * Select province from the list";
    }
    else {
        document.getElementById('error-origin-province').innerHTML = "";
    }

    if(!validationContinuationAddress(originContinuationAddress)) {
        document.getElementById('error-origin-continuationAddress').innerHTML = " * Continuation address must not be empty";
    }
    else {
        document.getElementById('error-origin-continuationAddress').innerHTML = "";
    }

    // destination
    if(!validateProvince(destinationProvince)){
        document.getElementById('error-destination-province').innerHTML = " * Select province from the list";
    }
    else {
        document.getElementById('error-destination-province').innerHTML = "";
    }

    if(!validationContinuationAddress(destinationContinuationAddress)) {
        document.getElementById('error-destination-continuationAddress').innerHTML = " * Continuation address must not be empty";
    }
    else {
        document.getElementById('error-destination-continuationAddress').innerHTML = "";
    }

    // recipient first name
    if(!validateName(recipientFirstName)){
        document.getElementById('error-recipient-firstName').innerHTML = " * First name must be made up of letters";
    }
    else {
        document.getElementById('error-recipient-firstName').innerHTML = "";
    }

    // recipient last name
    if(!validateName(recipientLastName)){
        document.getElementById('error-recipient-lastName').innerHTML = " * Last name must be made up of letters";
    }
    else {
        document.getElementById('error-recipient-lastName').innerHTML = "";
    }

    // recipient phone
    if(!validatePhone(recipientPhone)){
        document.getElementById('error-recipient-phone').innerHTML = " * Phone number must be 11 digits and start with 09";
    }
    else {
        document.getElementById('error-recipient-phone').innerHTML = "";
    }

    // transport type
    if(!validateEmptyElement(transportType)){
        document.getElementById('error-transport-type').innerHTML = " * Transport type must not be empty";
    }
    else {
        document.getElementById('error-transport-type').innerHTML = "";
    }

    // box weight
    if(!validateEmptyElement(parcelPostWeight)){
        document.getElementById('error-parcel-post-weight').innerHTML = " * Weight must not be empty";
    }
    else {
        document.getElementById('error-parcel-post-weight').innerHTML = "";
    }

    if (transportType === "Non_Document") {
        var parcelPostContent = document.getElementById("parcelPostContent").value,
            parcelPostLength = document.getElementById("parcelPostLength").value,
            parcelPostWidth = document.getElementById("parcelPostWidth").value,
            parcelPostHeight = document.getElementById("parcelPostHeight").value;

        console.log(parcelPostLength);

        // box content
        if(!validateEmptyElement(parcelPostContent)){
            document.getElementById('error-parcel-post-content').innerHTML = " * Content must not be empty";
        }
        else {
            document.getElementById('error-parcel-post-content').innerHTML = "";
        }

        // box length
        if(!validateEmptyElement(parcelPostLength)){
            document.getElementById('error-parcel-post-length').innerHTML = " * Length must not be empty";
        }
        else {
            document.getElementById('error-parcel-post-length').innerHTML = "";
        }

        // box width
        if(!validateEmptyElement(parcelPostWidth)){
            document.getElementById('error-parcel-post-width').innerHTML = " * Width must not be empty";
        }
        else {
            document.getElementById('error-parcel-post-width').innerHTML = "";
        }

        // box height
        if(!validateEmptyElement(parcelPostHeight)){
            document.getElementById('error-parcel-post-height').innerHTML = " * Height must not be empty";
        }
        else {
            document.getElementById('error-parcel-post-height').innerHTML = "";
        }

        return !(!validateProvince(originProvince) || !validationContinuationAddress(originContinuationAddress) ||
            !validateProvince(destinationProvince) || !validationContinuationAddress(destinationContinuationAddress) ||
            !validateName(recipientFirstName) || !validateName(recipientLastName) ||
            !validatePhone(recipientPhone) || !validateEmptyElement(transportType) ||
            !validateEmptyElement(parcelPostWeight) || !validateEmptyElement(parcelPostContent) ||
            !validateEmptyElement(parcelPostLength) || !validateEmptyElement(parcelPostWidth) ||
            !validateEmptyElement(parcelPostHeight));
    }
    else {
        return !(!validateProvince(originProvince) || !validationContinuationAddress(originContinuationAddress) ||
            !validateProvince(destinationProvince) || !validationContinuationAddress(destinationContinuationAddress) ||
            !validateName(recipientFirstName) || !validateName(recipientLastName) ||
            !validatePhone(recipientPhone) || !validateEmptyElement(transportType) ||
            !validateEmptyElement(parcelPostWeight));
    }
}

function validateName(name) {
    var nameRGEX = /^([a-z]|[A-Z])+$/;
    return nameRGEX.test(name);

}

function validatePhone(phone) {
    var phoneRGEX = /^09\d{9}$/;
    return phoneRGEX.test(phone);

}

function validateProvince(province) {
    return province.length > 0;

}

function validationContinuationAddress(continuationAddress) {
    return JSON.stringify(continuationAddress).length - 2 > 0;
}

function validateEmptyElement(element) {
    return JSON.stringify(element).length - 2 > 0;
}

var provincesAndCities = {};
provincesAndCities['alborz'] = ['Karaj', 'Asara', 'Taleghan'];
provincesAndCities['tehran'] = ['Malard', 'Varamin', 'Firouzkouh', 'Parand'];
provincesAndCities['kermanshah'] = ['Kangavar', 'Sahneh', 'Bistoun'];

function changeOriginProvinceCities() {
    var provinceList = document.getElementById("originProvince"),
        cityList = document.getElementById("originCity"),
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

function changeDestinationProvinceCities() {
    var provinceList = document.getElementById("destinationProvince"),
        cityList = document.getElementById("destinationCity"),
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
