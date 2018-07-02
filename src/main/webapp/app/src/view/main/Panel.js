Ext.define('AIMS.view.main.Panel', {
    extend: 'Ext.Panel',
    xtype: 'mainPanel',

    requires: [
        'AIMS.view.navigation.NavigationController',
        'AIMS.view.navigation.List'
    ],

    controller: 'main',
    layout: 'border',

    items: [{
        height: 100,
        region: 'north'
    },{
        width: 200,
        region: 'west',
        xtype: 'navigationList',
        collapsible: true,
        border: true
    },{
        region: 'center',
        layout: 'card',
        items: [
            { xtype: 'aimsDashboard' },
            { xtype: 'userList' }
        ]
    }]
});
