package com.raft.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author NemoWang
 * @date 2020/5/7-22:31
 */
@Getter
@Setter
@ToString
public class ClientKVAck implements Serializable {
    Object result;
    public ClientKVAck(Object result){
        this.result=result;
    }
    private ClientKVAck(Builder builder){
        setResult(builder.result);
    }
    public static Builder newBuilder(){
        return new Builder();
    }
    public static ClientKVAck ok(){
        return new ClientKVAck("ok");
    }
    public static ClientKVAck fail(){
        return new ClientKVAck("fail");
    }


    public static final class Builder{

        private Object result;

        private Builder(){
        }

        public Builder result(Object result){
            this.result=result;
            return this;
        }
        public ClientKVAck build(){
            return new ClientKVAck(this);
        }

    }


}
