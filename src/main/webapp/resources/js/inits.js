$(document).ready(function () {

    updateEmployeesRequest();

    $("#employeeForm_form").submit(function (e) {

        $('#bday').prop('disabled', false);
        $('#lname').prop('disabled', false);
        $('#fname').prop('disabled', false);
        $('#hiringDate').prop('disabled', false);

        var data = $('#employeeForm_form').serialize();
        e.preventDefault();
        $("#employeeForm_form")[0].reset();
        $("#employeeId").val(guid());
        sendDataToCreateEmpl(data);
    });

    $("#level").change(function (e) {
        getPossibleManagers($('select option:selected')[0].value);
    })
})
;
