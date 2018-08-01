$(document).ready(function () {
    $.ajax({
        type: 'post',
        contentType: 'application/json',
        url: 'getEmployeeList',
        dataType: 'json',
        success: function (data) {
            empList = jsonToEmlpList(data);
            updateEmplTable(data);
        },
        error: function (xhr) {

        }
    });
});