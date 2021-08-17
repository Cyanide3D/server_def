import Vue from 'vue'

const customActions = {
    pch: {method: 'PATCH', url: '/member{/id}'}
}

const members = Vue.resource('/member{/id}', {}, customActions)

export default {
    add: member => members.save({}, member),
    update: member => members.update({id: member.id}, member),
    remove: id => members.remove({id}),
    get: () => members.get(),
    patch: member => members.pch({id: member.id}, member)
}
