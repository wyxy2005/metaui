package com.metaui.fxbase.facade;

import com.metaui.core.config.ProjectConfig;
import com.metaui.fxbase.ui.IDesktop;

/**
 *
 * @author wei_jc
 * @version 1.0.0
 */
public interface IFacade {
    /**
     * 获得项目配置信息
     *
     * @return 返回项目配置信息
     * @since 1.0.0
     */
    ProjectConfig getProjectConfig() throws Exception;

    /**
     * 初始化完成
     */
    void initAfter() throws Exception;

    IDesktop getDesktop() throws Exception;
}
