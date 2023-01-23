package com.esther.facebookclone.model;

import com.esther.facebookclone.Enum.DatabaseConnection;
import com.esther.facebookclone.InterfaceDaoService.UserDaoService;
import com.esther.facebookclone.serviceDaoImpli.UserImplement;

public class Main {
    private static UserDaoService userDao = new UserImplement();

    public static void main(String[] args) {

        System.out.println("Connection validity test: " + DatabaseConnection.INSTANCE.connectionTest());

    }
}
