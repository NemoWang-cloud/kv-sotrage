package com.raft.entity;

import lombok.Getter;
import lombok.Setter;

import java.awt.image.RasterOp;
import java.io.Serializable;

/**
 * @author NemoWang
 * @date 2020/5/1-16:30
 * 请求投票返回值
 */
@Getter
@Setter
public class RvoteResult implements Serializable {
    /** 当前任期号，以便于候选人去更新自己的任期 */
    long term;

    /** 候选人赢得了此张选票时为真 */
    boolean voteGranted;

    private RvoteResult(Builder builder) {
        setTerm(builder.term);
        setVoteGranted(builder.voteGranted);
    }

    private RvoteResult(boolean voteGranted){
        this.voteGranted=voteGranted;
    }
    public static RvoteResult fail(){
        return new RvoteResult(false);
    }
    public static RvoteResult ok(){
        return new RvoteResult(true);
    }

    public Builder newBuilder(){
        return new Builder();
    }

    public final class Builder{
        private long term;
        private boolean voteGranted;

        private Builder() {
        }

        public Builder term(long term) {
            this.term = term;
            return this;
        }

        public Builder voteGranted(boolean voteGranted) {
            this.voteGranted = voteGranted;
            return this;
        }

        public RvoteResult build() {
            return new RvoteResult(this);
        }
    }

}
