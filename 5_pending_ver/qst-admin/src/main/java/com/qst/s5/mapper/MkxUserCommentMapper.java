package com.qst.s5.mapper;

import com.qst.s5.domain.MkxLoanForm;
import com.qst.s5.domain.MkxUserCommentForm;
import org.apache.ibatis.annotations.Param;

@org.apache.ibatis.annotations.Mapper
public interface MkxUserCommentMapper {
    int add_user_comment(@Param("data") MkxUserCommentForm data);
}
