function Employee(employeeId, surname, name, birthday, email, managementLevel_id, salary, address, manager_id, hiringDate) {
    this.employeeId = employeeId;
    this.surname = surname;
    this.name = name;
    this.manager_id = manager_id;
    this.birthday = birthday;
    this.hiringDate = hiringDate;
    this.email = email;
    this.managementLevel_id = managementLevel_id;
    this.salary = salary;
    this.address = address;
}

function ManagementLevel(lvlId, lvl, lvlName) {
    this.lvlId = lvlId;
    this.lvl = lvl;
    this.lvlName = lvlName;
}

function jsonToEmlpList(jsonData) {
    var emplList = [];
    jsonData.forEach(function (item, i) {
        emplList[i] = new Employee(
            item.employeeId,
            item.surname,
            item.name,
            item.birthday,
            item.email,
            item.managementLevel_id,
            item.address,
            item.manager_id,
            item.salary,
            item.hiringDate
        );
    });
    return emplList;
}

function jsonToManagementLvlList(jsonData) {
    var lvlList = [];
    jsonData.forEach(function (item, i) {
        lvlList[i] = new ManagementLevel(
            item.lvlId,
            item.lvl,
            item.lvlName
        );
    });
    return lvlList;
}