package com.raft.feature;

import com.raft.common.NodeConfig;
import com.raft.entity.*;

/**
 * @author NemoWang
 * @date 2020/5/1-16:26
 */
public interface Node<T> extends LifeCycle{
    /**
     * 设置配置文件.
     *
     * @param config
     */
    void setConfig(NodeConfig config);

    /**
     * 处理请求投票 RPC.
     *
     * @param param
     * @return
     */
    RvoteResult handlerRequestVote(RvoteParam param);

    /**
     * 处理附加日志请求.
     *
     * @param param
     * @return
     */
    AentryResult handlerAppendEntries(AentryParam param);

    /**
     * 处理客户端请求.
     *
     * @param request
     * @return
     */
    ClientKVAck handlerClientRequest(ClientKVReq request);

    /**
     * 转发给 leader 节点,即重定向
     * @param request
     * @return
     */
    ClientKVAck redirect(ClientKVReq request);


}
