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
            skills: {}
              
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