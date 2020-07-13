package com.raft.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author NemoWang
 * @date 2020/5/1-16:39
 * 基本参数
 */
@Getter
@Setter
@ToString
public class BaseParam {
    /** 候选人的任期号  */
    public long term;

    /** 被请求者 ID(ip:selfPort) */
    public String serverId;

}
