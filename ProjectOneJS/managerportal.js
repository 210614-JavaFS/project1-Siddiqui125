const URL = 'http://localhost:8080/ProjectOne/';

let tickets =document.getElementById("getTickets");
tickets.onclick=showTickets;

async function showTickets(){

    try {

        let response = await fetch(URL+'list');

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
        
        let td = document.createElement("td");
        
        var a = document.createElement('a');
       
        a.setAttribute('href',URL+"approve?approveId="+info.reimb_id);
        a.innerText = "Approve";
       
        var a1 = document.createElement('a');
        a1.setAttribute('href',URL+"deny?denyId="+info.reimb_id);
        a1.innerText='Deny'


        var h5 = document.createElement('h5');
        h5.innerText = " ";

        td.appendChild(a);
        td.appendChild(h5);
        td.appendChild(a1);
        row.appendChild(td);

        for(let cell in info){
            
            let td = document.createElement("td");
            td.innerText=info[cell];
            row.appendChild(td);
            
        }
        
        tbody.appendChild(row);
    }

}
function logout(){

    var a1 = document.createElement('a');
    a1.setAttribute('href',URL+"logout");
    a1.innerText='logout';

}