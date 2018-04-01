package com.cfw.m1212.web.home.service;

import com.cfw.m1212.api.TypeService;
import com.cfw.m1212.model.db.Type;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Duskrain on 2017/9/9.
 */
@Service
public class HomeTypeService {
    private Log logger = LogFactory.getLog(HomeTypeService.class);

    @Autowired
    private TypeService typeService;

    /**
     * @author Fangwei_Cai
     * @time since 2016年4月8日 下午4:35:57
     */
    public List<Type> getAllTypes() {
        try {
            return this.typeService.getAllTypes();
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
            return this.typeService.addType(type);
        } catch (Exception e) {
            this.logger.error(e.getMessage(),e);
        }

        return false;
    }
}
