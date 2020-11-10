package io.github.manuelernesto.algafoodapi.domain.exception;

public class EntityInUseException extends RuntimeException{

    public EntityInUseException(String message) {
        super(message);
    }
}
