package com.raft.entity;

import lombok.Getter;
import lombok.Setter;
import sun.rmi.runtime.Log;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

/**
 * @author NemoWang
 * @date 2020/5/1-17:40
 * 日志条目
 *
 */
@Getter
@Setter
public class LogEntry implements Serializable,Comparable {

    private Long index;

    private long term;

    private Command command;



    private LogEntry(Builder builder) {
        setIndex(builder.index);
        setTerm(builder.term);
        setCommand(builder.command);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "{" +
                "index=" + index +
                ", term=" + term +
                ", command=" + command +
                '}';
    }


    public static final class Builder {

        private Long index;
        private long term;
        private Command command;

        private Builder() {
        }

        public Builder index(Long val) {
            index = val;
            return this;
        }

        public Builder term(long val) {
            term = val;
            return this;
        }

        public Builder command(Command val) {
            command = val;
            return this;
        }

        public LogEntry build() {
            return new LogEntry(this);
        }
    }

    @Override
    public int compareTo(Object o){
        if(o==null) return -1;

        if(this.getIndex()>((LogEntry)o).getIndex()) return 1;
        return -1;
    }
    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null||getClass()!=o.getClass()) return false;
        LogEntry logEntry=(LogEntry)o;
        return term==logEntry.term&&
                Objects.equals(index,logEntry.index)&&
                Objects.equals(command,logEntry.command);
    }
    @Override
    public int hashCode(){
        return Objects.hash(index,term,command);
    }

}
