package com.cfw.m1212.web.home.service;

import com.cfw.m1212.model.db.Type;
import com.cfw.plugins.mq.rabbitmq.rpc.client.dispatch.OutboundDispatcher;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Duskrain on 2017/9/9.
 */
@Service
@Deprecated
public class TypeService {
    @Value("${movies.remote.type}")
    private String remoteServer;

    @Value("${movies.remote.typeService}")
    private String remoteService;

    @Value("${movies.remote.typeService.getAllTypes}")
    private String remoteGetAllTypes;
    @Value("${movies.remote.typeService.addType}")
    private String remoteAddType;

    @Autowired
    private OutboundDispatcher outboundDispatcher;

    private Log logger = LogFactory.getLog(TypeService.class);

    /**
     * @author Fangwei_Cai
     * @time since 2016年4月8日 下午4:35:57
     */
    public List<Type> getAllTypes() {
        try {
            return this.outboundDispatcher.dispatch(remoteServer,remoteService,remoteGetAllTypes,List.class,null);
        } catch (Exception e) {
            this.logger.error(e.getMessage(),e);
        }

        return null;
    }

    /**
     * @author Fangwei_Cai
     * @time since 2016年4月11日 上午11:44:49
     */
    public boolean addType(Type type) {
        try {
            return this.outboundDispatcher.dispatch(remoteServer,remoteService,remoteAddType,Boolean.class,type);
        } catch (Exception e) {
            this.logger.error(e.getMessage(),e);
        }

        return false;
    }
}
