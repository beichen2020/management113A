package cn.sine2cr.chainErp.controller;

import cn.sine2cr.chainErp.datasource.entities.UserBusiness;
import com.alibaba.fastjson.JSONObject;
import cn.sine2cr.chainErp.service.user.UserService;
import cn.sine2cr.chainErp.service.userBusiness.UserBusinessService;
import cn.sine2cr.chainErp.utils.BaseResponseInfo;
import cn.sine2cr.chainErp.utils.ErpInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.sine2cr.chainErp.utils.ResponseJsonUtil.returnJson;

/**
 * @author ji_sheng_hua jshERP
 */
@RestController
@RequestMapping(value = "/userBusiness")
@Api(tags = {"用户角色模块的关系"})
public class UserBusinessController {
    private Logger logger = LoggerFactory.getLogger(UserBusinessController.class);

    @Resource
    private UserBusinessService userBusinessService;
    @Resource
    private UserService userService;

    /**
     * 获取信息
     * @param keyId
     * @param type
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/getBasicData")
    @ApiOperation(value = "获取信息")
    public BaseResponseInfo getBasicData(@RequestParam(value = "KeyId") String keyId,
                                         @RequestParam(value = "Type") String type,
                                         HttpServletRequest request)throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            List<UserBusiness> list = userBusinessService.getBasicData(keyId, type);
            Map<String, List> mapData = new HashMap<String, List>();
            mapData.put("userBusinessList", list);
            res.code = 200;
            res.data = mapData;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "查询权限失败";
        }
        return res;
    }

    /**
     * 校验存在
     * @param type
     * @param keyId
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/checkIsValueExist")
    @ApiOperation(value = "校验存在")
    public String checkIsValueExist(@RequestParam(value ="type", required = false) String type,
                                   @RequestParam(value ="keyId", required = false) String keyId,
                                   HttpServletRequest request)throws Exception {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        Long id = userBusinessService.checkIsValueExist(type, keyId);
        if(id != null) {
            objectMap.put("id", id);
        } else {
            objectMap.put("id", null);
        }
        return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
    }

    /**
     * 更新角色的按钮权限
     * @param jsonObject
     * @param request
     * @return
     */
    @PostMapping(value = "/updateBtnStr")
    @ApiOperation(value = "更新角色的按钮权限")
    public BaseResponseInfo updateBtnStr(@RequestBody JSONObject jsonObject,
                                         HttpServletRequest request)throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            String roleId = jsonObject.getString("roleId");
            String btnStr = jsonObject.getString("btnStr");
            String keyId = roleId;
            String type = "RoleFunctions";
            int back = userBusinessService.updateBtnStr(keyId, type, btnStr);
            if(back > 0) {
                res.code = 200;
                res.data = "成功";
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "更新权限失败";
        }
        return res;
    }
}
