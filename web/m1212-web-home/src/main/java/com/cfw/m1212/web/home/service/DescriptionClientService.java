package com.cfw.m1212.web.home.service;

import com.cfw.m1212.api.DescriptionsService;
import com.cfw.m1212.model.Description;
import com.cfw.plugins.mq.rabbitmq.rpc.client.dispatch.OutboundDispatcher;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by Duskrain on 2017/9/9.
 */
@Service
@Deprecated
public class DescriptionClientService {

    private DescriptionsService descriptionsService;

    @Value("${movies.remote.description}")
    private String remoteServer;

    @Value("${movies.remote.descriptionService}")
    private String remoteService;

    @Value("${movies.remote.descriptionService.addDescription}")
    private String remoteAddDescription;

    @Autowired
    private OutboundDispatcher outboundDispatcher;

    private Log logger = LogFactory.getLog(DescriptionClientService.class);

    /**
     * @author Fangwei_Cai
     * @time since 2016年4月8日 下午4:45:40
     */
    public boolean addDescription(Description description) {
        //DescriptionsService.class.get
        try {
            return this.outboundDispatcher.dispatch(remoteServer,remoteService,remoteAddDescription,Integer.class,description) > 0;
        } catch (Exception e) {
            this.logger.error(e.getMessage(),e);
        }

        return false;
    }
}
