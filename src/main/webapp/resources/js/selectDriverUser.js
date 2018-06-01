$(document).ready(function(){
    loadDrivers();
});

function loadDrivers() {
    $.get("/drivers", function (drivers) {

        var driverSelect = $('#drivers');

        for (driverIndex in drivers) {
            driverSelect
                .append(
                    $("<option />")
                        .val(drivers[driverIndex].idDriver)
                        .text(
                            drivers[driverIndex].personalNumber + " - " +
                            drivers[driverIndex].name + " - " +
                            drivers[driverIndex].secondName
                        )
                )
        }
    })
}

function createOrder() {
    var selectedDrivers = $('#drivers').val();

    var order = {
        driver: selectedDrivers,
    };

    $.ajax ({
        url: "/selectProfile",
        type: "POST",
        data: JSON.stringify(order),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function (order) {
            window.location.href = "/welcome";
        }
    });

}