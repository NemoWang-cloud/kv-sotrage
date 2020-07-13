package com.raft.feature;

import com.raft.entity.LogEntry;

/**
 * @author NemoWang
 * @date 2020/5/1-16:25
 * 日志相关操作
 */
public interface LogModule {
    void write(LogEntry logEntry);

    LogEntry read(Long index);

    void removeOnStartIndex(Long startIndex);

    LogEntry getLast();

    Long getLastIndex();
}
