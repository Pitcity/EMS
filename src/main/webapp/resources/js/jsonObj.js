function Employee(employeeId, surname, name, birthday, email, managementLevel_id, manager, address, salary, hiringDate) {
    this.employeeId = employeeId;
    this.surname = surname;
    this.name = name;
    this.manager = manager;
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
            item.manager,
            item.address,
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