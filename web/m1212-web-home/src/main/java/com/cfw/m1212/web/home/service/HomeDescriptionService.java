package com.cfw.m1212.web.home.service;

import com.cfw.m1212.api.DescriptionService;
import com.cfw.m1212.model.Description;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Duskrain on 2017/9/9.
 */
@Service
public class HomeDescriptionService {

    private Log logger = LogFactory.getLog(HomeDescriptionService.class);

    @Autowired
    private DescriptionService remoteDescriptionService;

    /**
     * @author Fangwei_Cai
     * @time since 2016年4月8日 下午4:45:40
     */
    public boolean addDescription(Description description) {
        //DescriptionService.class.get
        try {
            return this.remoteDescriptionService.addDescription(description) > 0;
        } catch (Exception e) {
            this.logger.error(e.getMessage(),e);
        }

        return false;
    }
}
