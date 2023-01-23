package com.esther.facebookclone.InterfaceDaoService;

import com.esther.facebookclone.dataTransferObj.UserDto;
import com.esther.facebookclone.model.User;
import lombok.NonNull;

public interface UserDaoService {
    User saveUser(UserDto userDto);

    User findUserByEmailAndPassword(@NonNull String email, @NonNull String password);

}
