Ext.define('AIMS.view.navigation.List', {
    extend: 'Ext.list.Tree',
    xtype: 'navigationList',

    controller: 'navigation',
    expanderOnly: false,
    singleExpand: true,

    store: {
        model: 'AIMS.view.navigation.Model',
        root: {
            expanded: true,
            children: [{
                text: 'Dashboard',
                leaf: true
            },{
                text: 'User Administration',
                children: [{
                    text: 'User Admin',
                    itemId: 'userList',
                    targetType: 'userList',
                    leaf: true
                },{
                    text: 'Client Admin',
                    leaf: true
                },{
                    text: 'Volunteer Admin',
                    leaf: true
                },{
                    text: 'Donor Admin',
                    leaf: true
                },{
                    text: 'Species Admin',
                    leaf: true
                }]
            },{
                text: 'Events',
                children: [{
                    text: 'Event Calendar',
                    leaf: true
                },{
                    text: 'Location Management',
                    leaf: true
                }]
            },{
                text: 'Inventory',
                children: [{
                    text: 'Inventory Information',
                    leaf: true
                },{
                    text: 'Receivables',
                    leaf: true
                },{
                    text: 'Distribution',
                    leaf: true
                }]
            },{
                text: 'Reports',
                leaf: true
            }]
        }
    }
});