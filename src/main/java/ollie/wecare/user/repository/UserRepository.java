package ollie.wecare.user.repository;

import ollie.wecare.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLoginId(String loginId);
    Optional<User> findByUserIdxAndStatusEquals(Long userIdx, String status);
    Optional<User> findByLoginIdAndStatusEquals(String loginId, String status);
    boolean existsByNickname(String nickname);
    boolean existsByLoginId(String loginId);
    Optional<User> findByUserIdx(Long userIdx);
}
