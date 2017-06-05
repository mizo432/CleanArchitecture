package biz.paluch.clean.architecture.external.mybatis.repository;

import biz.paluch.clean.architecture.applicationmodel.NotFoundException;
import biz.paluch.clean.architecture.applicationmodel.User;
import biz.paluch.clean.architecture.contracts.repositories.UserRepository;
import jp.or.venuspj.utils.Objects2;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisUserRepository implements UserRepository {
    UserMapper userMapper;

    public MybatisUserRepository(UserMapper anUserMapper) {
        userMapper = anUserMapper;

    }

    @Override
    public User find(String anUserName) {
        User user = userMapper.find(anUserName);
        if (Objects2.nonNull(user))
            return user;
        throw new NotFoundException("user Not Found. userName:" + anUserName);
    }

    @Override
    public void store(User anUser) {
        User user = userMapper.find(anUser.userName());
        if (Objects2.nonNull(user)) {
            userMapper.insert(anUser);

        }

    }

}
