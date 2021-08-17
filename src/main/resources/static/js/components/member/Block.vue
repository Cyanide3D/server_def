<template>
    <v-container grid-list-md text-xs-center>
        <v-layout row wrap>
            <v-flex xs2>
                <v-text-field
                        v-model="memberData.nickname"
                        label="Никнейм"
                >

                </v-text-field>
            </v-flex>
            <v-flex xs2>
                <v-text-field
                        v-model="memberData.clanPoints"
                        label="Очки клана"
                >

                </v-text-field>
            </v-flex>
            <v-flex xs2>
                <v-text-field
                        v-model="memberData.role"
                        label="Роль"
                >

                </v-text-field>
            </v-flex>
            <v-flex>

            </v-flex>
            <v-flex xs1>
                <v-btn
                        color="success"
                        text
                        @click="onSaveClick"
                >
                    Add
                </v-btn>
            </v-flex>
            <v-flex xs1>
                <v-btn
                        color="primary"
                        text
                        @click="onClearClick"
                >
                    Clear
                </v-btn>
            </v-flex>
        </v-layout>

        <v-dialog
                v-model="error"
                width="500"
        >
            <v-card>
                <v-card-title class="headline grey lighten-2">
                    Ошибка
                </v-card-title>

                <v-card-text>
                    Необходимо заполнить пустые поля!
                </v-card-text>

                <v-divider></v-divider>

                <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn
                            color="primary"
                            text
                            @click="error = false"
                    >
                        Close
                    </v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>
    </v-container>
</template>

<script>
    export default {
        data() {
            return {
                memberData : {
                    nickname: '',
                    role: '',
                    clanPoints: 0
                },
                error: false
            }
        },
        methods: {
            onSaveClick: function () {
                if (this.memberData.role === '' || this.memberData.nickname === '' || this.memberData.clanPoints === 0) {
                    this.error = true
                } else {
                    this.$emit('save', this.memberData)
                    this.onClearClick()
                }
            },
            onClearClick: function () {
                this.memberData.clanPoints = 0
                this.memberData.role = ''
                this.memberData.nickname = ''
            },
        }
    }
</script>

<style scoped>

</style>