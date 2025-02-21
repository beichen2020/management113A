package cn.sine2cr.chainErp.datasource.mappers;

import cn.sine2cr.chainErp.datasource.entities.Organization;
import cn.sine2cr.chainErp.datasource.vo.TreeNode;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Description
 *
 * @Author: cjl
 * @Date: 2019/3/6 15:51
 */
public interface OrganizationMapperEx {


    List<TreeNode> getNodeTree(@Param("currentId")Long currentId);
    List<TreeNode> getNextNodeTree(Map<String, Object> parameterMap);

    int addOrganization(Organization org);

    List <Organization> getOrganizationByParentIds(@Param("ids") String ids[]);

    int batchDeleteOrganizationByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String ids[]);

    int editOrganization(Organization org);
    List <Organization> getOrganizationRootByIds(@Param("ids") String ids[]);
}
