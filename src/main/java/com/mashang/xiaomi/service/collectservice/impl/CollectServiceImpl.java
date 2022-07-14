package com.mashang.xiaomi.service.collectservice.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mashang.xiaomi.mapper.CollectMapper;
import com.mashang.xiaomi.mapper.ProductMapper;
import com.mashang.xiaomi.pojo.PO.Collect;
import com.mashang.xiaomi.pojo.VO.CollectVO;
import com.mashang.xiaomi.pojo.VO.UserInfo;
import com.mashang.xiaomi.service.collectservice.CollectService;
import com.mashang.xiaomi.service.userservice.UserService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CollectServiceImpl implements CollectService {
    //获取userid
    @Autowired
    private UserService userService;

    @Autowired
    private CollectMapper collectMapper;
    //引入之前的方法
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<CollectVO> findMyCollectByToken(String token) throws Exception {
        UserInfo info = userService.getInfo(token);
        Long userId = info.getUserId();
        List<CollectVO> myCollectByuserId = collectMapper.findMyCollectByuserId(userId);
        return myCollectByuserId;
    }

    @Override
    public Integer changeCollectState(String token,Long productId) throws Exception {
        UserInfo info = userService.getInfo(token);
        Long userId = info.getUserId();
        Long flag = productMapper.isConlltion(userId, productId);
        //不为1就插入
        int num = 0;
        if (flag!=1){
            Collect collect = new Collect();
            collect.setUserId(userId);
            collect.setProductId(productId);
            num = collectMapper.insert(collect);
        }else{
            QueryWrapper<Collect> collectQueryWrapper = new QueryWrapper<>();
            collectQueryWrapper.eq("user_id",userId)
                                .eq("product_id",productId);
            num = collectMapper.delete(collectQueryWrapper);
        }
        return num;
    }
}
