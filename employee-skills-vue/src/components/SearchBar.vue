<template>
    <form v-on:submit.prevent="handleIdFilter">
    <input type="text" placeholder="enter employee ID" v-model='searchEmployeeID'><button>Search this ID</button>
    </form>
    </template>


<script>
    export default {
    name: 'search-bar',
    data() {
        return {
            searchEmployeeID: '',
        };
    },
    methods: {
        handleIdFilter(){
            this.$emit('employeeIdFilter', this.searchEmployeeID);
        }
    }
}
</script>

<style scoped>
form {
   width: 100%;
 margin-left: auto;
 margin-right: auto;
 display: inline-block;
}

form * {
    padding: 0.5em;
    margin: 1em;
}

form input {
    flex: 2;
    font-size: 1em;
}

form button {
    width: 20%;
}

</style>   
