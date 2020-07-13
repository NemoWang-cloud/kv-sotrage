package com.raft.entity;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.org.apache.regexp.internal.RE;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author NemoWang
 * @date 2020/5/7-22:11
 */
@Getter
@Setter
@ToString

public class ClientKVReq implements Serializable {

    public static int PUT = 0;

    public static int GET = 1;

    int type;

    String key;

    String value;

    private ClientKVReq(Builder builder){
        setType(builder.type);
        setKey(builder.key);
        setValue(builder.value);
    }

    public static Builder newBuilder(){
        return new Builder();
    }

    public static final class Builder{

        private int type;
        private String key;
        private String value;

        private Builder(){
        }

        public Builder type(int val){
            type=val;
            return this;
        }
        public Builder value(String val) {
            value = val;
            return this;
        }
        public ClientKVReq build(){
            return new ClientKVReq(this);
        }
    }
    public enum Type{
        PUT(0),GET(1);
        int code;
        Type(int code) {
            this.code=code;
        }
        public static Type value(int code) {
            for (Type type : values()) {
                if (type.code == code) return type;
            }
            return null;
        }
    }

}
