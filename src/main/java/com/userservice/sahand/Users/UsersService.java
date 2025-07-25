package com.userservice.sahand.Users;

import com.userservice.sahand.Bases.BasesDel;
import com.userservice.sahand.Bases.BasesService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService extends BasesService<UsersEntity> implements UsersInterface {
    @Autowired
    EntityManager entityManager;

    @Override
    public UsersEntity findUserId(String userId) throws UsernameNotFoundException {
        UsersEntity user = entityManager.
                createQuery("select u from UsersEntity u " +
                                "where u.userId = :userId and u.deleted = false and u.enabled = true",
                        UsersEntity.class).setParameter("userId", userId).getResultList().get(0);
        return user == null ? null : user;
    }

    @Override
    @Transactional
    public UsersEntity findUsername(String username) throws UsernameNotFoundException {
        List<UsersEntity> user = entityManager.
                createQuery("select u from UsersEntity u " +
                                "where u.userName = :username and u.deleted = false and u.enabled = true",
                        UsersEntity.class)
                .setParameter("username", username).getResultList();
        return user.isEmpty() ? null : user.get(0);
    }

    @Override
    @Transactional
    public String userRegistration(UsersForm usersForm) throws Exception {
        UsersEntity users = (UsersEntity) find("userName = '" + usersForm.getUserName() + "' and deleted = false and enabled = true");
        if (users != null) {
            return "user already exists";
        }
        ;
        if (usersForm.getUserId() == -1) {
            usersForm.setUserId(null);
        }
        String id = super.save(usersForm);
        if (id != null) {
            return id;
        }
        return "-1";
    }

    @Override
    @Transactional
    public boolean delUser(BasesDel userId) throws Exception {
        if (userId.getId().equals("-1")) {
            return false;
        }
        UsersEntity users = findUserId(userId.getId());
        if (users == null) {
            return false;
        }
        users.setDeleted(true);
        String id = super.saveEntity(users);
        if (id != null) {
            return true;
        }
        return false;
    }
}
