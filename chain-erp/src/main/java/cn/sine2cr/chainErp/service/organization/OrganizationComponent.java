package cn.sine2cr.chainErp.service.organization;

import com.alibaba.fastjson.JSONObject;
import cn.sine2cr.chainErp.service.ICommonQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Description
 *
 * @Author: cjl
 * @Date: 2019/3/6 15:09
 */
@Service(value = "organization_component")
@OrganizationResource
public class OrganizationComponent implements ICommonQuery {
    @Resource
    private OrganizationService organizationService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return organizationService.getOrganization(id);
    }

    @Override
    public List<?> select(Map<String, String> parameterMap)throws Exception {
        return getOrganizationList(parameterMap);
    }
    private List<?> getOrganizationList(Map<String, String> map)throws Exception {
        return null;
    }
    @Override
    public Long counts(Map<String, String> parameterMap)throws Exception {
        return null;
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request)throws Exception {
        return organizationService.insertOrganization(obj,request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request)throws Exception {
        return organizationService.updateOrganization(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request)throws Exception {
        return organizationService.deleteOrganization(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request)throws Exception {
        return organizationService.batchDeleteOrganization(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name)throws Exception {
        return organizationService.checkIsNameExist(id, name);
    }
}
