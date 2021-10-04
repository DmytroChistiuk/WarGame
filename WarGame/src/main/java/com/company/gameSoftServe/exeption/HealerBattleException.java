package com.company.gameSoftServe.exeption;

public class HealerBattleException extends Exception {

    public HealerBattleException(String message) {
        super(message);
    }

    public HealerBattleException(String message, Throwable cause) {
        super(message, cause);
    }
}
