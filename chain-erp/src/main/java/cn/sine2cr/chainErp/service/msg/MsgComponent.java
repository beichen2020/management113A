package cn.sine2cr.chainErp.service.msg;

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

@Service(value = "msg_component")
@MsgResource
public class MsgComponent implements ICommonQuery {

    @Resource
    private MsgService msgService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return msgService.getMsg(id);
    }

    @Override
    public List<?> select(Map<String, String> map)throws Exception {
        return getMsgList(map);
    }

    private List<?> getMsgList(Map<String, String> map) throws Exception{
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        String order = QueryUtils.order(map);
        String filter = QueryUtils.filter(map);
        return msgService.select(name, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception{
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        return msgService.countMsg(name);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request)throws Exception {
        return msgService.insertMsg(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request)throws Exception {
        return msgService.updateMsg(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request)throws Exception {
        return msgService.deleteMsg(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request)throws Exception {
        return msgService.batchDeleteMsg(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name)throws Exception {
        return msgService.checkIsNameExist(id, name);
    }

}
