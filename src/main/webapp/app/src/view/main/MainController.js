Ext.define('AIMS.view.main.MainController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.main',

    listen: {
        global: {
            navigationevent: 'onNavigationEvent'
        },

        component: {
            // 'app-main navigationList': {
            // selectionchange: 'onNavigationSelectionChange'
            // }
        }
    },

    onNavigationEvent: function(screenItemId) {
        console.log('Navigation!');
        /*
                this.getView()
                    .lookupReference('content-card')
                    .getLayout()
                    .setActiveItem(screenItemId);
        */
    },

    onItemSelected: function (sender, record) {
        Ext.Msg.confirm('Confirm', 'Are you sure?', 'onConfirm', this);
    },

    onConfirm: function (choice) {
        if (choice === 'yes') {
            //
        }
    }
});
