package com.momstouch.momstouchbe.global.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public abstract class BaseTime {

    @CreatedDate
    protected String createdAt;

    @LastModifiedDate
    private String lastModifiedAt;

    @PrePersist
    public void onPrePersist(){
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        this.lastModifiedAt = this.createdAt;
    }

    @PreUpdate
    public void onPreUpdate(){
        this.lastModifiedAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
    }
}
