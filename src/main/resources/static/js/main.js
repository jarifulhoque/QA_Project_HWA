"use strict";

// Selectors

// Divs
let resultsDiv = document.querySelector("#results-div");

// Inputs
let clubInput = document.querySelector("#clubInput");
let stadiumCapacityInput = document.querySelector("#stadiumCapacityInput");
let clubValueInput = document.querySelector("#clubValueInput");
let pointsInput = document.querySelector("#pointsInput");

// Buttons
let createBtn = document.querySelector("#createBtn");
let updateBtn = document.querySelector("#updateBtn");
let deleteBtn = document.querySelector("#deleteBtn");
let idInput = document.querySelector("#idInput");

// Functions

let printResults = (result) => {
    let entryDiv = document.createElement("div");
    entryDiv.setAttribute("class", "entry-div");
    entryDiv.textContent = `${result.id} | ${result.club}| ${result.stadiumCapacity} | ${result.clubValue} | ${result.points}`;

    resultsDiv.appendChild(entryDiv);
}

let getAll = () => {
    axios.get("http://localhost:8080/league/getAll")
    .then(res => {
        resultsDiv.innerHTML = "";

        let results = res.data;

        for (let result of results) {
            printResults(result);
        }
    }).catch(err => {console.log(err);});
}

let create = () => {

    let obj = {
        "club": clubInput.value,
        "stadiumCapacity": stadiumCapacityInput.value,
        "clubValue": clubValueInput.value,
        "points": pointsInput.value
    }

    axios.post("http://localhost:8080/league/create", obj)
    .then(res => {
        getAll();
    }).catch(err => {console.log(err);});
}

let update = () => {

    let obj = {
        "club": clubInput.value,
        "stadiumCapacity": stadiumCapacityInput.value,
        "clubValue": clubValueInput.value,
        "points": pointsInput.value
    }
    
    axios.put(`http://localhost:8080/league/update/${idInput.value}`, obj)
        .then((resp) => {
            getAll();
        }).catch((err) => {console.error(err);})
}

let del = (id) => {

    if (!validateDelete()) {
        return;
    }

    axios.delete(`http://localhost:8080/league/delete/${idInput.value}`)
    .then(res => {
        getAll();

    }).catch(err => {console.log(err)}); 
}

let validateDelete = () => {
    if (idInput.value === "") {
        alert("ID is required for this operation");
        return false;
    } else {
        return true;
    }
}

// Listeners
createBtn.addEventListener("click", create);
updateBtn.addEventListener("click", update);
deleteBtn.addEventListener("click", del);