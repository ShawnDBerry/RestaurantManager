package com.example.restaurantmanagment.util;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Handler;

public class HandlerUtil {
    private Handler uiHandler;

    public static final int CORE_POOL_SIZE = 4;
    public static final int MAX_POOL_SIZE = 5;
    public static final int KEEP_ALIVE_TIME = 3000;

    private BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();
    private List<Runnable> taskList;

    private ThreadPoolExecutor threadPoolExecutor = null;

    public HandlerUtil(Handler uiHandler, List<Runnable> taskList) {
        this.uiHandler = uiHandler;
        this.taskList = taskList;
    }
}
