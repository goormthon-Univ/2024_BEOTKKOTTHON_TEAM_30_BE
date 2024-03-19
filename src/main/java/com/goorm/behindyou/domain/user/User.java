package com.goorm.behindyou.domain.user;

import com.goorm.behindyou.domain.common.BaseDateTimeEntity;
import com.goorm.behindyou.domain.keyword.Keyword;
import com.goorm.behindyou.domain.notification.Notification;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseDateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String nickName;

    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String email;

    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String password;

    private Long alarmStatus;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Keyword> keyWordList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Notification> notificationList = new ArrayList<>();
}