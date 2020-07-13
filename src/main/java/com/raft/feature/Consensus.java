package com.raft.feature;

import com.raft.entity.AentryParam;
import com.raft.entity.AentryResult;
import com.raft.entity.RvoteParam;
import com.raft.entity.RvoteResult;

/**
 * @author NemoWang
 * @date 2020/5/1-16:25
 */
public interface Consensus {
    RvoteResult requestVote(RvoteParam param); //请求投票

    AentryResult appendEntries(AentryParam param); //附加日志(多个日志,为了提高效率) RPC


}
