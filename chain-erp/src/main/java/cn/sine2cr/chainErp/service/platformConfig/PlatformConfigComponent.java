package cn.sine2cr.chainErp.service.platformConfig;

import com.alibaba.fastjson.JSONObject;
import cn.sine2cr.chainErp.service.ICommonQuery;
import cn.sine2cr.chainErp.utils.Constants;
import cn.sine2cr.chainErp.utils.QueryUtils;
import cn.sine2cr.chainErp.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "platformConfig_component")
@PlatformConfigResource
public class PlatformConfigComponent implements ICommonQuery {

    @Resource
    private PlatformConfigService platformConfigService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return platformConfigService.getPlatformConfig(id);
    }

    @Override
    public List<?> select(Map<String, String> map)throws Exception {
        return getPlatformConfigList(map);
    }

    private List<?> getPlatformConfigList(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String platformKey = StringUtil.getInfo(search, "platformKey");
        return platformConfigService.select(platformKey, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String platformKey = StringUtil.getInfo(search, "platformKey");
        return platformConfigService.countPlatformConfig(platformKey);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request)throws Exception {
        return platformConfigService.insertPlatformConfig(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request)throws Exception {
        return platformConfigService.updatePlatformConfig(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request)throws Exception {
        return platformConfigService.deletePlatformConfig(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request)throws Exception {
        return platformConfigService.batchDeletePlatformConfig(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name)throws Exception {
        return 0;
    }

}
