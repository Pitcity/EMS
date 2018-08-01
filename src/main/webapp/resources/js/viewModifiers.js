function updateEmplTable(jsonData) {
    var listOfEmpl = jsonToEmlpList(jsonData);
    var tableStructure = '<table id="emplTable"><thead><tr><th>Firstname</th><th>Lastname</th><th>Age</th></tr></thead><tbody>';
    listOfEmpl.forEach(function (item, i) {
        tableStructure += '<tr>';
        tableStructure += '<td>' + item.name + '</td><td>' + item.surname + '</td><td>' + item.birthday + '</td>';
        tableStructure += '</tr>';
    });
    tableStructure += '</tbody></table>';
    alert (tableStructure);
    $('#divForTableWithEmpl').html(tableStructure);
    $('#emplTable').DataTable();
}
    
