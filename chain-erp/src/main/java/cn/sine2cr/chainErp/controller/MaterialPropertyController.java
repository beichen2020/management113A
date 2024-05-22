package cn.sine2cr.chainErp.controller;

import cn.sine2cr.chainErp.datasource.entities.MaterialProperty;
import cn.sine2cr.chainErp.service.materialProperty.MaterialPropertyService;
import cn.sine2cr.chainErp.utils.BaseResponseInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Description
 *
 * @Author: qiankunpingtai
 * @Date: 2019/3/29 15:24
 */
@RestController
@RequestMapping(value = "/materialProperty")
@Api(tags = {"商品扩展字段"})
public class MaterialPropertyController {

    @Resource
    private MaterialPropertyService materialPropertyService;

    @GetMapping(value = "/getAllList")
    @ApiOperation(value = "查询全部商品扩展字段信息")
    public BaseResponseInfo getAllList(HttpServletRequest request) throws Exception{
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            List<MaterialProperty> list = materialPropertyService.getMaterialProperty();
            res.code = 200;
            res.data = list;
        } catch(Exception e){
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }

}
