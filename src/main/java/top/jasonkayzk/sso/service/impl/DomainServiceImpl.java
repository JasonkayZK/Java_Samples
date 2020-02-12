package top.jasonkayzk.sso.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.jasonkayzk.sso.entity.Domain;
import top.jasonkayzk.sso.mapper.DomainMapper;
import top.jasonkayzk.sso.service.DomainService;

import java.util.List;

/**
 * 子系统（域名）管理业务层实现类
 *
 * @author zk
 */
@Service("domainService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DomainServiceImpl extends ServiceImpl<DomainMapper, Domain> implements DomainService {

    @Override
    public List<Domain> selectAll() {
        return this.baseMapper.selectList(null);
    }
}
