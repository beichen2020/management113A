package cn.sine2cr.chainErp.datasource.mappers;

import cn.sine2cr.chainErp.datasource.entities.FunctionEx;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface FunctionMapperEx {

    List<FunctionEx> selectByConditionFunction(
            @Param("name") String name,
            @Param("type") String type,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByFunction(
            @Param("name") String name,
            @Param("type") String type);

    int batchDeleteFunctionByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String ids[]);
}
