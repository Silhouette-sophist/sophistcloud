package com.example.sophistcloud.service.impl;

import com.example.sophistcloud.entity.SimpleUserInfo;
import com.example.sophistcloud.mapper.SimpleUserInfoMapper;
import com.example.sophistcloud.service.ISimpleUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2023-07-16
 */
@Service
public class SimpleUserInfoServiceImpl
        extends ServiceImpl<SimpleUserInfoMapper, SimpleUserInfo>
        implements ISimpleUserInfoService {

}
