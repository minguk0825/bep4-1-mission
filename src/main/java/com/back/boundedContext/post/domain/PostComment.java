package com.back.boundedContext.post.domain;

import com.back.global.jpa.entity.BaseIdAndTime;
import com.back.shared.post.dto.PostCommentDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name="POST_POST_COMMENT")
@Getter
public class PostComment extends BaseIdAndTime {
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;
    @ManyToOne(fetch = FetchType.LAZY)
    private PostMember author;
    @Column(columnDefinition = "TEXT")
    String content;

    public PostComment(Post post, PostMember author, String content) {
        this.post = post;
        this.author = author;
        this.content = content;
    }

    public PostCommentDto toDto() {
        return new PostCommentDto(
                getId(),
                getCreateDate(),
                getModifyDate(),
                post.getId(),
                author.getId(),
                author.getNickname(),
                content
        );
    }
}