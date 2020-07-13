package com.raft.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author NemoWang
 * @date 2020/5/7-21:38
 */
@Getter
@Setter
@ToString
public class NodeConfig {
    //节点自身的端口
    public int selfPort;

    //所有节点地址
    public List<String> peerAddrs;
}
