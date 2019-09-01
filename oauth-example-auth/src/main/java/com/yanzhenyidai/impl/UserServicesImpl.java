package com.yanzhenyidai.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yanzhenyidai.auth.entity.SysUser;
import com.yanzhenyidai.auth.mapper.SysRoleMapper;
import com.yanzhenyidai.auth.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashSet;

/**
 * @author frank
 * @version 1.0
 * @date 2019-08-23 15:00
 */
@Service
public class UserServicesImpl implements UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<SysUser>();
        wrapper.eq(SysUser::getUsername, userName);
        SysUser sysUser = sysUserMapper.selectOne(wrapper);

        Assert.notNull(sysUser, "用户信息不存在");

        return new User(userName, sysUser.getPassword(), new HashSet<GrantedAuthority>());
    }
}
