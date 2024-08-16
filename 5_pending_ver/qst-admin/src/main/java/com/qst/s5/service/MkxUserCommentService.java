package com.qst.s5.service;

import com.qst.s5.domain.MkxUserCommentForm;

public interface MkxUserCommentService {
    String add_user_comment(MkxUserCommentForm mkxUserCommentForm,
                            String user_name);
}
