package controller;

import service.DataHolder;

public class SharedController {
    private DataHolder dataHolder;

    private static SharedController instance;

    private SharedController() {
        this.dataHolder = new DataHolder();
    }

    public static SharedController getInstance() {
        if (instance == null) {
            instance = new SharedController();
        }
        return instance;
    }

    public DataHolder getDataHolder() {
        return dataHolder;
    }
}
