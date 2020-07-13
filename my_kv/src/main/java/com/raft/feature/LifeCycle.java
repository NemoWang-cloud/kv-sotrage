package com.raft.feature;

/**
 * @author NemoWang
 * @date 2020/5/1-16:26
 */
public interface LifeCycle {
    void init() throws Throwable;
    void destory() throws Throwable;
}
