<template>
<div id='main'>
<h1>All Employees </h1>


<SearchBar v-on:employeeIDFilter="handleEmployeeIDFilter"/>

    <div class='employee-info' v-for='employee in allEmployees' :key='employee.employeeID'>
     
        Employee First Name: {{employee.firstName}} <br>
        Employee Last Name: {{employee.lastName}} <br>
        Employee Email: {{employee.companyEmail}} <br>
        Employee Date of Birth: {{employee.birthDate}} <br>
        Employee Hire Date: {{employee.hireDate}} <br>
        Role:  {{employee.role}} <br>

      
    <router-link :to="{name: 'display-detail', params: {employeeID: employee.employeeID}}"> Edit / Delete Employee Data </router-link><br>
    <router-link :to="{name: 'displaySkills', params: {employeeID: employee.employeeID}}"> View Employee Skills </router-link><br><br>
    </div>

</div>
  
</template>

<script>

import SearchBar from '@/components/SearchBar.vue'

export default {
   components: {
     SearchBar
   },
    data() { 
        
        return { allEmployees : [],
        employeeIDFilter: ""}
    },
    computed:{
      
        filteredEmployee(){

            const filteredEmployeeByID = this.allEmployees.filter((employee) => {
                    return employee.employeeID.includes(this.employeeIDFilter);
            });
     

            return filteredEmployeeByID;
        }
    },
    methods: {
        handleEmployeeIDFilter(search){
            this.employeeIDFilter = search;
        }
    },

  created() {
    fetch( 'http://localhost:8080/EmployeeSkills/api/employees')
    .then (
      (response) => {return response.json();}
    )
    .then ( 
        (employee) => {this.allEmployees = employee;}
    )
    .catch(
        (err) => {console.error(err + 'ERROR!'); }
    )
  }
}

</script>
<style>

  .employee-info {
    padding-top:20px;
    margin: 20px;
     margin-left: auto;
  margin-right: auto;
    width: 50%;
    background-color: white;
  }

</style>