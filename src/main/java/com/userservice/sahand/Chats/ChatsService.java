package com.userservice.sahand.Chats;

import com.userservice.sahand.Bases.BasesService;
import com.userservice.sahand.Jwt.JwtService;
import com.userservice.sahand.Persons.PersonsEntity;
import com.userservice.sahand.Persons.PersonsInterface;
import com.userservice.sahand.UsersSerssion.PrincipalSimple;
import com.userservice.sahand.UsersSerssion.UserSessionInterface;
import com.userservice.sahand.Utils.Remote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatsService extends BasesService<ChatsEntity> implements ChatsInterface {
    @Autowired
    UserSessionInterface userSessionInterface;
    @Autowired
    JwtService jwtService;

    @Override
    public boolean sendMsg(ChatsForm chatsForm) throws Exception {
        String uuid = userSessionInterface.getUuid();
        PrincipalSimple principalSimple = userSessionInterface.checkExistUserSession(uuid);
        userSessionInterface.checkAccess(principalSimple, 8l);
        if (chatsForm.getChatId() == -1) {
            chatsForm.setChatId(null);
        }
        PersonsInterface remote = (PersonsInterface) Remote.getRemote(PersonsInterface.class);
        PersonsEntity personsEntity = (PersonsEntity) remote.find("e.personId = 15 ");
        chatsForm.setJoinSender(principalSimple.getUserid());
        String chatId = super.save(chatsForm);
        if (chatId != null || !chatId.equals("-1")) {
            return true;
        }
        return false;
    }
}
