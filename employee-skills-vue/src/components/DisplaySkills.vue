<template>
<div id='main'>

  Selected Employee:
 {{employee.firstName + ""}} {{employee.lastName}}<br>
        
    <div class='Skill-info' v-for='skill in skills' :key='skill.skillID'>

      SkillID: {{skill.skillID}} <br>
      FieldID: {{skill.fieldID}} <br>
      Experience: {{skill.experience}} <br>
      Summary: {{skill.summary}}
      
  
    </div>

</div>
  
</template>

<script>
export default {
    data() { 
        
        return {
           employee: {},
            skills: []
              
    }
    },

  methods: {

    getSkills() {
    fetch( 'http://localhost:8080/EmployeeSkills/api/skills/${empId}​')
    .then (
      (response) => {return response.json();}
    )
    .then ( 
        (skill) => {this.skills = skill;}
    )
    .catch(
        (err) => {console.error(err + 'ERROR!'); }
    )
  }
},

getEmployee(employeeID) {

            fetch(`http://localhost:8080/EmployeeSkills/api/employees/${employeeID}`)
            .then (
                (response) => {return response.json();}
            )
            .then ( 
                (employeeData) => {this.employee = employeeData;}
            )
            .catch(
                (err) => {console.error(err + ' No employee found'); }
            )
        },
 created() {
        console.log(this.$route.params.employeeID);
        this.getEmployee(this.$route.params.employeeID);
        this.getSkills(this.$route.params.employeeID);
    }
}

</script>
<style>

  .Skill-info{
    padding-top:20px;
    margin: 20px;
     margin-left: auto;
  margin-right: auto;
    width: 50%;
    background-color: white;
  }

</style>