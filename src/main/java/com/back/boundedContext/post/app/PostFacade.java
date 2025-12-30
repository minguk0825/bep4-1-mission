package com.back.boundedContext.post.app;

import com.back.boundedContext.post.domain.Post;
import com.back.boundedContext.post.domain.PostMember;
import com.back.global.RsData.RsData;
import com.back.shared.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostFacade {
    private final PostSupport postSupport;
    private final PostWriteUseCase postWriteUseCase;
    private final PostSyncMemberUseCase postSyncMemberUseCase;

    @Transactional(readOnly = true)
    public long count() {
        return postSupport.count();
    }

    @Transactional
    public RsData<Post> write(PostMember author, String title, String content) {
        return postWriteUseCase.write(author, title, content);
    }

    @Transactional(readOnly = true)
    public Optional<Post> findById(int id) {
        return postSupport.findById(id);
    }

    @Transactional
    public PostMember syncMember(MemberDto member) {
        return postSyncMemberUseCase.syncMember(member);
    }

    public Optional<PostMember> findMemberByUsername (String username) {
        return postSupport.findMemberByUsername(username);
    }

    @Transactional(readOnly = true)
    public List<Post> findByOrderByIdDesc() {
        return postSupport.findByOrderByIdDesc();
    }
}
