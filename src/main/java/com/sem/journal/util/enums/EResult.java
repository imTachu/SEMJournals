package com.sem.journal.util.enums;

public enum EResult {
	SUCCESS_RESULT("Resultado exitoso"),
    ERROR_RESULT("Resultado fallido - ocurrió un error al realizar la acción"),
    INVALID_PARAMS_RESULT("Resultado fallido - parámetros de entrada inválidos");

    private String description;

    private EResult(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
