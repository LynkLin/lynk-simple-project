package com.lynk.datainit;

import com.lynk.base.BaseJunitTest;
import com.lynk.system.security.annotation.RequirePermissions;
import com.lynk.system.security.common.SecurityConstant;
import com.lynk.system.tool.AppManager;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.*;

/**
 * @author Lynk
 * @since 2018/01/10
 */
public class MysqlDataInit extends BaseJunitTest {

    private static final String SQL = "INSERT INTO SYS_PERMISSION (id, name, is_request, url, method, sequence, parent_id, gmt_create, gmt_modified) VALUES (''{0}'', ''{1}'', {2}, ''{3}'', ''{4}'', {5}, ''{6}'', NOW(), NULL);";

    @Test
    @DisplayName("生成权限SQL")
    public void initPermission() {
        String rootSQL = MessageFormat.format(SQL, "ROOT", "ROOT", 0, "", "", 0, "");
        System.out.println(rootSQL);

        Map<String, Object> controllerBeans = AppManager.getBeansWithAnnotation(RequirePermissions.class);
        int groupStart = 100;
        for (Object controllerBean: controllerBeans.values()) {
            Class controllerClass = controllerBean.getClass();

            RequirePermissions classAnnotation = AnnotationUtils.findAnnotation(controllerClass, RequirePermissions.class);

            String sqlGroup = MessageFormat.format(SQL, classAnnotation.id(), classAnnotation.name(), 0, "", "", groupStart, "ROOT");
            System.out.println(sqlGroup);

            Method[] classMethods = controllerClass.getMethods();
            for (Method classMethod: classMethods) {
                RequirePermissions methodAnnotation = AnnotationUtils.findAnnotation(classMethod, RequirePermissions.class);
                if (methodAnnotation == null) {
                    continue;
                }

                String[] permissionArray = methodAnnotation.value();
                if (permissionArray.length != 1) {
                    continue;
                }

                String permissionStr = permissionArray[0];
                int index = permissionStr.indexOf(SecurityConstant.PERMISSION_SPLIT);
                if (index == -1) {
                    continue;
                }

                String url = permissionStr.substring(0, index);
                String method = permissionStr.substring(index + 1);

                //order: POST, DELETE, PUT, PATCH, GET, GET{id}
                int sequence = groupStart;
                if (permissionStr.contains("POST")) {
                    sequence += 10;
                } else if (permissionStr.contains("DELETE")) {
                    sequence += 20;
                } else if (permissionStr.contains("PUT")) {
                    sequence += 30;
                } else if (permissionStr.contains("PATCH")) {
                    sequence += 40;
                } else if (permissionStr.contains("GET") && !permissionStr.contains("{id}")) {
                    sequence += 50;
                } else if (permissionStr.contains("GET")) {
                    sequence += 60;
                } else {
                    sequence += 70;
                }

                String sqlRequest = MessageFormat.format(SQL, methodAnnotation.id(), methodAnnotation.name(), 1, url, method, sequence, classAnnotation.id());
                System.out.println(sqlRequest);
            }
            groupStart += 100;
        }
    }
}
