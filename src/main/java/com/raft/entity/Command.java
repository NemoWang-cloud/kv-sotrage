package com.raft.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author NemoWang
 * @date 2020/5/1-17:48
 */
@Getter
@Setter
public class Command implements Serializable {
    String key;

    String value;

    private Command(Builder builder){
        setKey(builder.key);
        setValue(builder.value);
    }
    public static Builder newBuilder(){
        return new Builder();
    }

    public static final class Builder{
        private String key;

        private String value;

        private Builder(){};

        public Builder key(String key){
            this.key=key;
            return this;
        }
        public Builder value(String value){
            this.value=value;
            return this;
        }
        public Command build(){
            return new Command(this);
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Command command = (Command) o;
        return Objects.equals(key, command.key) &&
                Objects.equals(value, command.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
