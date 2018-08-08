function updateEmplTable(jsonData) {
    var listOfEmpl = jsonToEmlpList(jsonData);
    var tableStructure = '<table id="emplTable"><thead><tr><th>Name</th><th>Hiring date</th>' +
        '<th>Manager</th><th>eMail</th><th>Salary</th><th>Level</th><th>Options</th></tr></thead><tbody>';
    listOfEmpl.forEach(function (item, i) {
        tableStructure += '<tr>';
        tableStructure += '<td><a href="employee/' + item.employeeId + '">' + item.name + " " + item.surname + '</a></td>' +
            '<td>' + new Date(item.hiringDate).toLocaleDateString() + '</td><td>';
        if (item.manager) {
            tableStructure += item.manager.surname + ' ' + item.manager.name;
        }

        tableStructure += '</td><td>' + item.email + '</td><td>' + item.salary + '</td><td>';
        if (item.managementLevel_id) {
            tableStructure += item.managementLevel_id.lvlName;
        }
        tableStructure += '</td><td>';
        if (!item.managementLevel_id || (item.managementLevel_id && item.managementLevel_id.lvl < 3)) {
            tableStructure += '<button class="editEmpl" value=' + item.employeeId + '>edit</button><button class="deleteEmpl" value=' + item.employeeId + '>delete</button>';
        }
        tableStructure += '</td></tr>';
    });
    tableStructure += '</tbody></table>';
    $('#divForTableWithEmpl').html(tableStructure);
    $('#emplTable').DataTable();

    deleteListerner();
    editListerner();
}

function updateManagerOnForm(level, jsonData) {
    var listOfEmpl = jsonToEmlpList(jsonData);
    var options = "<option></option>";
    listOfEmpl.forEach(function (item, i) {
        if (item.managementLevel_id && item.managementLevel_id.lvl > level) {
            options += '<option value="' + item.employeeId + '">' + item.name + " " + item.surname + '</option>';
        }
    });
    $("#manager").html(options);
}

function deleteListerner() {
    $(".deleteEmpl").click(function () {
        var url = "employee/" + this.value;
        $.ajax({
            url: url,
            type: 'delete',
            success: function () {
                updateEmployeesRequest();
            }
        });
    });
}

function editListerner() {
    $(".editEmpl").click(function () {
        var url = "employee/" + this.value;
        $.ajax({
            url: url,
            type: 'get',
            success: function (data) {
                prepareFormForEditing(data);
            }
        });
    });
}

function prepareFormForEditing(jsonData) {
    var o = $.parseJSON(jsonData);
    $.each(o, function(key, value){
        if (key === "manager") {
            $('option [value =' + value.employeeId + ']').select(true);
        } else if (key === "managementLevel_id") {
            $('option [value =' + value.lvlId + ']').select(true);
        } else {
            $('form [name=' + key + ']').val(value);
        }
    });

    $('#bday').prop('disabled', true);
    $('#lname').prop('disabled', true);
    $('#fname').prop('disabled', true);
    $('#hiringDate').prop('disabled', true);

}

function guid() {
    function s4() {
        return Math.floor((1 + Math.random()) * 0x10000)
            .toString(16)
            .substring(1);
    }

    return s4() + s4() + '-' + s4() + '-' + s4() + '-' + s4() + '-' + s4() + s4() + s4();
}