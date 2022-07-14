package com.mashang.xiaomi.service.collectservice;

import com.mashang.xiaomi.pojo.VO.CollectVO;

import java.util.List;

public interface CollectService {

    List<CollectVO> findMyCollectByToken(String token) throws Exception;


    Integer changeCollectState(String toke,Long productId) throws Exception;
}
