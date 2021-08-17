<template>
    <v-container>
        <v-text-field
                v-model="nickname"
                label="Search"
                class="mx-4"
        ></v-text-field>
        <v-data-table :search="nickname" :headers="headers" :items="members" class="elevation-1">
            <template v-slot:items="props">
                <td @click="onRowClick(props.item)">{{ props.item.id }}</td>
                <td @click="onRowClick(props.item)">{{ props.item.nickname }}</td>
                <td @click="onRowClick(props.item)">{{ props.item.currentClanPoints }}</td>
                <td @click="onRowClick(props.item)">{{ props.item.currentWeekClanPoints }}</td>
                <td @click="onRowClick(props.item)">{{ props.item.lastWeekClanPoints }}</td>
                <td @click="onRowClick(props.item)">{{ props.item.role }}</td>
            </template>
        </v-data-table>

        <block @save="onAddNewMember"></block>

        <v-dialog
                v-model="editWindow"
                width="500"
        >
<!--            <template v-slot:activator="{ on, attrs }">-->
<!--                <v-btn-->
<!--                        color="red lighten-2"-->
<!--                        dark-->
<!--                        v-bind="attrs"-->
<!--                        v-on="on"-->
<!--                >-->
<!--                    Click Me-->
<!--                </v-btn>-->
<!--            </template>-->

            <v-card>
                <v-card-title class="headline grey lighten-2">
                    Информация о пользователе
                </v-card-title>

                <v-card-text>
                    <p v-if="!newWeekEdit && !memberEdit" v-text="'Никнейм: ' + memberToEdit.nickname"></p>
                    <p v-if="!newWeekEdit && !memberEdit" v-text="'Роль: ' + memberToEdit.role"></p>
                    <p v-if="!newWeekEdit && !memberEdit" v-text="'Текущие очки клана: ' + memberToEdit.currentClanPoints"></p>
                    <p v-if="!newWeekEdit && !memberEdit" v-text="'Очки клана пр. недели: ' + memberToEdit.lastWeekClanPoints"></p>
                    <p v-if="!newWeekEdit && !memberEdit" v-text="'Приписка: ' + memberToEdit.note"></p>
                    <v-text-field
                            v-if="memberEdit"
                            label="Никнейм"
                            v-model="memberToEdit.nickname"
                            hide-details="auto"
                    ></v-text-field>
                    <v-text-field
                            v-if="memberEdit"
                            label="Роль"
                            v-model="memberToEdit.role"
                            hide-details="auto"
                    ></v-text-field>
                    <v-text-field
                            v-if="memberEdit"
                            label="Очки клана"
                            v-model="memberToEdit.currentClanPoints"
                            hide-details="auto"
                    ></v-text-field>
                    <v-text-field
                            v-if="memberEdit"
                            label="Очки клана пр. недели"
                            v-model="memberToEdit.lastWeekClanPoints"
                            hide-details="auto"
                    ></v-text-field>
                    <v-text-field
                            v-if="memberEdit"
                            label="Приписка"
                            v-model="memberToEdit.note"
                            hide-details="auto"
                    ></v-text-field>
                    <v-text-field
                            v-if="newWeekEdit"
                            label="Текущие очки клана"
                            v-model="memberToEdit.currentClanPoints"
                            hide-details="auto"
                    ></v-text-field>
                </v-card-text>

                <v-divider></v-divider>

                <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn
                            v-if="memberEdit"
                            color="success"
                            text
                            @click="onSaveMember"
                    >
                        Save
                    </v-btn>
                    <v-btn
                            v-if="newWeekEdit"
                            color="success"
                            text
                            @click="onWeekUpdateMember"
                    >
                        Save
                    </v-btn>
                    <v-btn
                            v-if="!newWeekEdit && !memberEdit"
                            color="primary"
                            text
                            @click="newWeekEdit = true"
                    >
                        Week Up
                    </v-btn>
                    <v-btn
                            v-if="!newWeekEdit && !memberEdit"
                            color="primary"
                            text
                            @click="memberEdit = true"
                    >
                        Edit
                    </v-btn>
                    <v-btn
                            v-if="!newWeekEdit && !memberEdit"
                            color="error"
                            text
                            @click="onDeleteUser"
                    >
                        Remove
                    </v-btn>
                    <v-btn
                            color="primary"
                            text
                            @click="editWindow = false"
                    >
                        Close
                    </v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>
    </v-container>
</template>

<script>
    import members from "../../api/members";
    import block from "components/member/Block.vue"

    export default {
        data() {
            return {
                newWeekEdit: false,
                memberEdit: false,
                members: [],
                memberToEdit: {},
                nickname: '',
                editWindow: false,
                headers: [
                    {
                        text: 'ID',
                        align: 'left',
                        sortable: true,
                        value: 'id',
                    },
                    {text: 'Никнейм', value: 'nickname'},
                    {text: 'Текущие очки', value: 'currentClanPoints'},
                    {text: 'Очки за неделю', value: 'currentWeekClanPoints'},
                    {text: 'Очки до последней недели', value: 'lastWeekClanPoints'},
                    {text: 'Роль', value: 'role'},
                ],
            }
        },
        components: {
            block
        },
        created() {
            members.get().then(response => this.members = response.body)
        },
        methods: {
            onRowClick: function (value) {
                this.editWindow = !this.editWindow
                this.memberToEdit = value
                this.newWeekEdit = false
                this.memberEdit = false
            },
            onSaveMember: function () {
                members.update(this.memberToEdit)
                this.memberEdit = false
                // this.$router.go()
            },
            onWeekUpdateMember: function () {
                let index = this.members.findIndex(mem => mem.id === this.memberToEdit.id)
                members.patch(this.memberToEdit).then(response => this.members.splice(index, 1, response.body))
                this.newWeekEdit = false
            },
            onAddNewMember: function (member) {
                members.add(member).then(response => this.members.push(response.body))
            },
            onDeleteUser: function () {
                let index = this.members.findIndex(mem => mem.id === this.memberToEdit.id)
                this.members.splice(index, 1)
                this.editWindow = false
                members.remove(this.memberToEdit.id)
            }
        },
    }
</script>

<style>

</style>