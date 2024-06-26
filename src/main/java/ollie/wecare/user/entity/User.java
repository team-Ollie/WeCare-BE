package ollie.wecare.user.entity;

import jakarta.persistence.*;
import lombok.*;
import ollie.wecare.common.base.BaseEntity;
import ollie.wecare.common.enums.Role;
import org.hibernate.annotations.DynamicInsert;

import static ollie.wecare.common.constants.Constants.*;

@Entity
@Getter
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_idx")
    private Long userIdx;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    private String loginId;

    private String password;

    private String nickname;

    private String identifier; //홍길동1234

    @Column(nullable = false, columnDefinition = "integer default 1")
    private Integer level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "center_idx")
    private Center center;

    @Builder
    public User(Role role, String loginId, String password, String nickname, String identifier, Integer level, Center center) {
        this.role = role;
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
        this.identifier = identifier;
        this.level = level;
        this.center = center;
    }

    public void login() {
        this.setStatus(ACTIVE);
    }
    public void logout() {this.setStatus(LOGOUT);}

    public void signout() {this.setStatus(INACTIVE);}

    public void editNickname(String nickname) {this.nickname = nickname;}
    public void editPassword(String password) {this.password = password;}
}
