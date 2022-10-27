
const restApi = `http://localhost:8082/emp`;

const getEmpById = (empId) => {
    console.log(`getEmpById`);
    fetch(`${restApi}/get-emp-by-id/${empId}`, { method: 'GET' })
        .then(data => {
            return data.json();
        })
        .then((response) => {
            document.getElementById("empData").innerHTML = JSON.stringify(response);
            document.getElementById("eid").value = '';
            console.log(JSON.stringify(response));
            $("#exampleModal").modal();
        })
        .catch((error) => {
            document.getElementById("eid").value = '';
            document.getElementById("empData").innerHTML = 'Something is wrong!';
            console.log(error);
        });
}

const addEmp = () => {
    console.log(`addEmp`);
    fetch(`${restApi}/add-emp`, {
        body: JSON.stringify({
            firstName: document.getElementById("firstName").value,
            salary: document.getElementById("salary").value,
            department: {
                departmentId: document.getElementById("departmentId").value
            }
        }),
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(data => data.json())
        .then((json) => {
            response = JSON.stringify(json);
            console.log(response);
            document.getElementById("empAdded").innerHTML = response;
            document.getElementById("firstName").value = '';
            document.getElementById("salary").value = '';
            document.getElementById("departmentId").value = '';
        })
        .catch(() => {
            document.getElementById("empAdded").innerHTML = 'Something is wrong!';
            document.getElementById("firstName").value = '';
            document.getElementById("salary").value = '';
            document.getElementById("departmentId").value = '';
        });
}

const updateEmp = () => {
    console.log(`updateEmp`);
    fetch(`${restApi}/update-emp`, {
        body: JSON.stringify({
            employeeId: document.getElementById("updateEmployeeId").value,
            firstName: document.getElementById("updateFirstName").value,
            salary: document.getElementById("updateSalary").value,
            department: {
                departmentId: document.getElementById("updateDepartmentId").value
            }
        }),
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(data => data.json())
        .then((json) => {
            response = JSON.stringify(json);
            console.log(response);
            document.getElementById("empUpdated").innerHTML = response;
            document.getElementById("updateEmployeeId").value = '';
            document.getElementById("updateFirstName").value = '';
            document.getElementById("updateSalary").value = '';
            document.getElementById("updateDepartmentId").value = '';
        })
        .catch((error) => {
            console.log(error);
            document.getElementById("empAdded").innerHTML = 'Something is wrong!';
            document.getElementById("updateEmployeeId").value = '';
            document.getElementById("updateFirstName").value = '';
            document.getElementById("updateSalary").value = '';
            document.getElementById("updateDepartmentId").value = '';

        });
}

const getAllEmps = () => {
    console.log(`getAllEmps`);
    fetch(`${restApi}/get-all-emps`)
        .then(data => data.json())
        .then((json) => {
            console.log(json);
            response = JSON.stringify(json);
            console.log(response);
            document.getElementById("empList").innerHTML = response;
        })
        .catch(() => {
            document.getElementById("empList").innerHTML = 'Something is wrong!';
        });
}