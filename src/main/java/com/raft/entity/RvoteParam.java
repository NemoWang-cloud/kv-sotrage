package com.raft.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author NemoWang
 * @date 2020/5/1-16:30
 * 请求投票RPC参数
 */

@Getter
@Setter
public class RvoteParam extends BaseParam {
    /** 请求选票的候选人的 Id(ip:selfPort) */
    String candidateId;

    /** 候选人的最后日志条目的索引值 */
    long lastLogIndex;

    /** 候选人最后日志条目的任期号  */
    long lastLogTerm;

    private RvoteParam(Builder builder){
        setTerm(builder.term);
        setServerId(builder.serverId);
        setCandidateId(builder.candidateId);
        setLastLogIndex(builder.lastLogIndex);
        setLastLogTerm(builder.lastLogTerm);
    };

    public static Builder newBuilder(){
        return new Builder();
    }

    @Override
    public String toString() {
        return "RvoteParam{" +
                "candidateId='" + candidateId + '\'' +
                ", lastLogIndex=" + lastLogIndex +
                ", lastLogTerm=" + lastLogTerm +
                ", term=" + term +
                ", serverId='" + serverId + '\'' +
                '}';
    }

    public static final class Builder{
        private long term;
        private String serverId;
        private String candidateId;
        private long lastLogIndex;
        private long lastLogTerm;

        private Builder(){
        }

        public Builder term(long val) {
            term = val;
            return this;
        }

        public Builder serverId(String val) {
            serverId = val;
            return this;
        }

        public Builder candidateId(String val) {
            candidateId = val;
            return this;
        }

        public Builder lastLogIndex(long val) {
            lastLogIndex = val;
            return this;
        }

        public Builder lastLogTerm(long val) {
            lastLogTerm = val;
            return this;
        }

        public RvoteParam build(){
            return new  RvoteParam(this);
        }

    }

}
