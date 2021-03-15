package com.hanjie.opt.example.opt;

import kim.hanjie.common.opt.IOptLogRecorder;
import kim.hanjie.common.opt.OptLogRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author han
 * @date 2021/3/14
 */
@Component
public class AdminOptRecorder implements IOptLogRecorder {

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminOptRecorder.class);

    /**
     * 是否支持记录这种操作
     *
     * @param record 记录
     * @return true/false
     */
    @Override
    public boolean support(OptLogRecord record) {
        return record.getContextValue("adminId") != null;
    }

    /**
     * 记录操作日志
     *
     * @param record 记录
     */
    @Override
    public void record(OptLogRecord record) {
        LOGGER.error("<----------------->");
        LOGGER.error(record.toString());
        LOGGER.error(record.getOptDescription());
        LOGGER.error(record.getContextValue("adminId"));
        LOGGER.error("<----------------->");
    }
}
