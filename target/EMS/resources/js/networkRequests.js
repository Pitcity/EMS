function updateEmployeesRequest() {
    $.ajax({
        type: 'get',
        contentType: 'application/json',
        url: 'employee',
        dataType: 'json',
        success: function (data) {
            empList = jsonToEmlpList(data);
            updateEmplTable(data);
            updateManagerOnForm($('select option:selected')[0].value, data)
        },
        error: function (xhr) {

        }
    });
}

function sendDataToCreateEmpl(data) {
    $.ajax({
        url: 'employee',
        type: 'post',
        data: data,
        success: function () {
            updateEmployeesRequest();
        }
    });
}

function getPossibleManagers(lvl) {
    alert(JSON.stringify(lvl));
    $.ajax({
        type: 'get',
        contentType: 'application/json',
        url: 'getManagers/' + lvl,
        dataType: 'json',
        success: function (data) {
            empList = jsonToEmlpList(data);
            updateManagerOnForm(lvl, data)
        },
        error: function (xhr) {

        }
    });
}