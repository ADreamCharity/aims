Ext.define('AIMS.view.navigation.NavigationController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.navigation',

    listen: {
        component: {
            'navigationList': {
                selectionchange: 'onSelectionChange'
            }
        }
    },

    onSelectionChange: function(row, record) {
        if (record.isLeaf())
            Ext.GlobalEvents.fireEvent('navigationevent', record.get('itemId'), record, row);
    },

    onItemSelected: function (sender, record) {
        console.log('Selected');
        Ext.Msg.confirm('Confirm', 'Are you sure?', 'onConfirm', this);
    },

    onConfirm: function (choice) {
        if (choice === 'yes') {
            //
        }
    }
});
