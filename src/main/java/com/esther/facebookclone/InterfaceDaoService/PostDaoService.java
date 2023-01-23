package com.esther.facebookclone.InterfaceDaoService;

import com.esther.facebookclone.model.ThePost;
import lombok.NonNull;

public interface PostDaoService {
    ThePost postContent(@NonNull String post_content);
}
