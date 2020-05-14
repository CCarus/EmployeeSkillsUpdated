<template>
<div id='main'>

  <h2>Selected Employee:

 {{employee.firstName + ""}} {{employee.lastName}}<br> </h2>
        
    <div class='Skill-info' v-for='skill in skills' :key='skill.skillID'>

    <p> SkillID: {{skill.skillID}} </p> <br>
    <p> FieldID: {{skill.fieldID}} </p>
    <ul class = 'field-info'>
    <li> Skill: {{skill.field.name}} </li>
    <li> Type: {{skill.field.type}} </li>
    </ul>
    <p> Experience: {{skill.experience}} months </p>  <br>
     <p> Summary: {{skill.summary}}</p>
      
  
    </div>

</div>
  
</template>

<script>
export default {
    data() { 
        
        return {
           employee: {},
            skills: {},
            field: {}
              
    }
    },

   created() {
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