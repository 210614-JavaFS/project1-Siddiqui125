const URL = 'http://localhost:8080/ProjectOne/';
let tickets =document.getElementById("getTickets");
tickets.onclick=showTickets;

async function showTickets(){

    try {

        let response = await fetch(URL+'employeeportal');

    if(response.status===200){
        let data = await response.json();
         displayAllTickets(data);
    }else{
         console.log("Error");
    }
        
    } catch (error) {
        console.log(error);
    }
}

function displayAllTickets(data){
    let tbody = document.getElementById("tableBody");
    
    tbody.innerHTML = ""

    for(let info of data ){
        let row =document.createElement("tr");

        for(let cell in info){
            
            let td = document.createElement("td");
        td.innerText=info[cell];
        row.appendChild(td);
            
        }
        tbody.appendChild(row);
    }
}
function getUserinput(){
    let remib_amount=document.getElementById("amount");
    let remib_description=document.getElementById("description");

    let userInput={
        amount:remib_amount,
        description:remib_description
    }
    return userInput;
}
async function addrequest(){
    let input=getUserinput();

    let response=await fetch(URL+"employeeprotal",{
        method:'POST',
        body:JSON.stringify(input)
    });
    if(response.status===200){
        console.log("Request added Successfully")
    }else{
        console.log("Something went wrong trying to add new Request")
    }
}