package cn.sine2cr.chainErp.datasource.mappers;

import cn.sine2cr.chainErp.datasource.entities.AccountHead;
import cn.sine2cr.chainErp.datasource.entities.AccountHeadVo4ListEx;
import cn.sine2cr.chainErp.datasource.entities.AccountItem;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AccountHeadMapperEx {

    List<AccountHeadVo4ListEx> selectByConditionAccountHead(
            @Param("type") String type,
            @Param("creatorArray") String[] creatorArray,
            @Param("billNo") String billNo,
            @Param("beginTime") String beginTime,
            @Param("endTime") String endTime,
            @Param("organId") Long organId,
            @Param("creator") Long creator,
            @Param("handsPersonId") Long handsPersonId,
            @Param("accountId") Long accountId,
            @Param("status") String status,
            @Param("remark") String remark,
            @Param("number") String number,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByAccountHead(
            @Param("type") String type,
            @Param("creatorArray") String[] creatorArray,
            @Param("billNo") String billNo,
            @Param("beginTime") String beginTime,
            @Param("endTime") String endTime,
            @Param("organId") Long organId,
            @Param("creator") Long creator,
            @Param("handsPersonId") Long handsPersonId,
            @Param("accountId") Long accountId,
            @Param("status") String status,
            @Param("remark") String remark,
            @Param("number") String number);

    List<AccountHeadVo4ListEx> getDetailByNumber(
            @Param("billNo") String billNo);

    int batchDeleteAccountHeadByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String[] ids);

    List<AccountHead> getAccountHeadListByAccountIds(@Param("accountIds") String[] accountIds);

    List<AccountHead> getAccountHeadListByOrganIds(@Param("organIds") String[] organIds);

    List<AccountHead> getAccountHeadListByHandsPersonIds(@Param("handsPersonIds") String[] handsPersonIds);

    List<AccountItem> getFinancialBillNoByBillIdList(
            @Param("idList") List<Long> idList);

    List<AccountHead> getFinancialBillNoByBillId(
            @Param("billId") Long billId);
}
