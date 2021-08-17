<template>
    <div>
        <input @keydown.enter="change" v-model="val" v-show="edit" type="text">
        <p @click="edit=true" v-show="!edit" v-text="value"></p>
    </div>
</template>

<script>
    export default {
        props: ['value', 'type'],
        data() {
            return {
                val: this.value,
                edit: false
            }
        },
        methods: {
            change: function () {
                this.edit = false
                this.$emit('input', this.val, this.type)
            }
        }
    }
</script>

<style scoped>

</style>